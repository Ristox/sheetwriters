package org.example.workbook.sheetwriters;

import static java.util.stream.Collectors.toCollection;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;
import org.example.workbook.sheetwriters.data.Model1;
import org.example.workbook.sheetwriters.data.Response;
import org.example.workbook.sheetwriters.workbook.Sheet;
import org.example.workbook.sheetwriters.workbook.Workbook;
import org.example.workbook.sheetwriters.writers.SheetWriter;
import org.example.workbook.sheetwriters.writers.WritableModel;
import org.example.workbook.sheetwriters.writers.Writers;

public class ResponseConverter {

    private final Writers factory;
    private final Map<Class<? extends WritableModel>, SheetWriter<? extends WritableModel>> writers;

    public ResponseConverter(Writers factory) {
        this.factory = factory;
        this.writers = new HashMap<>();
    }

    public Workbook toWorkbook(Response response) {
        Set<Sheet> sheets = streamAllItemsIn(response)
            .map(model -> getWriter(model).write(model))
            .collect(toCollection(LinkedHashSet::new));

        return new Workbook(sheets.toArray(new Sheet[] {}));
    }

    private Stream<WritableModel> streamAllItemsIn(Response response) {
        List<Model1> mainModels = response.getModels();
        Stream<WritableModel> childrenStream = mainModels.stream().flatMap(this::streamChildren);

        return Stream.concat(mainModels.stream(), childrenStream);
    }

    private Stream<? extends WritableModel> streamChildren(Model1 model) {
        return model.getChildren().stream();
    }

    @SuppressWarnings("unchecked")
    private <M extends WritableModel> SheetWriter<M> getWriter(M model) {
        if (!writers.containsKey(model.getClass())) {
            writers.put(model.getClass(), factory.writerFor(model));
        }
        return (SheetWriter<M>) writers.get(model.getClass());
    }

}

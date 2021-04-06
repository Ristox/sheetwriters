package org.example.workbook.sheetwriters.writers;

import static java.util.Objects.isNull;

import java.util.HashMap;
import java.util.Map;
import org.example.workbook.sheetwriters.data.Model1;
import org.example.workbook.sheetwriters.data.Model2;

public class Writers {
    private static final Map<Class<? extends WritableModel>,
        WriterFactory<? extends WritableModel, ? extends SheetWriter<?>>> factories;

    static {
        factories = new HashMap<>();
        factories.put(Model1.class, new Model1WriterFactory());
        factories.put(Model2.class, new Model2WriterFactory());
    }

    @SuppressWarnings("unchecked")
    public <M extends WritableModel> SheetWriter<M> writerFor(M model) {
        Class<? extends WritableModel> modelClass = model.getClass();
        if (isNull(factories.get(modelClass))) {
            throw new UnsupportedOperationException("No Writer for the provided Model's type (" + modelClass + ")");
        }
        return (SheetWriter<M>) factories.get(modelClass).get();
    }
}

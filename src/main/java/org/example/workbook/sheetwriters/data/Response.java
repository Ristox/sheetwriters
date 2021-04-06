package org.example.workbook.sheetwriters.data;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;

public class Response {
    private final List<Model1> models = new ArrayList<>();

    public Response(Model1... models) {
        this.models.addAll(asList(models));
    }

    public List<Model1> getModels() {
        return new ArrayList<>(models);
    }

    public void addModel(Model1 model) {
        models.add(model);
    }
}

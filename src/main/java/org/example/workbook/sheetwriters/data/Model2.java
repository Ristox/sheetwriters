package org.example.workbook.sheetwriters.data;

import static java.util.stream.Collectors.toList;

import java.util.List;
import org.example.workbook.sheetwriters.blackbox.ExternalModel2;
import org.example.workbook.sheetwriters.writers.WritableModel;

public class Model2 implements WritableModel {

    public static Model2 wrap(ExternalModel2 externalModel) {
        return new Model2(externalModel);
    }

    public static List<Model2> wrapAll(List<ExternalModel2> externalModels) {
        return externalModels.stream().map(Model2::wrap).collect(toList());
    }

    public static List<ExternalModel2> toDelegates(List<Model2> model2List) {
        return model2List.stream().map(Model2::toDelegate).collect(toList());
    }

    private final ExternalModel2 delegate;

    public Model2(String title, int value) {
        this.delegate = new ExternalModel2(title, value);
    }

    private Model2(ExternalModel2 delegate) {
        this.delegate = delegate;
    }

    public String toString() {
        return this.delegate.toString();
    }

    public ExternalModel2 toDelegate() {
        return this.delegate;
    }
}

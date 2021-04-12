package org.example.workbook.sheetwriters.data;

import java.util.List;
import org.example.workbook.sheetwriters.blackbox.ExternalModel1;
import org.example.workbook.sheetwriters.writers.WritableModel;

public class Model1 implements WritableModel {

    private final ExternalModel1 delegate;

    public Model1(String name) {
        delegate = new ExternalModel1(name);
    }

    @Override
    public String toString() {
        return this.delegate.toString();
    }

    public void setChildren(List<Model2> children) {
        this.delegate.setChildren(Model2.toDelegates(children));
    }

    public String getName() {
        return this.delegate.getName();
    }

    public int getChildCount() {
        return this.delegate.getChildCount();
    }

    public List<Model2> getChildren() {
        return Model2.wrapAll(this.delegate.getChildren());
    }
}

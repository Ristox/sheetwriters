package org.example.workbook.sheetwriters.data;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.workbook.sheetwriters.writers.WritableModel;

@RequiredArgsConstructor
public class Model1 implements WritableModel {

    private final String name;
    private final List<Model2> children = new ArrayList<>();

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " = " + this.name;
    }

    public void setChildren(List<Model2> children) {
        this.children.clear();
        this.children.addAll(children);
    }

    public String getName() {
        return name;
    }

    public int getChildCount() {
        return children.size();
    }

    public List<Model2> getChildren() {
        return new ArrayList<>(this.children);
    }
}

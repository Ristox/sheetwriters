package org.example.workbook.sheetwriters.data;

import lombok.RequiredArgsConstructor;
import org.example.workbook.sheetwriters.writers.WritableModel;

@RequiredArgsConstructor
public class Model2 implements WritableModel {

    private final String title;
    private final int value;

    public String toString() {
        return this.getClass().getSimpleName() + ": " + this.title + " (" + this.value + ")";
    }
}

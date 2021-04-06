package org.example.workbook.sheetwriters.workbook;

import static java.lang.String.join;

import java.util.ArrayList;
import java.util.List;

public class Sheet {

    private final List<String> rows = new ArrayList<>();

    public void addRow(String value) {
        rows.add(value);
    }

    public String toString() {
        return join("\n", rows);
    }

}

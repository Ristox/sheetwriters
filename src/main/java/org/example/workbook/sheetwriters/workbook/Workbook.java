package org.example.workbook.sheetwriters.workbook;

import static java.util.Arrays.asList;

import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Workbook {

    private final List<Sheet> sheets;

    public Workbook(Sheet... sheets) {
        this.sheets = asList(sheets);
    }

    public List<Sheet> getSheets() {
        return sheets;
    }
}

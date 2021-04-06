package org.example.workbook.sheetwriters.writers;

import org.example.workbook.sheetwriters.data.Model2;
import org.example.workbook.sheetwriters.workbook.Sheet;

class Model2Writer implements SheetWriter<Model2> {

    private final Sheet outputSheet = new Sheet();

    @Override
    public Sheet write(Model2 model) {
        outputSheet.addRow(model.toString());
        return outputSheet;
    }
}

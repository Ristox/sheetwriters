package org.example.workbook.sheetwriters.writers;

import org.example.workbook.sheetwriters.data.Model1;
import org.example.workbook.sheetwriters.workbook.Sheet;

class Model1Writer implements SheetWriter<Model1> {

    private final Sheet outputSheet;

    public Model1Writer() {
        this.outputSheet = new Sheet();
    }

    @Override
    public Sheet write(Model1 model) {
        outputSheet.addRow(model.getName() + ": has " + model.getChildCount() + " children");
        return outputSheet;
    }
}

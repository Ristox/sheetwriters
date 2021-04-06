package org.example.workbook.sheetwriters.writers;

import org.example.workbook.sheetwriters.data.Model1;

class Model1WriterFactory implements
    WriterFactory<Model1, Model1Writer> {
    @Override
    public Model1Writer get() {
        return new Model1Writer();
    }
}

package org.example.workbook.sheetwriters.writers;

import org.example.workbook.sheetwriters.data.Model2;

class Model2WriterFactory implements
    WriterFactory<Model2, Model2Writer> {
    @Override
    public Model2Writer get() {
        return new Model2Writer();
    }
}

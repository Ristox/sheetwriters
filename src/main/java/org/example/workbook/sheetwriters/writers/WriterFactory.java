package org.example.workbook.sheetwriters.writers;

@FunctionalInterface
interface WriterFactory<M extends WritableModel, W extends SheetWriter<M>> {
    W get();
}


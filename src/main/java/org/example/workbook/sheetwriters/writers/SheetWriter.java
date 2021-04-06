package org.example.workbook.sheetwriters.writers;

import org.example.workbook.sheetwriters.workbook.Sheet;

@FunctionalInterface
public interface SheetWriter<M extends WritableModel> {
    Sheet write(M model);
}

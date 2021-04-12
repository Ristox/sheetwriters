package org.example.workbook.sheetwriters.blackbox;

/**
 *  Pretend this is a "black-box" library class eg you know the public interface, but cannot change it
 */
public final class ExternalModel2 {
  private final String title;
  private final int value;

  public ExternalModel2(String title, int value) {
    this.title = title;
    this.value = value;
  }

  public String toString() {
    return this.getClass().getSimpleName() + ": " + this.title + " (" + this.value + ")";
  }
}

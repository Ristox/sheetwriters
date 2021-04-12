package org.example.workbook.sheetwriters.blackbox;

import java.util.ArrayList;
import java.util.List;

/**
 *  Pretend this is a "black-box" library class eg you know the public interface, but cannot change it
 */
public final class ExternalModel1 {
  private final String name;
  private final List<ExternalModel2> children = new ArrayList<>();

  public ExternalModel1(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return this.getClass().getSimpleName() + " = " + this.name;
  }

  public void setChildren(List<ExternalModel2> children) {
    this.children.clear();
    this.children.addAll(children);
  }

  public String getName() {
    return name;
  }

  public int getChildCount() {
    return children.size();
  }

  public List<ExternalModel2> getChildren() {
    return new ArrayList<>(this.children);
  }
}

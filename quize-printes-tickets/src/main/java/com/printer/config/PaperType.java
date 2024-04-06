package com.printer.config;

public enum PaperType {
  C2(58), // 58mm
  C3(80), // 80mm
  C4(112); // 112mm

  private final int size;

  PaperType(int size) {
    this.size = size;
  }

  public int getSize() {
    return size;
  }
}

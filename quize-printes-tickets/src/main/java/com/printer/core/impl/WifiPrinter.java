package com.printer.core.impl;

import com.printer.config.PrinterConfiguration;
import com.printer.core.Printer;

public class WifiPrinter extends Printer {

  public WifiPrinter(PrinterConfiguration config) {
    super(config);
  }

  @Override
  public boolean printByC2(String content) {
    System.out.println("WifiPrinter Printing by C2: " + content);
    return true;
  }

  @Override
  public boolean printByC3(String content) {
    System.out.println("WifiPrinter Printing by C3: " + content);
    return true;
  }

  @Override
  public boolean printByC4(String content) {
    System.out.println("WifiPrinter Printing by C4: " + content);
    return true;
  }
}

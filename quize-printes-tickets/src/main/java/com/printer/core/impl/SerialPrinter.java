package com.printer.core.impl;

import com.printer.config.PrinterConfiguration;
import com.printer.core.Printer;

public class SerialPrinter extends Printer {

  public SerialPrinter(PrinterConfiguration config) {
    super(config);
  }

  @Override
  protected boolean printByC2(String content) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'printByC2'");
  }

  @Override
  protected boolean printByC3(String content) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'printByC3'");
  }

  @Override
  protected boolean printByC4(String content) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'printByC4'");
  }

}

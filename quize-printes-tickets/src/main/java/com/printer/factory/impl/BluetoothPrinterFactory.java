package com.printer.factory.impl;

import com.printer.config.PrinterConfiguration;
import com.printer.core.Printer;
import com.printer.core.impl.BluetoothPrinter;
import com.printer.factory.PrinterFactory;

public class BluetoothPrinterFactory extends PrinterFactory {

  public BluetoothPrinterFactory(PrinterConfiguration config) {
    super(config);
  }

  @Override
  public Printer createPrinter() {
    return new BluetoothPrinter(this.config);
  }

  @Override
  public boolean checkConnection(Printer printer) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'checkConnection'");
  }

  @Override
  public void sendHeartbeat(Printer printer) {
    System.out.println("Sending heartbeat to: " + printer.getConfiguration().getIpAddr());
    printer.sendHeartbeat();
  }

  @Override
  public void disconnectPrinter(Printer printer) {
    printer.disconnect();
  }

  @Override
  public void notifyPaperEmpty(Printer printer) {
    System.out.println("Printer " + printer.getConfiguration().getIpAddr() + " is out of paper.");
  }

  @Override
  public boolean connection(Printer printer) {
    return printer.connection();
  }

  @Override
  public String getPrinterStatus(Printer printer) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getPrinterStatus'");
  }
}

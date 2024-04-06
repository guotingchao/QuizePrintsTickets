package com.printer.factory.impl;

import com.printer.config.PrinterConfiguration;
import com.printer.core.Printer;
import com.printer.core.impl.WifiPrinter;
import com.printer.factory.PrinterFactory;

public class WifiPrinterFactory extends PrinterFactory {

  public WifiPrinterFactory(PrinterConfiguration config) {
    super(config);
  }

  @Override
  public WifiPrinter createPrinter() {
    return new WifiPrinter(this.config);
  }

  @Override
  public boolean checkConnection(Printer printer) {
    return printer.isConnection();
  }

  @Override
  public String getPrinterStatus(Printer printer) {
    return "Ready";
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
}

package com.printer.factory;

import com.printer.config.PrinterConfiguration;
import com.printer.core.Printer;
import com.printer.factory.impl.BluetoothPrinterFactory;
import com.printer.factory.impl.WifiPrinterFactory;

public abstract class PrinterFactory {

  public PrinterConfiguration config;

  public PrinterFactory(PrinterConfiguration config) {
    this.config = config;
  }

  public static PrinterFactory getPrinterFactory(PrinterConfiguration config) {
    switch (config.getPrinterType()) {
      case WIFI:
        return new WifiPrinterFactory(config);
      case BLUETOOTH:
        return new BluetoothPrinterFactory(config);
      default:
        return null;
    }
  }

  public abstract Printer createPrinter();

  /**
   * 连接打印机
   *
   * @param printer - Printer 打印机实例
   * @return boolean 连接状态
   */
  public abstract boolean connection(Printer printer);

  /**
   * 检测打印机连接状态
   *
   * @param printer - Printer 打印机实例
   * @return boolean 连接状态
   */
  public abstract boolean checkConnection(Printer printer);

  /**
   * 获取打印机状态
   *
   * @param printer - Printer 打印机实例
   * @return String 打印机状态
   */
  public abstract String getPrinterStatus(Printer printer);

  /**
   * 发送心跳信号
   *
   * @param printer - Printer 打印机实例
   */
  public abstract void sendHeartbeat(Printer printer);

  /**
   * 断开打印机连接
   *
   * @param printer - Printer 打印机实例
   */
  public abstract void disconnectPrinter(Printer printer);

  /**
   * 提醒打印机缺纸
   *
   * @param printer - Printer 打印机实例
   */
  public abstract void notifyPaperEmpty(Printer printer);
}

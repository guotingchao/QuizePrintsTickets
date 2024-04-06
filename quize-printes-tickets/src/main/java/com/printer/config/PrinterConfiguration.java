package com.printer.config;

// 打印机配置
public class PrinterConfiguration {
  private String ipAddr; // 打印机IP地址
  private int port; // 打印机端口
  private PrinterType printerType; // 打印机类型
  private PaperType paperType; // 纸张类型
  private String version; // 程序版本

  public PrinterConfiguration(String ipAddr, int port, PrinterType printerType, PaperType paperType, String version) {
    this.ipAddr = ipAddr;
    this.port = port;
    this.printerType = printerType;
    this.paperType = paperType;
    this.version = version;
  }

  public String getIpAddr() {
    return ipAddr;
  }

  public void setIpAddr(String ipAddr) {
    this.ipAddr = ipAddr;
  }

  public int getPort() {
    return port;
  }

  public void setPort(int port) {
    this.port = port;
  }

  public PrinterType getPrinterType() {
    return printerType;
  }

  public void setPrinterType(PrinterType printerType) {
    this.printerType = printerType;
  }

  public PaperType getPaperType() {
    return paperType;
  }

  public void setPaperType(PaperType paperType) {
    this.paperType = paperType;
  }

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

}

package com.printer.core;

import com.printer.config.PrinterConfiguration;

/**
 * 打印机接口
 */
public abstract class Printer {
  PrinterConfiguration config;
  private boolean connection;

  /**
   * 构造函数
   */
  public Printer(PrinterConfiguration config) {
    this.config = config;
  }

  /**
   * 连接打印机
   */
  public boolean connection() {
    if (!this.config.getIpAddr().isEmpty() && this.config.getPort() > 0) {
      // connection....
      this.connection = true;
    }
    return this.connection;
  }

  /**
   * 断开打印机连接
   */
  public void disconnect() {
    System.out.println("Disconnecting printer: " + this.config.getIpAddr());
    this.connection = false;
  }

  public void sendHeartbeat() {
    System.out.println("Sending heartbeat to: " + this.config.getIpAddr());
  }

  /**
   * 获取打印机配置
   */
  public PrinterConfiguration getConfiguration() {
    return this.config;
  };

  /**
   * 打印
   */
  public boolean print(String content) {
    System.err.println("Unimplemented method 'print'");
    switch (this.config.getPaperType()) {
      case C2:
        return printByC2(content);
      case C3:
        return printByC3(content);
      case C4:
        return printByC4(content);
      default:
        break;
    }
    return false;
  }

  // 打印 C2 纸张
  protected abstract boolean printByC2(String content);

  // 打印 C3 纸张
  protected abstract boolean printByC3(String content);

  // 打印 C4 纸张
  protected abstract boolean printByC4(String content);

  public boolean isConnection() {
    return this.connection;
  }

}

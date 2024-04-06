package com.printer;

import com.printer.config.PaperType;
import com.printer.config.PrinterConfiguration;
import com.printer.config.PrinterType;
import com.printer.core.Printer;
import com.printer.factory.PrinterFactory;

public class App {
    public static void main(String[] args) {
        PrinterConfiguration wifiConfig = new PrinterConfiguration("127.1", 9090, PrinterType.WIFI, PaperType.C2,
                "1.0.0");
        PrinterConfiguration btConfig = new PrinterConfiguration("127.1", 9090, PrinterType.BLUETOOTH, PaperType.C2,
                "1.0.0");
        PrinterFactory wiFactory = PrinterFactory.getPrinterFactory(wifiConfig);
        PrinterFactory btFactory = PrinterFactory.getPrinterFactory(btConfig);

        Printer wifiPrint = wiFactory.createPrinter();
        Printer btPrinter = btFactory.createPrinter();

        wifiPrint.connection();
        wifiPrint.print("Hello World!");

        btPrinter.connection();
        btPrinter.print("Hello World!");

        btPrinter.sendHeartbeat();
        btFactory.sendHeartbeat(btPrinter);
    }
}

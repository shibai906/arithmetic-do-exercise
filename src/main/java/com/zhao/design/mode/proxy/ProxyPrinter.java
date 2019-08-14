package com.zhao.design.mode.proxy;

public class ProxyPrinter implements Printable {

    String name;
    Printer printer = null;

    // 代理能做的事情自己做
    @Override
    public void setPrinterName(String name) {
        if(printer != null) {
            printer.setPrinterName(name);
        }
        this.name = name;
    }

    @Override
    public String getPrinterName() {
        return name;
    }

    @Override
    public void print(String word) {
        check();
        printer.print(word);
    }

    private synchronized void check() {
        if(printer == null) {
            printer=new Printer(name);
        }
    }
}

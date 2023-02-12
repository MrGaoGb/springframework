package com.series.demo.service;

/**
 * @author: Mr.Gao
 * @date: 2022年05月26日 17:57
 * @description:
 */
public class ImportService3 {

    private ImportService1 importService1;

    public ImportService1 getImportService1() {
        return importService1;
    }

    public void setImportService1(ImportService1 importService1) {
        this.importService1 = importService1;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ImportService3{");
        sb.append("importService1=").append(importService1);
        sb.append('}');
        return sb.toString();
    }
}

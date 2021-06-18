package ru.mai;

import java.io.IOException;

public class JavaExelMainClass {

    public static void main(String[] args) throws IOException {

        ExcelCreatingClass exc = new ExcelCreatingClass();
        exc.creater();
        ExcelReadingClass exr = new ExcelReadingClass();
        exr.reader();
    }
}


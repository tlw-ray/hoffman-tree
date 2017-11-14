package com.tlw.haffman;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class TextFileFilter extends FileFilter {

    public boolean accept(File f) {
        String name = f.getName();
        return f.isDirectory() || name.length() >= 4 && name.substring(name.length() - 4).equals(".txt");
    }

    public String getDescription() {
        return "Text Files (*.txt)";
    }
}

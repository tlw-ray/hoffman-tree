package com.tlw.haffman;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Terminator extends WindowAdapter {
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}

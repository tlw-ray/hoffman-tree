package com.tlw.haffman;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FontSizeListener implements ActionListener {
    private HuffmanFrame parent;
    private int size;

    public FontSizeListener(HuffmanFrame f, int i) {
        this.parent = f;
        this.size = i;
    }

    public void actionPerformed(ActionEvent e) {
        this.parent.setFontSize(this.size);
    }
}
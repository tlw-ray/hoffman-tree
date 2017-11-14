package com.tlw.haffman;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FontStyleListener implements ActionListener {
    private HuffmanFrame parent;

    public FontStyleListener(HuffmanFrame f) {
        this.parent = f;
    }

    public void actionPerformed(ActionEvent e) {
        this.parent.setFontStyle();
    }
}
package com.tlw.haffman;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextEntryListener implements ActionListener {
    private Driver theDriver;

    public TextEntryListener(Driver d) {
        this.theDriver = d;
    }

    public void actionPerformed(ActionEvent e) {
        String s = this.theDriver.getInputString();
        HuffmanFrame f = new HuffmanFrame(new HuffmanTree(s));
        f.setTitle("Huffman Tree");
        f.show();
    }
}
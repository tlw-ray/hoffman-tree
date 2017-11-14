package com.tlw.haffman;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Comparator;

public class SortListener implements ActionListener {
    private HuffmanFrame theFrame;
    private Comparator theComparator;

    public SortListener(HuffmanFrame f, Comparator c) {
        this.theFrame = f;
        this.theComparator = c;
    }

    public void actionPerformed(ActionEvent e) {
        this.theFrame.sortFrequencyTable(this.theComparator);
        this.theFrame.updateFrequencyPanel();
    }
}


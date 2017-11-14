package com.tlw.haffman;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;

public class HuffmanFrame extends JFrame {
    private Box content = new Box(0);
    private JScrollPane codePane;
    HuffmanTree theTree;
    private FrequencyTableEntry[] frequencyTable;
    private static int fontSize = 12;
    private static int fontStyle = 0;
    private Font theFont;
    private JMenu sizeMenu = new JMenu("Size");
    private JCheckBoxMenuItem boldBox;
    private JCheckBoxMenuItem italicBox;

    public HuffmanFrame(HuffmanTree t) {
        this.theTree = t;
        JMenuBar mb = new JMenuBar();
        this.setJMenuBar(mb);
        JMenu m = new JMenu("Sort by...");
        JMenuItem sortByChar = new JMenuItem("Character");
        sortByChar.addActionListener(new SortListener(this, FrequencyTableEntry.getCharacterComparator()));
        m.add(sortByChar);
        JMenuItem sortByCode = new JMenuItem("Encoding");
        sortByCode.addActionListener(new SortListener(this, FrequencyTableEntry.getEncodingComparator()));
        m.add(sortByCode);
        JMenuItem sortByCodeLength = new JMenuItem("Encoding Length");
        sortByCodeLength.addActionListener(new SortListener(this, FrequencyTableEntry.getEncodingLengthComparator()));
        m.add(sortByCodeLength);
        JMenuItem sortByCount = new JMenuItem("Frequency");
        sortByCount.addActionListener(new SortListener(this, new ReverseComparator(FrequencyTableEntry.getCountComparator())));
        m.add(sortByCount);
        mb.add(m);
        JMenu fm = new JMenu("Font");

        for(int i = 10; i < 25; i += 2) {
            JMenuItem it = new JMenuItem(String.valueOf(i));
            it.addActionListener(new FontSizeListener(this, i));
            this.sizeMenu.add(it);
        }

        fm.add(this.sizeMenu);
        FontStyleListener fstl = new FontStyleListener(this);
        if ((fontStyle & 1) == 0) {
            this.boldBox = new JCheckBoxMenuItem("Bold");
        } else {
            this.boldBox = new JCheckBoxMenuItem("Bold", true);
        }

        this.boldBox.addActionListener(fstl);
        fm.add(this.boldBox);
        if ((fontStyle & 2) == 0) {
            this.italicBox = new JCheckBoxMenuItem("Italic");
        } else {
            this.italicBox = new JCheckBoxMenuItem("Italic", true);
        }

        this.italicBox.addActionListener(fstl);
        fm.add(this.italicBox);
        mb.add(fm);
        this.setContentPane(this.content);
        this.frequencyTable = t.getFrequencyTable();
        this.sortFrequencyTable(new ComparatorCombination(new ReverseComparator(FrequencyTableEntry.getCountComparator()), new ComparatorCombination(FrequencyTableEntry.getEncodingLengthComparator(), FrequencyTableEntry.getEncodingComparator())));
        this.setFontSize(fontSize);
        this.setSize(500, 300);
    }

    public void setFontSize(int size) {
        fontSize = size;
        this.theFont = new Font("Monospaced", fontStyle, fontSize);
        this.updateContent();
    }

    public void setFontStyle() {
        int boldMask = this.boldBox.isSelected() ? 1 : 0;
        int italicMask = this.italicBox.isSelected() ? 2 : 0;
        fontStyle = boldMask | italicMask;
        this.theFont = new Font("Monospaced", fontStyle, fontSize);
        this.updateContent();
    }

    public void updateContent() {
        this.content.removeAll();
        this.content.add(new JScrollPane(this.theTree.getDrawing(this.theFont)));
        this.updateFrequencyPanel();
    }

    public void updateFrequencyPanel() {
        Box tableBox = new Box(0);
        Box charBox = new Box(1);
        Box hexBox = new Box(1);
        Box codeBox = new Box(1);
        Box countBox = new Box(1);

        for(int i = 0; i < this.frequencyTable.length; ++i) {
            FrequencyTableEntry e = this.frequencyTable[i];
            JLabel lbl = new JLabel(e.getCharacter() + "  ");
            lbl.setFont(this.theFont);
            charBox.add(lbl);
            Box b = new Box(0);
            b.add(Box.createHorizontalGlue());
            lbl = new JLabel(Integer.toString(e.getCharacter().charValue(), 16));
            lbl.setFont(this.theFont);
            b.add(lbl);
            hexBox.add(b);
            lbl = new JLabel("  " + e.getEncoding() + "  ");
            lbl.setFont(this.theFont);
            codeBox.add(lbl);
            b = new Box(0);
            b.add(Box.createHorizontalGlue());
            lbl = new JLabel(String.valueOf(e.getCount()));
            lbl.setFont(this.theFont);
            b.add(lbl);
            countBox.add(b);
        }

        charBox.add(Box.createGlue());
        hexBox.add(Box.createGlue());
        codeBox.add(Box.createGlue());
        countBox.add(Box.createGlue());
        tableBox.add(Box.createHorizontalStrut(5));
        tableBox.add(charBox);
        tableBox.add(hexBox);
        tableBox.add(codeBox);
        tableBox.add(countBox);
        tableBox.add(Box.createHorizontalStrut(5));
        if (this.codePane != null) {
            this.content.remove(this.codePane);
        }

        this.codePane = new JScrollPane(tableBox, 22, 31);
        Dimension size = this.codePane.getPreferredSize();
        this.codePane.setMinimumSize(new Dimension(size.width, 0));
        this.codePane.setMaximumSize(new Dimension(size.width, 2147483647));
        this.content.add(this.codePane);
        this.validate();
        this.repaint();
    }

    public void sortFrequencyTable(Comparator c) {
        Arrays.sort(this.frequencyTable, c);
    }
}


package com.tlw.haffman;

import edu.ksu.cis.viewer.BinaryTree;
import edu.ksu.cis.viewer.Node;
import edu.ksu.cis.viewer.TreeComponent;

import java.awt.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Vector;

public class HuffmanTree {
    private Vector characters = new Vector();
    private HashMap frequencies = new HashMap();
    private HashMap encodings = new HashMap();
    private BinaryTree theTree;

    public HuffmanTree(String s) {
        this.findFrequencies(s);
        this.buildTree();
        this.generateEncodings(this.theTree, "");
    }

    public Character[] getCharacters() {
        Character[] c = new Character[this.characters.size()];
        return (Character[])this.characters.toArray(c);
    }

    public int getCount(Character c) {
        Integer i = (Integer)this.frequencies.get(c);
        return i == null ? 0 : i.intValue();
    }

    public String getEncoding(Character c) {
        return (String)this.encodings.get(c);
    }

    public TreeComponent getDrawing() {
        return this.theTree.getDrawing();
    }

    public TreeComponent getDrawing(Font f) {
        return this.theTree.getDrawing(f);
    }

    public FrequencyTableEntry[] getFrequencyTable() {
        FrequencyTableEntry[] theTable = new FrequencyTableEntry[this.characters.size()];

        for(int i = 0; i < theTable.length; ++i) {
            Character c = (Character)this.characters.elementAt(i);
            theTable[i] = new FrequencyTableEntry(c, ((Integer)this.frequencies.get(c)).intValue(), (String)this.encodings.get(c));
        }

        return theTable;
    }

    private void findFrequencies(String s) {
        for(int i = 0; i < s.length(); ++i) {
            int f = 0;
            Character c = new Character(s.charAt(i));
            Integer entry = (Integer)this.frequencies.get(c);
            if (entry == null) {
                this.characters.add(c);
            } else {
                f = entry.intValue();
            }

            ++f;
            this.frequencies.put(c, new Integer(f));
        }

    }

    private void buildTree() {
        PriorityQueue q = new PriorityQueue();
        Enumeration e = this.characters.elements();

        int c1;
        while(e.hasMoreElements()) {
            Character c = (Character)e.nextElement();
            c1 = ((Integer)this.frequencies.get(c)).intValue();
            q.put(c1, new BinaryTree(new Node(String.valueOf(c)), (BinaryTree)null, (BinaryTree)null));
        }

        BinaryTree empty = new BinaryTree();

        while(q.size() > 1) {
            c1 = q.minKey();
            BinaryTree t1 = (BinaryTree)q.removeMin();
            int c2 = q.minKey();
            BinaryTree t2 = (BinaryTree)q.removeMin();
            q.put(c1 + c2, new BinaryTree(new Node(String.valueOf(c1 + c2)), t1, t2));
        }

        this.theTree = q.isEmpty() ? empty : (BinaryTree)q.removeMin();
    }

    private void generateEncodings(BinaryTree tree, String prefix) {
        if (tree.getLeftChild().isEmpty()) {
            this.encodings.put(new Character(tree.getRoot().getContents().charAt(0)), prefix);
        } else {
            this.generateEncodings(tree.getLeftChild(), prefix + '0');
            this.generateEncodings(tree.getRightChild(), prefix + '1');
        }

    }
}

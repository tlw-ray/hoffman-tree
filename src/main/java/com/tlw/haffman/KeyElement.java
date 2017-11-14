package com.tlw.haffman;

public class KeyElement {
    private int theKey;
    private Object theElement;

    public KeyElement(int key, Object element) {
        this.theKey = key;
        this.theElement = element;
    }

    public int getKey() {
        return this.theKey;
    }

    public Object getElement() {
        return this.theElement;
    }
}

package com.tlw.haffman;

import java.util.Comparator;

public class ComparatorCombination implements Comparator {
    private Comparator primary;
    private Comparator secondary;

    public ComparatorCombination(Comparator c1, Comparator c2) {
        this.primary = c1;
        this.secondary = c2;
    }

    public int compare(Object obj1, Object obj2) throws ClassCastException {
        int r = this.primary.compare(obj1, obj2);
        if (r == 0) {
            r = this.secondary.compare(obj1, obj2);
        }

        return r;
    }
}


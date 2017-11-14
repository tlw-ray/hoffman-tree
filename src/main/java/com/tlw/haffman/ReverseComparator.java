package com.tlw.haffman;

import java.util.Comparator;

public class ReverseComparator implements Comparator {
    private Comparator originalComparator;

    public ReverseComparator(Comparator c) {
        this.originalComparator = c;
    }

    public int compare(Object obj1, Object obj2) throws ClassCastException {
        return -this.originalComparator.compare(obj1, obj2);
    }
}

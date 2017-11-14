package com.tlw.haffman;

import java.util.Comparator;

public class CountComparator implements Comparator {
    public int compare(Object obj1, Object obj2) throws ClassCastException {
        return ((FrequencyTableEntry)obj1).getCount() - ((FrequencyTableEntry)obj2).getCount();
    }
}

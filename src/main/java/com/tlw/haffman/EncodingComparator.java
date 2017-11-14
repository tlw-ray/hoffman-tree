package com.tlw.haffman;

import java.util.Comparator;

public class EncodingComparator implements Comparator {
    public int compare(Object obj1, Object obj2) throws ClassCastException {
        return ((FrequencyTableEntry)obj1).getEncoding().compareTo(((FrequencyTableEntry)obj2).getEncoding());
    }
}
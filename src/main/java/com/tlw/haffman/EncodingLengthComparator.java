package com.tlw.haffman;

import java.util.Comparator;

public class EncodingLengthComparator implements Comparator {
    public int compare(Object obj1, Object obj2) throws ClassCastException {
        return ((FrequencyTableEntry)obj1).getEncoding().length() - ((FrequencyTableEntry)obj2).getEncoding().length();
    }
}

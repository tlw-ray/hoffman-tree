package com.tlw.haffman;

import java.util.Comparator;

public class CharacterComparator implements Comparator {
    public int compare(Object obj1, Object obj2) throws ClassCastException {
        return ((FrequencyTableEntry)obj1).getCharacter().charValue() - ((FrequencyTableEntry)obj2).getCharacter().charValue();
    }
}

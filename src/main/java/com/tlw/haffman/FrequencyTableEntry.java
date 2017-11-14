package com.tlw.haffman;

import java.util.Comparator;

public class FrequencyTableEntry {
    private Character theCharacter;
    private int theCount;
    private String theEncoding;

    public FrequencyTableEntry(Character c, int n, String s) {
        this.theCharacter = c;
        this.theCount = n;
        this.theEncoding = s;
    }

    public Character getCharacter() {
        return this.theCharacter;
    }

    public int getCount() {
        return this.theCount;
    }

    public String getEncoding() {
        return this.theEncoding;
    }

    public static Comparator getCharacterComparator() {
        return new CharacterComparator();
    }

    public static Comparator getCountComparator() {
        return new CountComparator();
    }

    public static Comparator getEncodingComparator() {
        return new EncodingComparator();
    }

    public static Comparator getEncodingLengthComparator() {
        return new EncodingLengthComparator();
    }
}

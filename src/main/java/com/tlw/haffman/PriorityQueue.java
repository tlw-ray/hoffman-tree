package com.tlw.haffman;

import java.util.Vector;

public class PriorityQueue {
    private Vector data = new Vector();

    public PriorityQueue() {
        this.data.add(new KeyElement(-2147483648, (Object)null));
    }

    public void put(int key, Object el) {
        int i = this.data.size();
        int j = i / 2;
        this.data.add((Object)null);

        for(KeyElement parent = (KeyElement)this.data.elementAt(j); parent.getKey() > key; parent = (KeyElement)this.data.elementAt(j)) {
            this.data.setElementAt(parent, i);
            i = j;
            j /= 2;
        }

        this.data.setElementAt(new KeyElement(key, el), i);
    }

    public int minKey() throws ArrayIndexOutOfBoundsException {
        return ((KeyElement)this.data.elementAt(1)).getKey();
    }

    public Object removeMin() throws ArrayIndexOutOfBoundsException {
        Object min = ((KeyElement)this.data.elementAt(1)).getElement();
        KeyElement last = (KeyElement)this.data.remove(this.data.size() - 1);
        int key = last.getKey();
        int i = 1;

        for(int j = 2; j < this.data.size(); j *= 2) {
            if (j + 1 < this.data.size() && ((KeyElement)this.data.elementAt(j)).getKey() > ((KeyElement)this.data.elementAt(j + 1)).getKey()) {
                ++j;
            }

            if (((KeyElement)this.data.elementAt(j)).getKey() > key) {
                break;
            }

            this.data.setElementAt(this.data.elementAt(j), i);
            i = j;
        }

        if (i < this.data.size()) {
            this.data.setElementAt(last, i);
        }

        return min;
    }

    public Object minElement() throws ArrayIndexOutOfBoundsException {
        return this.data.elementAt(1);
    }

    public boolean isEmpty() {
        return this.data.size() == 1;
    }

    public int size() {
        return this.data.size() - 1;
    }
}

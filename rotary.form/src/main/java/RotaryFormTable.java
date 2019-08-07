/*
   *************************************************************************************************
   Program: RotaryFormTable.java
   Repository Name: Rotary-Form
   Date Created: 03-Jul-19
   Program Description: This class holds all the records that are in a given form
   *************************************************************************************************
*/

import java.util.*;

public class RotaryFormTable extends ArrayList<RotaryFormRecord> {

    private int size;
    private transient Object[] listData;
    private final Object[] EMPTY_LIST = {};

    public RotaryFormTable() {
        size = 0;
        listData = EMPTY_LIST;
    }

    public RotaryFormTable(int initialCapacity) {
        if (initialCapacity > 0) {
            this.listData = new Object[initialCapacity];
        } else {
            if (initialCapacity != 0) {
                throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
            }

            this.listData = EMPTY_LIST;
        }
    }

    public RotaryFormTable(Collection<? extends RotaryFormRecord> c) {
        this.listData = c.toArray();
        if ((this.size = this.listData.length) != 0) {
            if (!(listData instanceof RotaryFormRecord[])) {
                listData = EMPTY_LIST;
            }
        } else {
            listData = EMPTY_LIST;
        }
    }

    public RotaryFormTable(RotaryFormRecord... records) {
        //this.addAll(Arrays.asList(records));
    }

    public void trimToSize() {
        ++this.modCount;
        if (this.size < this.listData.length) {
            this.listData = this.size == 0 ? EMPTY_LIST : Arrays.copyOf(this.listData, this.size);
        }
    }

    @Override
    public RotaryFormRecord get(int i) {
        Objects.checkIndex(i, this.size);
        return (RotaryFormRecord) this.listData[i];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public RotaryFormTable clone() {
        RotaryFormTable v = (RotaryFormTable) super.clone();
        v.listData = Arrays.copyOf(this.listData, this.size);
        v.modCount = 0;
        return v;
    }

//    public boolean addAll(Collection<? extends RotaryFormRecord> c) {
//        Object[] a = c.toArray();
//        ++this.modCount;
//        int numNew = a.length;
//        if (numNew == 0) {
//            return false;
//        } else {
//            Object[] elementData;
//            int s;
//            if (numNew > (elementData = this.listData).length - (s = this.size)) {
//                elementData = this.grow(s + numNew);
//            }
//
//            System.arraycopy(a, 0, elementData, s, numNew);
//            this.size = s + numNew;
//            return true;
//        }
//    }

    private Object[] grow(int minCapacity) {
        return this.listData = Arrays.copyOf(this.listData, minCapacity);
    }

    private Object[] grow() {
        return this.grow(this.size + 1);
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) {
            throw new OutOfMemoryError();
        } else {
            return minCapacity > 2147483639 ? 2147483647 : 2147483639;
        }
    }
}
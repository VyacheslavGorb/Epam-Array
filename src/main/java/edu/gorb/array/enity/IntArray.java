package edu.gorb.array.enity;

import java.util.Arrays;

public class IntArray {
    private final int[] array;

    public IntArray(int size) {
        array = new int[size];
    }

    public IntArray(int size, int value) {
        array = new int[size];
        Arrays.fill(array, value);
    }

    public IntArray(int[] a) {
        array = a;
    }

    public int get(int index) {
        return array[index];
    }

    public void set(int index, int value) {
        array[index] = value;
    }

    public int size() {
        return array.length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntArray myArray = (IntArray) o;
        return Arrays.equals(array, myArray.array);
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }
}

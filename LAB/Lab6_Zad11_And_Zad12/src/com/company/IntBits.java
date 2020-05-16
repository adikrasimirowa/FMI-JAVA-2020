package com.company;

public class IntBits {
    private int bits;

    public IntBits(int bits) {
        this.bits = bits;
    }

    public boolean get(int index) {
        // 0 1 1 1
        // &
        // 0 0 0 1
        // 0 0 0 0 1 0 0 0 0 0
        return (bits & (1 << index)) != 0;
    }

    public void set(int index, boolean value) {
        if (value) {
            // 1
            // |
            // 1
            // 1
            bits |= (1 << index);
        } else {
            bits &= ~(1 << index); // &=, bits = bits &
        }
    }

    public int getBits() {
        return bits;
    }

    public void setBits(int bits) {
        this.bits = bits;
    }

    @Override
    public String toString() {
        return Integer.toBinaryString(bits);
    }
}

package com.company;

public class Main {

    public static void main(String[] args) {
        IntBits intBits = new IntBits(7);
        System.out.println(intBits);
        System.out.println(intBits.get(2));
        System.out.println(intBits.get(3));
        intBits.set(3, true);
        System.out.println(intBits.get(3));

        reverseBitsRecursive(intBits, 0, 31);
        System.out.printf("Reversed: %s\n", intBits);
        System.out.printf("Reversed int value: %d\n", intBits.getBits());
    }

    private static void reverseBits(IntBits intBits) {
        // 0 0 0 0 1
        // 1 0 0 0 0

        int firstIndex = 0;
        int lastIndex = 31;

        while (firstIndex < lastIndex) {
            boolean temp = intBits.get(firstIndex);
            intBits.set(firstIndex, intBits.get(lastIndex));
            intBits.set(lastIndex, temp);

            firstIndex++;
            lastIndex--;
        }
    }

    private static void reverseBitsRecursive(IntBits intBits, int firstIndex, int lastIndex) {
        if (firstIndex >= lastIndex) {
            return;
        }

        boolean temp = intBits.get(firstIndex);
        intBits.set(firstIndex, intBits.get(lastIndex));
        intBits.set(lastIndex, temp);

//        firstIndex++;
//        lastIndex--;

        reverseBitsRecursive(intBits, firstIndex + 1, lastIndex - 1);
    }
}

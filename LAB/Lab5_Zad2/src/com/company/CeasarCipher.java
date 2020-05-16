package com.company;

public class CeasarCipher {
    private  int SHIFT_LENGTH;

    public  CeasarCipher() {
        SHIFT_LENGTH = 3;
    }

    public  CeasarCipher(int cipherCode) {
        setCipherCode(cipherCode);
    }

    public int getCipherCode() { return  SHIFT_LENGTH;}

    public  void setCipherCode(int cipherCode) {
        if ( cipherCode != 0) {
            if (cipherCode > 26 || cipherCode < -26) {
                cipherCode = cipherCode % 26; // %26 - because of the number of the english alphabet
                SHIFT_LENGTH = cipherCode;
            } else {
                SHIFT_LENGTH = 3; //default encryption
            }
        }
    }

    public  String  encrypt(String plainText) {
        char[] plainTextChars = plainText.toCharArray();
        char[] cipherTextChars = new char[plainTextChars.length];

        for (int i = 0; i < cipherTextChars.length; i++) {
            //System.out.println(plainTextChars[i] -'A');
           // System.out.println((plainTextChars[i] -'A' + SHIFT_LENGTH + 26)%26);
            cipherTextChars[i] = (char) ('A' + (plainTextChars[i] - 'A' + SHIFT_LENGTH+26) % 26);
        }
        return new String(cipherTextChars);
    }

    public String decrypt(String cipherText) {
        char[] cipherTextChars = cipherText.toCharArray();
        char[] plainTextChars = new char[cipherTextChars.length];
        for (int i = 0; i < cipherTextChars.length; i++)
            plainTextChars[i] = (char) ('A' + (cipherTextChars[i] - 'A' + SHIFT_LENGTH + 26) % 26);

        return new String(plainTextChars);

    }

@Override
    public  String toString() { return  String.format("CesarCipher code = %d", SHIFT_LENGTH);}
}

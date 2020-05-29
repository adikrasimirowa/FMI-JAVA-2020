package provider;

import cipher.Cipherable;

import java.util.Random;

public class Wrapper {
    private int size;

    public Wrapper(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }




    private  class  FixedRandom implements Cipherable {

        @Override
        public String[] getSecretChars(int seed) {
            String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            Random randNumber = new Random();
            char letter = alphabet.charAt(randNumber.nextInt(seed));
            String[] array = new String[size];
            for (int i =0; i <size; i++) {
                array[i] = Character.toString(letter);
            }
            return array;
        }
    }

    





    public Cipherable makeFixedSelection() {
       return new FixedRandom();
    }
    private  class  FixedSelection implements Cipherable {


        @Override
        public String[] getSecretChars(int seed) {
            String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            Random randNumber = new Random();
            char letter;
            String[] array = new String[size];
            String[] array2 = new String[seed];
            for (int i =0; i <seed; i++) {
                letter = alphabet.charAt(randNumber.nextInt(seed));
                array2[i] = Character.toString(letter);
            }

            int j = randNumber.nextInt();
            for (int i =0; i <seed; i++) {
                array2[i] = Character.toString(Integer.parseInt(array2[j]));
            }

            return array;
        }
    }
   public Cipherable makeFixedRandom() {
        return new FixedSelection();
    }


}

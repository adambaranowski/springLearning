package pl.adambaranowski.devicerent.controller;

public class Decoder {
    public static void main(String[] args) {
        String code = "01010111 01110011 01111010 01111001 01110011 01110100 01101011 01101001 01100101 01100111 01101111 00100000 01101110 01100001 01101010 01101100 01100101 01110000 01110011 01111010 01100101 01100111 01101111 00100000 00100001 00100001 00001101 00001010 01011010 00100000 01101111 01101011 01100001 01111010 01101010 01101001 00100000 01100100 01101110 01101001 01100001 00100000 01110000 01110010 01101111 01100111 01110010 01100001 01101101 01101001 01110011 01110100 01111001 00100000 00001101 00001010 00001101 00001010 11000101 10111100 01111001 01100011 01111010 01111001 00100000 00001101 00001010 01010010 01100101 01101111 01100100";
        String[] s = code.split(" ");
        int sumator;
        StringBuilder sb = new StringBuilder();
        for (String letter: s
             ) {

            char[] chars = letter.toCharArray();
            int powerOfTwo = 128;
            sumator=0;

            for (char o: chars
                 ) {
                sumator = sumator + Integer.valueOf(String.valueOf(o)) * powerOfTwo;
                powerOfTwo /= 2;
            }


            System.out.println(sumator);
            sb.append((char)sumator);
        }

        System.out.println(sb.toString());
    }
}

package pl.adambaranowski.springexercisedi.coder;

import org.springframework.stereotype.Component;

@Component
public class CaesarCipherCoder implements Coder {
    public static final int SHIFT = 2;

    private StringBuilder stringBuilder = new StringBuilder();

    @Override
    public String code(String text) {
        char[] chars = text.toCharArray();
        stringBuilder.setLength(0);
        for (char c: chars
             ) {
            stringBuilder.append((char)(c + SHIFT));
        }
        return stringBuilder.toString();
    }

    @Override
    public String decode(String text) {
        char[] chars = text.toCharArray();
        stringBuilder.setLength(0);
        for (char c: chars
        ) {
            stringBuilder.append((char)(c - SHIFT));
        }
        return stringBuilder.toString();
    }

//    public static void main(String[] args) {
//        CaesarCipherCoder coder = new CaesarCipherCoder();
//        String puciak = coder.code("puciak");
//        System.out.println(puciak);
//        System.out.println(coder.decode(puciak));
//    }
}

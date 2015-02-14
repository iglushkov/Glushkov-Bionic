import java.util.Arrays;

public class ASCII {

    public void encryptingDecrypting() {

        String str = "abcdefg";
        int length = str.length();
        int[] encr = new int[length];

        for (int i = 0; i < length; i++) {
            encr[i] = (int) str.charAt(i);
        }

        String decr = "";

        for (int i = 0; i < length; i++) {
            decr += Character.toString((char)((int) str.charAt(i)));
        }

        System.out.println("ASCII. Строка для шифрования: " + str);
        System.out.println("Шифрование в ASCII-код: " + Arrays.toString(encr));
        System.out.println("Дешифрование из ASCII-код: " + decr);

    }


}

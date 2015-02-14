import java.lang.*;
import java.util.Scanner;

public class Ceasar {

        private static String alph = "abcdefghijklmnopqrstuvwxyz"; //Латинский алфавит

        public void ceasarr() {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Ceasar. Please, type text to encrypt (string): ");

            String text = scanner.nextLine();                       //шифруемый текст

            System.out.println("Encrypt key (int): ");
            int k = scanner.nextInt();

            StringBuilder textEncrypted = encryptCeasar(text, k);
            System.out.println("Encrypted text: " + textEncrypted);

            StringBuilder textDecrypted = decryptCeasar(textEncrypted.toString(), k);
            System.out.println("Decrypted text: " + textDecrypted);

        }

        public static StringBuilder encryptCeasar(String textToEncrypt, int key) {

            StringBuilder sb = new StringBuilder();                 // шифруем строку

            for (int i = 0; i < textToEncrypt.length(); i++) {

                char ch = textToEncrypt.charAt(i);

                if (ch == ' ') {
                    sb.append(' ');
                } else {
                    sb.append(alph.charAt((alph.indexOf(ch) + key) % alph.length()));
                }
            }
            return sb;
        }

        public static StringBuilder decryptCeasar(String textToDecrypt, int key) {

            StringBuilder sb = new StringBuilder();                            // дешифруем строку

            for (int i = 0; i < textToDecrypt.length(); i++) {

                char ch = textToDecrypt.charAt(i);

                if (ch == ' ') {
                    sb.append(' ');
                } else {
                    sb.append(alph.charAt((alph.indexOf(ch) - key + alph.length()) % alph.length()));
                }
            }
            return sb;
        }
    }

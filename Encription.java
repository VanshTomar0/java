import java.util.*;

public class Encription {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        Random random=new Random();

        String lowerCase="abcdefghijklmnopqrstuvwxyz";
        String upperCase=lowerCase.toUpperCase();
        String numbers="0123456789";
        String symbols="!@#$%^&*(_+-=?/\\|)";

        String all=lowerCase+upperCase+numbers+symbols;

        System.out.println("Enter a message:");
        String text=scan.nextLine();

        int[] indices = new int[text.length()];

        String encrypt="";
        for(int i=0;i<text.length();i++){
            int index=random.nextInt(all.length());
            indices[i]=index;
            encrypt+=all.charAt(index);
        }
        System.out.println("encrypt msg:"+encrypt);

        
        String decrypt = "";
        for (int i = 0; i < encrypt.length(); i++) {
            char encryptedChar = encrypt.charAt(i);
            int indexInAll = all.indexOf(encryptedChar);
            if (indexInAll != -1) {
                // Find the original character based on its index during encryption
                int originalIndex = 0;
                for (int j = 0; j < all.length(); j++) {
                    if (indices[j] == indexInAll) {
                        originalIndex = j;
                        break;
                    }
                }
                decrypt += text.charAt(originalIndex % text.length());
            } else {
                decrypt += encryptedChar; // For symbols and other characters
            }
        }
        System.out.println("Decrypt msg:" + decrypt);

        scan.close();
    }
    
}
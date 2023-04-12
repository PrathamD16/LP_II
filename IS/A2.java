import java.util.*;

public class A2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        while (true) {
            System.out.println("\n1.Enter the message \n2.Exit");
            choice = sc.nextInt();
            if(choice == 1){
                sc = new Scanner(System.in);
                System.out.print("Enter a message to encrypt: ");
                String message = sc.nextLine();
    
                System.out.print("Enter a key: ");
                String key = sc.nextLine();
                // Encryption
                String encryptedMessage = encrypt(message, key);
                System.out.println("*****************************************");
                System.out.println("Encrypted message: " + encryptedMessage);
    
                // Decryption
                String decryptedMessage = decrypt(encryptedMessage, key);
                System.out.println("*****************************************");
                System.out.println("Decrypted message: " + decryptedMessage);
            }
            else if(choice == 2){
                break;
            }
            else{
                System.out.println("Enter the correct choice");
            }
        }

        sc.close();

    }

    public static String encrypt(String message, String key) {
        int[] columnOrder = getColumnOrder(key);
        int rows = (int) Math.ceil((double) message.length() / key.length());
        char[][] grid = new char[rows][key.length()];

        int index = 0;
        for (int j = 0; j < key.length(); j++) {
            int col = columnOrder[j];
            for (int i = 0; i < rows; i++) {
                if (index < message.length()) {
                    grid[i][col] = message.charAt(index++);
                } else {
                    grid[i][col] = ' ';
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < key.length(); j++) {
                sb.append(grid[i][j]);
            }
        }

        return sb.toString();
    }

    public static String decrypt(String encryptedMessage, String key) {
        int[] columnOrder = getColumnOrder(key);
        int rows = encryptedMessage.length() / key.length();
        char[][] grid = new char[rows][key.length()];

        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < key.length(); j++) {
                grid[i][j] = encryptedMessage.charAt(index++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < key.length(); j++) {
            int col = columnOrder[j];
            for (int i = 0; i < rows; i++) {
                sb.append(grid[i][col]);
            }
        }

        return sb.toString().replaceAll("\\s+", "");
    }

    private static int[] getColumnOrder(String key) {
        int[] order = new int[key.length()];
        char[] keyChars = key.toCharArray();
        Arrays.sort(keyChars);
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            for (int j = 0; j < key.length(); j++) {
                if (keyChars[j] == c) {
                    order[i] = j;
                    keyChars[j] = ' ';
                    break;
                }
            }
        }
        return order;
    }
}

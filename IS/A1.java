import java.util.*;

public class A1 {
    static String enCode_XOR(String s) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            ans.append(x ^ 127);
        }
        String msg = ans.toString();
        return msg;
    }

    static String enCode_AND(String s) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            ans.append(x & 127);
        }
        String msg = ans.toString();
        return msg;
    }

    public static void main(String[] args) {
        // System.out.println(enCode_XOR("Hello World"));
        // System.out.println(enCode_AND("Hello World"));
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the message: ");
        String message = s.nextLine();
        while (true) {
            System.out.println("\n1.enCode_XOR \n2.enCode_AND \n3.Exit");
            int choice = s.nextInt();
            if (choice == 1) {
                System.out.println(enCode_XOR(message));
            } else if (choice == 2) {
                System.out.println(enCode_AND(message));
            } else if (choice == 3)
                break;
            else {
                System.out.println("Enter the right choice");
            }
        }
        s.close();
    }
}
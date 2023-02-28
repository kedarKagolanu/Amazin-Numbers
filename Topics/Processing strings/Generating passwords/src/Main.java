import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int n = in.nextInt();

        int i = n;
        char ch;
        StringBuilder str = new StringBuilder(n);
        while(i > 0) {
            // Upper-case Letters
            for(int j = 0;j < a;j++,i--) {
                ch = (char) (65 + j%26);
                str.append(ch);
            }
            //Lower-case letters
            for(int j = 0;j < b;j++,i--) {
                ch = (char) (97 + j%26);
                str.append(ch);
            }
            // numbers
            for(int j = 0;j < c;j++,i--) {
                ch = (char) (49 + j%9);
                str.append(ch);
            }

            //to fill the remaining places (n-(a+b+c))
            for(int j = 0;j < n-(a+b+c);j++,i--) {
                ch = (char) (70 + j%26);
                str.append(ch);
            }
        }

        String password = str.toString();
        System.out.println(password);
    }
}

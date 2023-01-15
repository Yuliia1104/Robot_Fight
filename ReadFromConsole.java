package robotsFight;

import java.util.Scanner;

public class ReadFromConsole {

    public static String getName() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public static String consoleLetter() {
        Scanner scanner = new Scanner(System.in);

        String letter = scanner.next().toUpperCase();
        if (letter.length() != 1){
            System.out.println("You cannot use all keys at a time, so the very first key will be used!");
            letter = String.valueOf(letter.charAt(0));
        }

        return letter;
    }
}
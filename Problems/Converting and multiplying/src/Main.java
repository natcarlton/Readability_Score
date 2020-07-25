import java.lang.reflect.Array;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String in = sc.nextLine();
            if (in.equals("0")) return;
            stringToInt(in);
        }
    }

    public static void stringToInt(String input) {
        try {
            System.out.println(Integer.parseInt(input) * 10);
        } catch (NumberFormatException n) {
            System.out.println("Invalid user input: " + input);
        }
    }
}
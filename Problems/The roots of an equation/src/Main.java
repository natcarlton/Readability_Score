import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        int d = scan.nextInt();

        for (int x = 0; x < 1000; x++) {
            int result = a * x * x * x + b * x * x + c * x + d;
            if (result == 0) {
                System.out.println(x);
            }
        }
    }
}
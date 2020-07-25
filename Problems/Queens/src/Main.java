import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();

        // 5 / 4 == 1
        // 4 / 4 == 1
        // 5.0 / 4.0 != 1
        // 4.0 / 4.0 = 1

        // you must be extremely careful when you divide
        // numbers. thank you <3

        double slope = Math.abs(((double)(y2-y1))/(x2-x1));

        if (slope == 1.0 || y2-y1 == 0 || x2-x1 == 0) {
            System.out.println("YES");
        }
        else System.out.println("NO");
    }
}
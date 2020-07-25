import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        System.out.println(s.substring(n1, n2 + 1));
    }
}
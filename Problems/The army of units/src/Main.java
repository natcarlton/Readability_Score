import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        if (size < 1) System.out.println("no army");
        else if (size <= 19) System.out.println("pack");
        else if (size <= 249) System.out.println("throng");
        else if (size <= 999) System.out.println("zounds");
        else System.out.println("legion");
    }
}
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        System.out.println(num%10*100 + (num%100 - num%10) + (num%1000 - num%100)/100);
    }
}
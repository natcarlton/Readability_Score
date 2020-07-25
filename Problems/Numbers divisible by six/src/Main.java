import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int elements = sc.nextInt();
        int sum = 0;
        while (elements > 0) {
            int num = sc.nextInt();
            if (num % 6 == 0) sum += num;
            elements -= 1;
        }
        System.out.println(sum);
    }
}
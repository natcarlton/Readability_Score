import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;

        while (sc.hasNextInt()){
            int num = sc.nextInt();
            if (num + sum >= 1000) {
                sum += num;
                System.out.println(sum - 1000);
                return;
            }
            else if (num == 0) {
                System.out.println(sum);
                return;
            }
            else sum += num;
        }
        System.out.println(sum);
    }
}
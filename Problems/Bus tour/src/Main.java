import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int height = sc.nextInt();
        int bridges = sc.nextInt();
        int bridgeNum = 1;

        while (bridgeNum <= bridges) {
            int bridgeH = sc.nextInt();

            if (bridgeH <= height) {
                System.out.println("Will crash on bridge " + bridgeNum);
                return;
            }
            bridgeNum += 1;
        }
        System.out.println("Will not crash");
    }
}
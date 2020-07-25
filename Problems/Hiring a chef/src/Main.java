//put imports you need here
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String firstName = sc.nextLine();
        String age = sc.nextLine();
        String education = sc.nextLine();
        String experience = sc.nextLine();
        String preference = sc.nextLine();

        System.out.println("The form for " + firstName + " is completed. We will contact you if we need a chef that cooks " + preference + " dishes.");
    }
}
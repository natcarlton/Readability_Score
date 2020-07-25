import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String city = sc.nextLine();

        System.out.println(city.contains("burg") && city.substring(city.length() - 4, city.length()).equals("burg"));
    }
}
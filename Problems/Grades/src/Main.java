import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfGrades = sc.nextInt();
        int[] grades = new int[4];

        while(numOfGrades > 0) {
            int grade = sc.nextInt();
            if (grade == 2) grades[0] += 1;
            else if (grade == 3) grades[1] += 1;
            else if (grade == 4) grades[2] += 1;
            else if (grade == 5) grades[3] += 1;
            numOfGrades -= 1;
        }
        System.out.println(grades[0] +" "+ grades[1] +" "+ grades[2] +" "+ grades[3]);
    }
}
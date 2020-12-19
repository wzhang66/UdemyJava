import java.util.Scanner;

public class InputCalculator {
    public static void inputThenPrintSumAndAverage () {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        double count = 0;
        while (true){
            boolean isInt = scanner.hasNextInt();
            if(isInt){
                int number = scanner.nextInt();
                count ++;
                sum += number;
            } else {
                break;
            }
            scanner.nextLine();
        }
        count = count == 0 ? 1 : count;
        long avg =Math.round((double) sum/count);
        System.out.println("SUM = " + sum + " AVG = " + avg);
        scanner.close();
    }
}

public class FirstLastDigitSum {
    public static int sumFirstAndLastDigit (int number) {
        if(number >= 0) {
            int first = number % 10;
            int last = 0;
            while (number > 0){
                last = number % 10;
                number = number / 10;
            }
            return first + last;
        }
        return -1;
    }
}

public class EvenDigitSum {
    public static int getEvenDigitSum(int number) {
        if(number >= 0){
            int sum = 0;
            int remain = 0;
            while (number>0){
                remain = number % 10;
                number = number / 10;
                if(remain % 2 != 0){
                    continue;
                }
                sum += remain;
            }
            return sum;
        }
        return -1;
    }
}

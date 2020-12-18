public class SumOddRange {
    public static int sumOdd(int start, int end) {
        if((start <= end) && (start > 0)){
            int sum = 0;
            for(int i = start; i < end + 1; i++){
                if(isOdd(i)){
                    sum += i;
                }
            }
            return sum;
        }
        return -1;
    }

    public static boolean isOdd (int num){
        if(num > 0){
            return num % 2 == 1;
        }
        return false;
    }
}

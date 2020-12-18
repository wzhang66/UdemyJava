public class PerfectNumber {
    public static boolean isPerfectNumber(int x){
        if(x >= 1){
            int sum = 1;
            for(int i = 2; i<=x/2; i++){
                if(x % i != 0) continue;
                sum += i;
            }
            return sum == x;
        }
        return false;
    }
}

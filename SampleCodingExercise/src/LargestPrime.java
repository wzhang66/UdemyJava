public class LargestPrime {
    public static int getLargestPrime(int number){
        if(number > 1){
            for(int x = number/2; x > 1;x--){
                if(number%x == 0){
                    boolean prime = true;
                    for(int y = x/2; y > 1; y--){
                        if(x % y == 0) {
                            prime = false;
                        }
                    }
                    if(prime){
                        return x;
                    }
                }
            }
            return number;
        }
        return -1;
    }
}

public class NumberToWords {
    public static void numberToWords(int x){
        if(x<0){
            System.out.println("Invalid Value");
        } else {
            int digits = getDigitCount(x);
            
        }
    }

    public static int reverse(int number){
        int rever_num = 0;
        int num_cp = number > 0 ? number : -number;
        while (num_cp > 0){
            rever_num = rever_num * 10 + num_cp % 10;
            num_cp = num_cp/10;
        }
        rever_num = number > 0 ? rever_num : -rever_num;
        return rever_num;
    }

    public static int getDigitCount(int num) {
        if(num >= 0){
            int total = 0;
            do {
                total += 1;
                num = num/10;
            } while (num >0);
            return total;
        }
        return -1;
    }
}

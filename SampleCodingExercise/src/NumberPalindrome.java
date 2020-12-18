public class NumberPalindrome {
    public static boolean isPalindrome(int number) {
        int rever_num = 0;
        int num_cp = number > 0 ? number : -number;
        while (num_cp > 0){
            rever_num = rever_num * 10 + num_cp % 10;
            num_cp = num_cp/10;
        }
        rever_num = number > 0 ? rever_num : -rever_num;
        return rever_num == number;
    }
}

public class SharedDigit {
    public static boolean hasSharedDigit (int x, int y) {
        if((x>=10)&&(x<=99)&&(y>=10)&&(y<=99)){
            return (x%10 == y%10) || (x/10 == y/10) || (x%10 == y/10) || (x/10 == y%10);
        }
        return false;
    }
}

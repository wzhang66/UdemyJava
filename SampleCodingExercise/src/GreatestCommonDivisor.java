public class GreatestCommonDivisor {
    public static int getGreatestCommonDivisor(int x, int y){
        if((x>=10)&&(y>=10)){
            int divider = Math.min(x,y);
            while (divider>1){
                if ((x % divider == 0) && (y % divider == 0)){
                    return divider;
                }
                divider -= 1;
            }
            return divider;
        }
        return -1;
    }
}

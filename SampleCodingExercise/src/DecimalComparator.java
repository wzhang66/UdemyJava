public class DecimalComparator {
    public static boolean areEqualByThreeDecimalPlaces(double num1, double num2){
        double rnum1 = (double) ((int) (num1*1000))/1000;
        double rnum2 = (double) ((int) (num2*1000))/1000;
        if (rnum1 == rnum2){
            return true;
        }
        return false;
    }
}

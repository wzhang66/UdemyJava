public class AreaCalculator {
    public static double area (double x, double y) {
        if(x >= 0 && y >= 0){
            return x * y;
        }
        return -1;
    }

    public static double area (double r) {
        if(r >= 0) {
            return r * r * Math.PI;
        }
        return -1;
    }
}

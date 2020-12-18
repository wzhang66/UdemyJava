public class SpeedConverter {

    public static long toMilesPerHour(double kilometersPerHour){
        if(kilometersPerHour < 0) {
            return -1;
        } else {
            return Math.round(kilometersPerHour/1.609);
        }
    }
    public static void printConversion(double KPH){
        if (KPH < 0) {
            System.out.println("Invalid value");
        } else {
            System.out.println(KPH + " km/h is = " + toMilesPerHour(KPH) + " mi/h");
        }
    }

}

public class MinutesToYearsDaysCalculator {
    public static void printYearsAndDays (long minutes) {
        if(minutes >= 0) {
            long convertedDays = minutes / (60 * 24);
            long year = convertedDays / 365;
            long remainDay = convertedDays % 365;
            System.out.println(minutes + " min = " +
                    year + " y and " + remainDay + " d");
        } else {
            System.out.println("Invalid Value");
        }
    }
}

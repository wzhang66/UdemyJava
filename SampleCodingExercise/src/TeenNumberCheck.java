public class TeenNumberCheck {
    public static boolean hasTeen(int t1, int t2, int t3){
        return (isTeen(t1) || isTeen(t2) || isTeen(t3));
    }

    public static boolean isTeen (int age) {
        return (age >= 13 && age <= 19);
    }
}

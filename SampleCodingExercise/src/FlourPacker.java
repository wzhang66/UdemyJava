public class FlourPacker {
    public static boolean canPack(int bigCount, int smallCount, int goal) {
        if(bigCount >= 0 && smallCount >= 0 && goal >= 0){
            if(bigCount*5 + smallCount >= goal){
                int bigBag = goal / 5;
                int smallBag = goal % 5;
                if(bigBag > bigCount){
                    return (goal - bigCount*5) <= smallCount;
                } else {
                    return smallBag <= smallCount;
                }
            } else {
                return false;
            }
        }
        return false;
    }
}

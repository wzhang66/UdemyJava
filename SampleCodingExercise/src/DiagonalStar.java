public class DiagonalStar {
    public static void printSquareStar(int number){
        if(number < 5) {
            System.out.println("Invalid Value");
        } else {
            for(int r = 0; r < number; r++){
                String star = "";
                for(int c=0; c<number; c++){
                    boolean condition_1 = (r == 0)||(r == number -1);
                    boolean condition_2 = (c == 0)||(c == number -1);
                    boolean condition_3 = (r == c)||(number -1 -c == r);
                    char adding = (condition_1||condition_2||condition_3) ? '*' : ' ';
                    star = star + adding;
                }
                System.out.println(star);
            }
        }
    }
}

public class FactorPrinter {
    public static void printFactors(int x){
        if(x<1){
            System.out.println("Invalid Value");
        } else {
            for(int i = 1; i<=x/2; i++){
                if(x%i == 0) System.out.println(i);
            }
            System.out.println(x);
        }
    }
}

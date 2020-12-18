public class MegaBytesConverter {
    public static void printMegaBytesAndKiloBytes (int kiloBytes) {
        if(kiloBytes < 0){
            System.out.println("Invalid Value");
        } else {
            int megabyte = toMegaBytes(kiloBytes);
            int remain = kiloBytes - megabyte*1024;
            System.out.println(kiloBytes + " KB = "
                + megabyte + " MB and " + remain + " KB"
            );
        }
    }
    public static int toMegaBytes (int kiloByte) {
        if(kiloByte < 0){
            return  -1;
        } else {
            return kiloByte/1024;
        }
    }
}

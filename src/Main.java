public class Main {
    public static void main(String[] args) {

    }
    public static boolean confirmAllowedChars(String string) {
        boolean confirmed = true;
        if (string.toCharArray().length <= 20) {
            String allowedChars = "abcdefghijklmnopqrstuvwxyz0123456789_";
            for (char a : string.toLowerCase().toCharArray()) {
                if (confirmed) {
                    for (char b : allowedChars.toCharArray()) {
                        if (a == b) {
                            confirmed = true;
                            break;
                        }
                        confirmed = false;
                    }
                }
            }
        } else {
            confirmed = false;
        }
        return confirmed;
    }
}
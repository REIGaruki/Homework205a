public class Main {
    public static void main(String[] args) {
        String login = "UserName123";
        String password = "Qwerty1234";
        String confirmPassword = "Qwerty1234";
        confirmLoginPassword(login, password, confirmPassword);
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
    public static void confirmLoginPassword(String login, String password, String confirmPassword) {
        if (!confirmAllowedChars(login)) {
            throw new WrongLoginException("Login is too long or contains unallowed symbols");
        }
        if (!confirmAllowedChars(password)) {
            throw new WrongPasswordException("Password is too long or contains unallowed symbols");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Password is not confirmed");
        }
    }
}
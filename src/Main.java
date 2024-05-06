public class Main {
    public static void main(String[] args) {
        String login = "UserName123";
        String password = "Qwerty^1234";
        String confirmPassword = "Qwerty^1234";
        try {
            confirmLoginPassword(login, password, confirmPassword);
        } catch (WrongPasswordException passwordException) {
            System.out.println("Ошибка при вводе пароля");
        } catch (WrongLoginException loginException) {
            System.out.println("Ошибка при вводе логина");
        }
        System.out.println(login + '\n' + password);
    }
    public static boolean confirmAllowedChars(String string) {
        boolean confirmed = true;
        if (string.toCharArray().length <= 20) {
            String allowedChars = "abcdefghijklmnopqrstuvwxyz0123456789_";
            for (char charFromString : string.toLowerCase().toCharArray()) {
                if (confirmed) {
                    for (char allowedChar : allowedChars.toCharArray()) {
                        if (charFromString == allowedChar) {
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
    public static void confirmLoginPassword(String login, String password, String confirmPassword)
            throws WrongLoginException, WrongPasswordException {
        if (!confirmAllowedChars(login)) {
            throw new WrongLoginException("Login is too long or contains unallowed symbols");
        }
        if (!confirmAllowedChars(password)) {
            throw new WrongPasswordException("Password is too long or contains unallowed symbols");
        } else if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Password is not confirmed");
        }
    }
}
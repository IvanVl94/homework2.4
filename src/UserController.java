public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    public static void getUserInfo(User user) {
    try {
        if (user.getLogin().length() > 20) {
            throw new WrongLoginException("Логин слишком длинный. Максимальное число символов 20.");
        }
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            throw new WrongPasswordException("Пароли не совпадают.");
        }
        if (user.getPassword().length() >= 20) {
            throw new WrongPasswordException("Пароль слишком длинный. Максимальное число символов 19.");
        }
    } catch (WrongLoginException | WrongPasswordException e) {
        System.out.println("Exception: " + e.getMessage());
    }
}
}

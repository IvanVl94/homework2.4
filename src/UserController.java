public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public static void getUserInfo(User user) {
    try {
        if (user.getLogin().length() > 20 || !user.getLogin().matches("[a-zA-Z0-9_]+")) {
            throw new WrongLoginException("Логин слишком длинный. Максимальное число символов 20. Или указаны недопустимые символы.");
        }
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            throw new WrongPasswordException("Пароли не совпадают.");
        }
        if (user.getPassword().length() >= 20 || !user.getPassword().matches("[a-zA-Z0-9_]+")) {
            throw new WrongPasswordException("Пароль слишком длинный. Максимальное число символов 19. Или указаны недопустимые символы.");
        }
    } catch (WrongLoginException | WrongPasswordException e) {
        System.out.println("Exception: " + e.getMessage());
    }
}
}

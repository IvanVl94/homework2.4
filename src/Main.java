public class Main {
    public static void main(String[] args) {
        User user = new User("qwerty_pro1", "fgrdr4667mlkmkkm", "fgrdr4667");
        try {
            UserController.getUserInfo(user);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
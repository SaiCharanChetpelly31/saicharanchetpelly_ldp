public class Main {
    public static void main(String[] args) {
        // Creating instance of nested Static class
        User user = new User.UserBuilder()
                .setUserId(1)
                .setUserName("Saicharan")
                .build();
        System.out.println(user);
    }
}
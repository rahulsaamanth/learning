
public class Exceptions {
    public class User {
        public void setAge(int age) throws InvalidAgeException {
            if (age < 0) {
                throw new InvalidAgeException("Age cannot be negative.");
            }
            System.out.println("Age set to: " + age);
        }
    }

    public static void main(String[] args) {
        try {
            User user = new Exceptions().new User();
            user.setAge(-5);
        } catch (InvalidAgeException e) {
            System.err.println(e.getMessage());
        } finally {
            System.out.println("This runs anyway!");
        }
    }
}

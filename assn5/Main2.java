
import java.util.Optional;

public class Main2 {
    public static void main(String[] args) {

        Optional<String> email = Optional.of("student@gmail.com");

        Optional<String> emptyEmail = Optional.empty();

        email.ifPresent(e -> System.out.println("Email: " + e));

        System.out.println("Default Email: " + emptyEmail.orElse("default@gmail.com"));

        try {
            System.out.println("Email: " + emptyEmail.orElseThrow(
                () -> new RuntimeException("Email is missing")
            ));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}

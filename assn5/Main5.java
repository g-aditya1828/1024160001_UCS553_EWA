
import java.util.Optional;
import java.util.Objects;

class Utility {

    public static <T> boolean isEqual(T a, T b) {
        return Objects.equals(a, b);
    }

    public static <T> T getDefault(Optional<T> value, T defaultValue) {
        return value.orElse(defaultValue);
    }

    public static <T extends Comparable<T>> T max(T a, T b) {
        return a.compareTo(b) >= 0 ? a : b;
    }

    public static boolean isNull(Object obj) {
        return Objects.isNull(obj);
    }
}

public class Main5 {
    public static void main(String[] args) {

        System.out.println("Equal Strings: " +
                Utility.isEqual("Java", "Java"));

        System.out.println("Equal Integers: " +
                Utility.isEqual(10, 20));

        System.out.println("Default Value: " +
                Utility.getDefault(Optional.empty(), "Default"));

        System.out.println("Default Integer: " +
                Utility.getDefault(Optional.of(100), 0));

        System.out.println("Maximum Integer: " +
                Utility.max(25, 40));

        System.out.println("Maximum String: " +
                Utility.max("Apple", "Banana"));

        System.out.println("Is Null: " +
                Utility.isNull(null));

        System.out.println("Is Null: " +
                Utility.isNull("Hello"));
    }
}

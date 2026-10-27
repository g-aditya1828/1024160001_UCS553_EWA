
import java.util.Optional;
import java.util.Objects;

class Result<T extends Number> {
    private T marks;

    public Result(T marks) {
        this.marks = Objects.requireNonNull(marks, "Marks cannot be null");
    }

    public double getPercentage(double totalMarks) {
        Objects.requireNonNull(marks);
        return (marks.doubleValue() / totalMarks) * 100;
    }

    public boolean hasPassed(double threshold, double totalMarks) {
        return getPercentage(totalMarks) >= threshold;
    }

    public Optional<T> getMarks() {
        return Optional.ofNullable(marks);
    }
}

public class Main3 {
    public static void main(String[] args) {
        Result<Integer> result = new Result<>(80);

        result.getMarks().ifPresent(m ->
            System.out.println("Marks: " + m)
        );

        double percentage = result.getPercentage(100);
        System.out.println("Percentage: " + percentage + "%");

        if (result.hasPassed(40, 100)) {
            System.out.println("Result: Pass");
        } else {
            System.out.println("Result: Fail");
        }
    }
}


public class Main1 {

    public static <T extends Number> double sum(T[] arr) {
        double total = 0;

        for (T num : arr) {
            total += num.doubleValue();
        }

        return total;
    }

    public static void main(String[] args) {
        Integer[] intArr = {10, 20, 30, 40};
        Float[] floatArr = {1.5f, 2.5f, 3.5f};
        Double[] doubleArr = {10.5, 20.5, 30.5};

        System.out.println("Sum of Integers: " + sum(intArr));
        System.out.println("Sum of Floats: " + sum(floatArr));
        System.out.println("Sum of Doubles: " + sum(doubleArr));
    }
}

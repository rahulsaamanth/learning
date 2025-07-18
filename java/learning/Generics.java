
public class Generics {

    public static class Utility {
        public static <T> void swap(T[] array, int i, int j) {
            T temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    public static class NumberBox<T extends Number> {
        private T number;

        public void set(T number) {
            this.number = number;
        }

        public double getDoubleValue() {
            return number.doubleValue();
        }
    }

    // Generic Box class definition
    public static class Box<T> {
        private T value;

        public void set(T value) {
            this.value = value;
        }

        public T get() {
            return value;
        }
    }

    public static void main(String[] args) {
        Box<String> stringBox = new Box<>();
        stringBox.set("Hello Generics");
        String value = stringBox.get();

        System.out.println("Box contains: " + value);

        String[] array = { "A", "B", "C", "D" };
        Utility.swap(array, 0, 2);
        System.out.println("Swapped array: " + java.util.Arrays.toString(array));

        NumberBox<Integer> intBox = new NumberBox<>();
        intBox.set(42);
        System.out.println("Integer value: " + intBox.getDoubleValue());
    }
}
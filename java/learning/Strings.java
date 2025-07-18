public class Strings {
    public static void main(String[] args) {
        String str = "Rahul Saamanth";
        String str1 = "rahul saamanth";

        // Basic String Methods
        System.out.println("String Length: " + str.length());
        System.out.println("String is Empty: " + str.isEmpty());
        System.out.println("Charter at index 9: " + str.charAt(9));
        System.out.println("String code point at index 9: " + str.codePointAt(9));
        System.out.println("String code point before index 9: " + str.codePointBefore(9));
        System.out.println("String code point count: " + str.codePointCount(0, 9));

        // String Comparison & Matching Methods
        System.out.println("String equals: " + str.equals(str1));
        System.out.println("String equalsIgnoreCase: " + str.equalsIgnoreCase(str1));

    }
}
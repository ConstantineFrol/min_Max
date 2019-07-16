import java.math.BigDecimal;
import java.text.CharacterIterator;
import java.util.function.LongFunction;

public class Main {
    public static void main(String[] args) {

        // Displaying all min and max values

        //Boolean does not have Boolean.SIZE, Boolean.MIN_VALUE, or Boolean.MAX_VALUE
        displaySizeMinAndMax(Byte.TYPE, Byte.SIZE, Byte.MIN_VALUE, Byte.MAX_VALUE);
        displaySizeMinAndMax(Short.TYPE, Short.SIZE, Short.MIN_VALUE, Short.MAX_VALUE);
        displaySizeMinAndMax(Character.TYPE, Character.SIZE, (int) Character.MIN_VALUE, (int) Character.MAX_VALUE);
        displaySizeMinAndMax(Integer.TYPE, Integer.SIZE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        displaySizeMinAndMax(Long.TYPE, Long.SIZE, Long.MIN_VALUE, Long.MAX_VALUE);
        displaySizeMinAndMax(Float.TYPE, Float.SIZE, Float.MIN_EXPONENT, Float.MAX_VALUE);
        displaySizeMinAndMax(Double.TYPE, Double.SIZE, Double.MIN_EXPONENT, Double.MAX_VALUE);

        // Splitting Float min value into separate parts

        float min_float = Float.MIN_VALUE;
        int bits = Float.floatToIntBits(min_float);
        int sign = bits >>> 31;
        int exp = (bits >>> 23 & ((1 << 8) - 1)) - ((1 << 7) - 1);
        int mantissa = bits & ((1 << 23) - 1);
        System.out.println("sign: " + sign + "\n" + "exponent: " + exp + "\n" + "mantissa: " + mantissa + "\n" +
                Float.intBitsToFloat((sign << 31) | (exp + ((1 << 7) - 1)) << 23 | mantissa));
        System.out.println("back to float: " + Float.intBitsToFloat(bits));
        // Try BigDecimal (used in NASA)
        BigDecimal asDecimal = BigDecimal.valueOf(bits);
        System.out.println("BigDecimal: " + asDecimal);
        System.out.println("Another Way with Math.pow(): " + sign * (Math.pow(2, exp)) * mantissa);
        System.out.println("display using NaN:   " + Float.isNaN(min_float));

    }

    // Method that display values in specific format (similar in C)
    public static void displaySizeMinAndMax(Class<?> type, int size, Number min, Number max) {
        System.out.printf("type:%-6s size:%-2s min:%-20s max:%s\n", type, size, min, max);
    }

}

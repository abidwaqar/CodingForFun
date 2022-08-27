public class MagicOf3 {
    public static String solve(int x) throws Exception {
        StringBuilder result = new StringBuilder("1");
        int remainder = 1;
        while (remainder != 0) {
            remainder = (remainder * 10 + 1) % x;
            result.append("1");
        }

        return result.toString();
    }
}

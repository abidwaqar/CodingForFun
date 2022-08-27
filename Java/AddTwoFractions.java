/**
 * You are given four numbers num1, den1, num2, and den2. You need to find
 * (num1/den1)+(num2/den2) and output the result in the form of (numx/denx).
 * Input: 384 887 778 916
 * Its Correct output is: 520915/406246
 */
public class AddTwoFractions {
    static public void addFraction(int num1, int den1, int num2, int den2) {
        int numerator = num1 * den2 + num2 * den1, denominator = den1 * den2;
        int gcd = GCD.gcd(numerator, denominator);
        System.out.println(Integer.toString(numerator / gcd) + "/" + Integer.toString(denominator / gcd));
    }
}

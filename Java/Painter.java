import java.util.Scanner;

/**
 * You have recently started to study how to paint, and in one of the first
 * classes you learned about the three primary colors: Red, Yellow, and Blue. If
 * you combine these colors, you can produce many more colors. For now, the
 * combinations that you have studied are the following:
 * 
 * Red + Yellow = Orange Red + Blue = Purple Yellow + Blue = Green Red + Yellow
 * + Blue = Gray You still do not understand shades of colors, therefore the
 * proportion and order of each color in the combination does not matter. For
 * example, combining Red and Yellow produces the same result as combining
 * Yellow and Red, as well as the same result as combining Red, Yellow, and Red
 * again.
 * 
 * To practice your skills, you want to paint a 1-dimensional painting P of
 * length N. Your painting consists of N squares. From left to right, Pi
 * represents the color of the i-th square. Initially all squares are Uncolored,
 * that is, Pi = Uncolored for every 1≤i≤N.
 * 
 * In a single stroke, you can choose one of the three primary colors and apply
 * it to a sequence of consecutive squares. In other words, you can choose a
 * color c and two integers l and r, such that 1≤l≤r≤N, and apply color c to all
 * squares Pj such that l≤j≤r. If the square being painted is currently
 * Uncolored, then its color will become c. Otherwise, the color will be a
 * combination of all the colors applied on this square so far and the new color
 * c, as described in the list above.
 * 
 * In order to save time, you want to use as few strokes as possible. Given the
 * description of the painting that you want to paint, figure out what is the
 * minimum number of strokes required to paint it.
 */
public class Painter {

    static public boolean color1Containscolor2(char color1, char color2) {
        switch (color1) {
            case 'U':
            case 'R':
            case 'Y':
            case 'B':
                return color1 == color2;
            case 'O':
                return (color2 == 'R' || color2 == 'Y');
            case 'P':
                return (color2 == 'R' || color2 == 'B');
            case 'G':
                return (color2 == 'Y' || color2 == 'B');
            case 'A':
                return (color2 == 'R' || color2 == 'Y' || color2 == 'B');
            default:
                return false;
        }
    }

    static public void painter() {
        Scanner input = new Scanner(System.in);
        int T = Integer.parseInt(input.nextLine()), N, strokesRequired;
        String P, basicColors = "RYB";
        boolean containsPrevColor;

        for (int i = 1; i <= T; i++) {
            N = Integer.parseInt(input.nextLine());
            P = input.nextLine();
            strokesRequired = 0;

            if (N == 0)
                System.out.println("Case #" + i + ": " + 0);

            for (int j = 0; j < 3; j++) {
                containsPrevColor = color1Containscolor2(P.charAt(0), basicColors.charAt(j));
                for (int k = 1; k < N; k++) {
                    if (color1Containscolor2(P.charAt(k), basicColors.charAt(j))) {
                        containsPrevColor = true;
                    } else if (containsPrevColor == true) {
                        containsPrevColor = false;
                        ++strokesRequired;
                    }
                }

                if (containsPrevColor == true)
                    ++strokesRequired;
            }

            System.out.println("Case #" + i + ": " + strokesRequired);
        }

        input.close();
    }

    public static void main(String[] args) {
        painter();
    }
}

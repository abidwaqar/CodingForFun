import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * You are given a string S of length N which consists of digits 0-9. You do the
 * following operations on the string in the order given.
 *
 * Find all the substrings 01 and replace each of them with 2. Find all the
 * substrings 12 and replace each of them with 3. Find all the substrings 23 and
 * replace each of them with 4. Find all the substrings 34 and replace each of
 * them with 5. . . . Find all the substrings 89 and replace each of them with
 * 0. Find all the substrings 90 and replace each of them with 1. You repeat
 * this process in the same given order until none of the above operations
 * change the string. For example, if S is 12 then we do not stop at operation 1
 * since it does not affect the string but perform operation 2 and change the
 * string to 3. We can see that the string does not change further no matter how
 * many times we repeat the above process.
 */
public class SillySubstitutions {

    static public void sillySubstitutions() {
        Scanner input = new Scanner(System.in);
        int T = Integer.parseInt(input.nextLine()), N, nextNumber;
        String S;
        boolean changeDetected;
        StringBuilder sillySubstitutionsStringBuilder;

        for (int i = 1; i <= T; i++) {
            N = Integer.parseInt(input.nextLine());
            S = input.nextLine();
            sillySubstitutionsStringBuilder = new StringBuilder(S);
            changeDetected = true;

            if (N == 0)
                System.out.println("Case #" + i + ": ");

            while (changeDetected) {
                changeDetected = false;
                for (int j = 48; j <= 57; j++) {
                    for (int k = 0; k < (sillySubstitutionsStringBuilder.length() - 1); k++) {
                        if (sillySubstitutionsStringBuilder.charAt(k) == j) {
                            nextNumber = ((j + 1) <= 57) ? (j + 1) : 48;
                            if (sillySubstitutionsStringBuilder.charAt(k + 1) == nextNumber) {
                                sillySubstitutionsStringBuilder.replace(k, k + 2,
                                        Character.toString(((j + 2) <= 57) ? (j + 2) : j - 8));
                                changeDetected = true;
                            }
                        }
                    }
                }
            }

            System.out.println("Case #" + i + ": " + sillySubstitutionsStringBuilder.toString());
        }

        input.close();
    }

    static public void sillySubstitutionsOptimized() {
        Scanner input = new Scanner(System.in);
        int T = Integer.parseInt(input.nextLine()), N;
        String S, subString;
        boolean changeDetected;
        DoublyLinkedList<Character> doublyLinkedList;
        Node<Character> node;
        String[] patterns = { "01", "12", "23", "34", "45", "56", "67", "78", "89", "90" };

        for (int i = 1; i <= T; i++) {
            N = Integer.parseInt(input.nextLine());
            S = input.nextLine();

            if (N == 0) {
                System.out.println("Case #" + i + ": ");
                continue;
            }

            changeDetected = true;
            doublyLinkedList = new DoublyLinkedList<>();
            Map<String, Set<Node<Character>>> locationsOfInterest = new HashMap<String, Set<Node<Character>>>() {
                {
                    for (String pattern : patterns) {
                        put(pattern, new HashSet<Node<Character>>());
                    }
                }
            };

            for (int j = 0; j < N; j++) {
                node = new Node<Character>(S.charAt(j));
                doublyLinkedList.setTail(node);

                if ((j + 1) < N) {
                    subString = S.substring(j, j + 2);
                    if (locationsOfInterest.containsKey(subString)) {
                        locationsOfInterest.get(subString).add(node);
                    }
                }
            }

            Node<Character> newNodeToInsert;
            while (changeDetected) {
                changeDetected = false;

                for (String pattern : patterns) {
                    Iterator<Node<Character>> iterator = locationsOfInterest.get(pattern).iterator();
                    while (iterator.hasNext()) {
                        changeDetected = true;

                        node = iterator.next();

                        if (node.next == null || !locationsOfInterest.containsKey("" + node.value + node.next.value)) {
                            iterator.remove();
                            continue;
                        }

                        newNodeToInsert = new Node<Character>((char) (((node.value - 46) % 10) + 48));
                        doublyLinkedList.insertAfter(node.next, newNodeToInsert);
                        doublyLinkedList.remove(node.next);
                        doublyLinkedList.remove(node);

                        if (newNodeToInsert.prev != null) {
                            subString = "" + newNodeToInsert.prev.value + newNodeToInsert.value;
                            if (locationsOfInterest.containsKey(subString)) {
                                locationsOfInterest.get(subString).add(newNodeToInsert.prev);
                            }
                        }

                        if (newNodeToInsert.next != null) {
                            subString = "" + newNodeToInsert.value + newNodeToInsert.next.value;
                            if (locationsOfInterest.containsKey(subString)) {
                                locationsOfInterest.get(subString).add(newNodeToInsert);
                            }
                        }

                        iterator.remove();

                    }
                }
            }

            System.out.print("Case #" + i + ": ");
            doublyLinkedList.print();
            System.out.println();
        }

        input.close();

    }

    public static void main(String[] args) {
        sillySubstitutionsOptimized();
    }
}
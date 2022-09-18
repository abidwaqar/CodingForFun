
import java.util.Arrays;
import java.util.Scanner;

public class SortTheFabrics {

    public static class Fabric {
        int id;
        String name;
        int durability;

        public Fabric(int id, String name, int durability) {
            this.id = id;
            this.name = name;
            this.durability = durability;
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            int T = sc.nextInt();
            for (int i = 1; i <= T; ++i) {

                int N = sc.nextInt();

                Fabric[] fabrics = new Fabric[N];
                for (int j = 0; j < N; j++) {
                    sc.nextLine();
                    String name = sc.next();
                    int durability = sc.nextInt();
                    int id = sc.nextInt();
                    fabrics[j] = new Fabric(id, name, durability);
                }

                System.out.println("Case #" + i + ": " + solve(fabrics));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // T = O(n*log(n)) | S = O(n)
    // Where n is input array's length.
    private static int solve(Fabric[] fabrics) throws Exception {
        Integer[] nameSortedArr = new Integer[fabrics.length];
        Integer[] durabilitySortedArr = new Integer[fabrics.length];

        for (int i = 0; i < fabrics.length; i++) {
            nameSortedArr[i] = i;
            durabilitySortedArr[i] = i;
        }

        Arrays.sort(nameSortedArr,
                (x, y) -> fabrics[x].name.compareTo(fabrics[y].name) == 0
                        ? Integer.compare(fabrics[x].id, fabrics[y].id)
                        : fabrics[x].name.compareTo(fabrics[y].name));

        Arrays.sort(durabilitySortedArr,
                (x, y) -> Integer.compare(fabrics[x].durability, fabrics[y].durability) == 0
                        ? Integer.compare(fabrics[x].id, fabrics[y].id)
                        : Integer.compare(fabrics[x].durability, fabrics[y].durability));

        int result = 0;
        for (int i = 0; i < fabrics.length; i++) {
            if (nameSortedArr[i].equals(durabilitySortedArr[i])) {
                ++result;
            }
        }

        return result;
    }
}
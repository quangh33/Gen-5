package lesson04.livecode;

import java.util.Arrays;

/**
 * @author taivt
 * @since 2022/03/17 20:03:20
 */
public class LiveCode01ProductOfAllOtherElement {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 5, 0};
        // p[i] = product of all other elements in the array (except array[i])
        int[] p = calculate(array);
        System.out.println("p: " + Arrays.toString(p));
    }

    // TODO: improve the solution without using divide operation

    private static int[] calculate(int[] array) {
        int[] p = new int[array.length];

        int productOfAllElements = 1;
        int zeroCount = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                if (zeroCount == 1) {
                    return p;
                } else {
                    zeroCount++;
                    continue;
                }
            }

            productOfAllElements *= array[i];
        }

        for (int i = 0; i < p.length; i++) {
            if (array[i] != 0 && zeroCount == 1) {
                p[i] = 0;
            } else if (array[i] == 0) {
                p[i] = productOfAllElements;
            } else {
                p[i] = productOfAllElements / array[i];
            }
        }
        return p;
    }
}


/**
 * Class to practice Break and Continue syntax
 *
 * @author Derwin
 */
public class BreakContinue {

    /**
     * Replaces each positive element a[i] with the sum of a[i] through a[i + n]
     *
     * @param a the array to replace
     */
    public static void windowPosSum(int[] a, int n) {
        int len_arr = a.length;

        // Iteration of array a
        for (int i = 0; i < len_arr; ++i) {
            // Use continue to skip negative values
            if (a[i] <= 0) {
                continue;
            }
            int replace_ele = 0;
            /**
             * Changed termination condition from j < i + n to j <= i + n
             * because we need the sum of a[i] through a[i + n]
             */
            for (int j = i; j <= i + n; ++j) {
                // Use break to avoid going over the end of the array
                if (j == len_arr) {
                    break;
                }
                replace_ele += a[j];
            }
            a[i] = replace_ele;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, -3, 4, 5, 4};
        int n = 3;
        windowPosSum(a, n);

        // Should print 4, 8, -3, 13, 9, 4
        System.out.println(java.util.Arrays.toString(a));
    }
}

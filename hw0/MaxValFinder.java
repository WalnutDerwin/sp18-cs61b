
/**
 * Class that finds the maximum value from an array
 *
 * @author WalnutDerwin
 */
public class MaxValFinder {

    /**
     * Returns the maximum value from m.
     *
     * @param m where to find maximum value
     */
    public static int max(int[] m) {
        // Assuming that all of the numbers are >= 0
        int max_val = 0, len_m = m.length;
        for (int i = 0; i < len_m; ++i) {
            if (m[i] > max_val) {
                max_val = m[i];
            }
        }
        return max_val;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};
        System.out.println("The maximum value is " + max(numbers));
    }
}

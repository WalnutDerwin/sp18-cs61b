
/**
 * Class that draws a triangle with N as height
 *
 * @author Derwin
 */
public class TriangleDrawer {

    /**
     * Draws a triangle with param N as the height of triangle
     *
     * @param N to be the height of triangle
     */
    public static void DrawTriangle(int N) {
        for (int row = 0; row < N; ++row) {
            for (int col = 0; col < row + 1; ++col) {
                System.out.print("*");
            }
            if (row != N - 1) {
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        DrawTriangle(10);
    }
}

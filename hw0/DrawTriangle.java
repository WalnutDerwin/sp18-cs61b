
/**
 * Class that draws a triangle
 *
 * @author Derwin
 */
public class DrawTriangle {

    public static void main(String[] args) {
        for (int row = 0; row < 5; ++row) {
            for (int col = 0; col < row + 1; ++col) {
                System.out.print("*");
            }
            if (row != 4) {
                System.out.println();
            }
        }
    }
}

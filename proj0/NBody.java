
public class NBody {

    /**
     * Returns the radius of the universe(a double value) corresponding to the
     * given file.
     */
    public static double readRadius(String file_name) {
        /**
         * In class in Princeton Library, every time you call a read method from
         * the In class, it reads the next thing from the file, assuming it is
         * of the specified type.
         */
        In file_in = new In(file_name);

        file_in.readInt(); // Skips the integer N that we do not need

        double radius = file_in.readDouble();
        return radius;
    }
}

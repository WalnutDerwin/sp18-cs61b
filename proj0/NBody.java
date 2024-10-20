
public class NBody {

    public static void main(String[] args) {
        /**
         * Collects All Needed Input
         */
        // Store the 0th and 1st arguments as doubles named T and dt
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);

        // Store the 2nd argument as a String named filename
        String file_name = args[2];

        // Read in the planets and the universe radius from the file
        double universe_radius = readRadius(file_name);
        Planet[] planets = readPlanets(file_name);

        /**
         * Draws the Background
         */
        // Sets the scale which matches the radius of the universe
        StdDraw.setScale(-universe_radius, universe_radius);
        StdDraw.clear();

        // Draws the image images/starfield.jpg as the background
        StdDraw.picture(0, 0, "images/starfield.jpg");

        /**
         * Draws All of the Planets
         *
         * Draws each one of the planets in the planets array
         */
        for (Planet p : planets) {
            p.draw();
        }
        StdDraw.show();

        /**
         * Animation Part
         */
        // Double buffering makes animation not flickering
        StdDraw.enableDoubleBuffering();

        // Time loop
        int count = 0;
        while (count < T) {

            // Create an xForces array and yForces array.
            double[] xForces = new double[planets.length];
            double[] yForces = new double[planets.length];

            // Calculates the net x and y forces for each planet
            for (int i = 0; i < planets.length; ++i) {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }

            // Updates each of the planets
            for (int i = 0; i < planets.length; ++i) {
                planets[i].update(dt, xForces[i], yForces[i]);
            }

            // Draws the background image
            StdDraw.clear();
            StdDraw.picture(0, 0, "images/starfield.jpg");

            // Draws all of the planets
            for (Planet p : planets) {
                p.draw();
            }

            // Show
            StdDraw.show();

            // Pause
            StdDraw.pause(10);

            count += dt;
        }
    }

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

    /**
     * Returns an array of Planets corresponding to the planets in the given
     * file.
     */
    public static Planet[] readPlanets(String file_name) {
        In file_in = new In(file_name);

        int N = file_in.readInt();
        file_in.readDouble(); // Skips the double value radius

        Planet[] planets = new Planet[N]; // Just open N size of spaces for Planet
        for (int index = 0; index < N; ++index) {
            double xxPos = file_in.readDouble();
            double yyPos = file_in.readDouble();
            double xxVel = file_in.readDouble();
            double yyVel = file_in.readDouble();
            double mass = file_in.readDouble();
            String imgFileName = file_in.readString();

            /**
             * Instantiation of every Planet in planets array.
             */
            planets[index] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
        }
        return planets;
    }
}

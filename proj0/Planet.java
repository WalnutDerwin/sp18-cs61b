
public class Planet {

    // represents 6.67 * pow(10, -11);
    static final double G = 6.67e-11;

    public double xxPos; // its current x position
    public double yyPos; // its current y position
    public double xxVel; // its current velocity in the x direction
    public double yyVel; // its current velocity in the y direction
    public double mass;  // its mass
    public String imgFileName; // the name of the file corresponds to the image that depicts the planet

    /**
     * Planet Constructor taking 6 params
     */
    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    /**
     * Planet Constructor taking Planet p to copy
     */
    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    /**
     * Calculates the distance between two Planets
     *
     * @param p the distance between p and the planet that is doing the calc
     */
    public double calcDistance(Planet p) {
        double dx = xxPos - p.xxPos;
        double dy = yyPos - p.yyPos;
        return Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * Returns the total force exerted on this planet by the given planet
     */
    public double calcForceExertedBy(Planet p) {
        return (Planet.G * this.mass * p.mass) / (this.calcDistance(p) * this.calcDistance(p));
    }

    /**
     * Returns the X-direction force exerted by planet p
     */
    public double calcForceExertedByX(Planet p) {
        double dx = p.xxPos - this.xxPos; // Attention Signs!
        return (this.calcForceExertedBy(p) * dx) / this.calcDistance(p);
    }

    /**
     * Returns the Y-direction force exerted by planet p
     */
    public double calcForceExertedByY(Planet p) {
        double dy = p.yyPos - this.yyPos; // Attention Signs!
        return (this.calcForceExertedBy(p) * dy) / this.calcDistance(p);
    }

    /**
     * Calculates the net X force exerted by all planets in the array upon the
     * current Planet
     */
    public double calcNetForceExertedByX(Planet[] planets) {
        double netForceX = 0.0;
        for (Planet p : planets) {
            /**
             * Planets cannot exert forces on themselves and uses continue to
             * skip this circumstance.
             */
            if (p.equals(this)) {
                continue;
            }

            netForceX += this.calcForceExertedByX(p);
        }
        return netForceX;
    }

    /**
     * Calculates the net Y force exerted by all planets in the array upon the
     * current Planet
     */
    public double calcNetForceExertedByY(Planet[] planets) {
        double netForceY = 0.0;
        int lengthOfPlanets = planets.length;

        for (int index = 0; index < lengthOfPlanets; ++index) {
            /**
             * Planets cannot exert forces on themselves and uses continue to
             * skip this circumstance.
             */
            if (planets[index].equals(this)) {
                continue;
            }

            netForceY += this.calcForceExertedByY(planets[index]);
        }
        return netForceY;
    }

    /**
     * Updates the planet's position and velocity based on dt, fx and fy
     *
     * @param dt a small period of time
     * @param fx the X-direction force which will cause the planet to accelerate
     * @param fy the Y-direction force which will cause the planet to accelerate
     */
    public void update(double dt, double fx, double fy) {
        /**
         * Calculates the acceleration using the provided x- and y- forces
         */
        double xxAcc = fx / this.mass;
        double yyAcc = fy / this.mass;

        /**
         * Calculates the new velocity
         */
        this.xxVel += xxAcc * dt;
        this.yyVel += yyAcc * dt;

        /**
         * Calculates the new position
         */
        this.xxPos += this.xxVel * dt;
        this.yyPos += this.yyVel * dt;
    }
}

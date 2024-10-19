
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

}

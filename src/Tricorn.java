import java.awt.geom.Rectangle2D;
public class Tricorn extends FractalGenerator{


    public void getInitialRange(Rectangle2D.Double range) {
        range.x = -2;
        range.y = -2;
        range.width = 4;//в методичке до 2х
        range.height = 4;
    }
    public static final int MAX_ITERATIONS = 2000;

    public int numIterations(double x, double y) {
        double r = x;
        double i = y;
        int counter = 0;
        while (counter < MAX_ITERATIONS) {
            counter++;
            double k = r * r - i * i + x;
            double m = (-2) * r * i + y;
            r = k;
            i = m;
            if (r * r + i * i > 4)
                break;
        }
        if (counter == MAX_ITERATIONS)
            return -1;
        return counter;
    }
    public String toString() {
        return "Tricon";
    }
}

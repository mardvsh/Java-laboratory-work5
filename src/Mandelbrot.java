import java.awt.geom.Rectangle2D;

public class Mandelbrot extends FractalGenerator {




    public void getInitialRange(Rectangle2D.Double range) //передается прямоугольный объект, и метод должен изменить поля
    // прямоугольника для отображения правильного начального диапазона для
//фрактала.
    {
        range.x = -2; //область комплексной плоскости
        //для конкретного фрактала
        //абсцисса пикселя в исходной системе координат, в который помещено начало новой системы координат;
        range.y = -1.5;
        //ордината пикселя в исходной системе координат, в который помещено начало новой системы координат;
        range.height = 3;
        range.width = 3;
    }
    public static final int MAX_ITERATIONS = 2000;//Константу с максимальным количеством итераций

    public int numIterations(double x, double y) //реализует итеративную
    //функцию для фрактала Мандельброта
    {
        double r = x;
        double i = y;
        int counter = 0;
        while (counter < MAX_ITERATIONS)
        {
            counter++;
            double k = r * r - i*i + x; //xn+1=xn^2-yn^2+p
            double m = 2 * r * i + y; //yn+1=2xnyn+q
            r = k;
            i = m;
            if (r*r+i*i > 4)//все в квадрат, чтобы лучше и быстрее считалось
                //как только модуль окажется больше 2 (или, в терминах действительной и мнимой частей, все последующие модули последовательности станут стремиться к бесконечности.
                break;
        }

        if (counter == MAX_ITERATIONS)
            return -1;//чтобы показать, что точка не выходит за границы.
        return counter;
    }
    public String toString() {
        return "Mandelbrot";
    }
}

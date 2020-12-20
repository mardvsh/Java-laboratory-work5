import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage; // класс правляет изображением, содержимое которого можно записать.

public class JImageDisplay extends JComponent {
    private BufferedImage image; //одно поле с типом доступа private

    // объявление изображения и его параметров
    public JImageDisplay(int width, int height) {
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);//должен принимать целочисленные значения ширины и высоты и типом как цвета будут преставлены
        //значение TYPE_INT_RGB обозначает, что
        //красные, зеленые и синие компоненты имеют по 8 битов, представленные в
        //формате int в указанном порядке.
        Dimension dimension = new Dimension(width, height); //инициализировать объект
        super.setPreferredSize(dimension); // метод с указанной шириной и высотой
    }

    // метод отрисовки изображения
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);//После вызова версии суперкласса, вы можетe нарисовать изображение в компоненте, используя следующую операцию:
    }

    // очистка изображения (устанавливает все пиксели
    // в черный цвет)
    public void clearImage() {
        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                drawPixel(i, j, 0);
            }
        }
    }

    // задание цвета конкретному пикселю
    public void drawPixel(int x, int y, int rgbColor) {
        image.setRGB(x, y, rgbColor);
    }

    public BufferedImage getImage() {
        return image;
    }
}

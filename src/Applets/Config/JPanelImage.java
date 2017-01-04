package Applets.Config;

import javax.swing.*;
import java.awt.*;
import java.nio.file.Path;
import java.util.Collections;

/**
 Являє собою панель з картинкою.Прозорість фото визначається пареметрами разом з картинкою.
 */
public class JPanelImage extends JPanel {
    private Image image;
    private int i;

    private boolean is = true;

    public JPanelImage(Path path, int i) {
        this.i = i;

        if (i < 0 && i > 255) {
           this.i = 255 / 2;
        }

        image = new ImageIcon(path.toString()).getImage();


    }

    @Override
    protected void paintComponent(Graphics g) {

        if (is) {
            Color color = getBackground();
            g.setColor(new Color(color.getRed(),color.getGreen(),color.getBlue(),i));
        }

        g.drawImage(image, 0, 0, null);

    }
}

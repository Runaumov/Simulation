package org.simulation;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.simulation.field.*;
import org.simulation.entity.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class FieldPanel extends JPanel {
    private Field field;
    private int cellSize = 30;
    private final int width;
    private final int height;

    public FieldPanel(Field field) {
        this.field = field;
        width = field.getX() * cellSize;
        height = field.getY() * cellSize;
        this.setPreferredSize(new Dimension(width, height));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawField(g);
    }

    private void drawField(Graphics g) {
        Map<Coordinates, Entity> entitiesCopy = new HashMap<>(field.getEntities());
        for (Map.Entry<Coordinates, Entity> entry : entitiesCopy.entrySet()) {
            Coordinates coord = entry.getKey();
            Entity entity = entry.getValue();
            drawEntity(g, coord, entity);
        }
    }

    private void drawEntity(Graphics g, Coordinates coord, Entity entity) {
        BufferedImage emojiImage = getEmojiImageForEntity(entity);
        if (emojiImage != null) {
            g.drawImage(emojiImage, coord.getX() * cellSize, coord.getY() * cellSize, cellSize, cellSize, null);
        }
    }

    private BufferedImage getEmojiImageForEntity(Entity entity) {
        String emojiFileName = "";
        if (entity instanceof Grass) {
            emojiFileName = "/images/grass.png";
        } else if (entity instanceof Rabbit) {
            emojiFileName = "/images/rabbit.png";
        } else if (entity instanceof Fox) {
            emojiFileName = "/images/fox.png";
        } else if (entity instanceof Stone) {
            emojiFileName = "/images/stone.png";
        } else if (entity instanceof Tree) {
            emojiFileName = "/images/tree.png";
        } else if (entity instanceof Scull) {
            emojiFileName = "/images/scull.png";
        }
        try {
            // Загрузка изображения эмодзи из файла
            return ImageIO.read(getClass().getResourceAsStream(emojiFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }
}
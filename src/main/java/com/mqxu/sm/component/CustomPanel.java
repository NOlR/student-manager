package com.mqxu.sm.component;

import javax.swing.*;
import java.awt.*;

/**
 * @description: 自定义面板
 * @author: mqxu
 * @create: 2020-11-20 19:53
 **/
public class CustomPanel extends JPanel {
    private final Image image;

    public CustomPanel(Image image) {
        this.image = image;
    }

    /**
     * 固定背景图片，允许这个JPanel可以在图片上添加其他组件
     *
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
    }
}

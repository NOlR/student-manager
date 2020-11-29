package com.mqxu.sm.component;

import javax.swing.*;
import java.awt.*;

/**
 * @description: 自定义绘制背景图的面板类
 * @author: mqxu
 * @create: 2020-11-29 17:53
 **/
public class ImgPanel extends JPanel {
    private String fileName;

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    protected void paintComponent(Graphics g) {
        ImageIcon icon = new ImageIcon("src/main/resources/img/" + fileName);
        Image image = icon.getImage();
        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), icon.getImageObserver());
    }
}
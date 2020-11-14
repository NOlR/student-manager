package com.mqxu.sm.frame;

import sun.applet.Main;

import javax.swing.*;

/**
 * @description:
 * @author: mqxu
 * @create: 2020-11-14 20:55
 **/
public class MainFrame extends JFrame {
    private JPanel mainPanel;

    public MainFrame() {
        this.setTitle("MainFrame");
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}

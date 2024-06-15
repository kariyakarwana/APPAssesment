/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oop2assignment;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Sandaruwan
 */


public class RoundedPanel extends JPanel{
    private int radius;

    public RoundedPanel(int radius) {
        super();
        this.radius = radius;
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, width, height - radius, radius * 2, radius * 2);
        g.fillRect(0, radius, width, height - 2 * radius);
        g.fillRoundRect(0, height - radius, width, radius, radius * 2, radius * 2);
    }
}

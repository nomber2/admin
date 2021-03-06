package com.ui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by mona on 2017/9/22.
 */
public class BeauTextArea extends JTextArea {
    private int width;
    private int height;
    private String backPath;

    public BeauTextArea(String backPath){
        this.backPath = backPath;
        this.setPreferredSize(new Dimension(this.width,this.height));
        this.setBackground(null);
        //this.setOpaque(false);
        this.setLineWrap(true);
        this.setWrapStyleWord(true);
    }

    public BeauTextArea(){
        super();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/img/"+backPath));
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(this.width,this.height,Image.SCALE_FAST));
        imageIcon.paintIcon(this,g,0,0);
    }
}

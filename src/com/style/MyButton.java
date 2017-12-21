package com.style;

import javax.swing.*;
import java.awt.*;

/**
 * Created by 邓燕 on 2017/12/18.
 */
public class MyButton extends JButton{
    private String icon;
    private String words;

    public  MyButton( String words, String icon) {
        this.words = words;
        this.icon = icon;
        this.setText(this.words);
        this.setContentAreaFilled(true);
        this.setVisible(true);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/img/" + icon));
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(18, 18, Image.SCALE_FAST));  //将图片按照当前大小自适应
        imageIcon.paintIcon(this, g, 12,16);//将图片以填充方式绘制到整个面板上
        g.dispose();
    }


}

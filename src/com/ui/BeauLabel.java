package com.ui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by mona on 2017/9/22.
 * JLabel的文字设置
 */
public class BeauLabel extends JLabel {
    private String words;
    private Color fontColor;
    private String fontString;
    private int fontSize;

    public BeauLabel(String words, Color fontColor , String fontString,int fontSize) {
        this.fontColor = fontColor;
        this.words = words;
        this.fontSize = fontSize;
        this.fontString = fontString;
        this.setForeground(fontColor);
        this.setText(words);
        this.setFont(new Font(fontString,Font.PLAIN,fontSize));
    }
    public BeauLabel(){
        super();
    }
}

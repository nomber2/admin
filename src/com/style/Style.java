package com.style;

import org.junit.internal.runners.statements.FailOnTimeout;

import javax.swing.*;
import java.awt.*;
import java.lang.ref.PhantomReference;

/**
 * Created by Admin on 2017/12/19.
 */
public class Style {
    private final static Dimension BIG_SIZE = new Dimension(120,50);
    private final static Dimension NORMAL_SIZE = new Dimension(150,30);
    private final static Dimension SMALL_SIZE = new Dimension(90,30);

    private final static Color BLUE = new Color(30,39,66);
    private final static Color GREEN = new Color(70,140,80);

    private final static Font NORMAL_FONT = new Font("楷体",Font.PLAIN,16);
    private final static Font BOLD_FONT = new Font("楷体",Font.BOLD,36);
    private final static Font SMALL_FONT = new Font("楷体",Font.PLAIN,14);

    public static void setBIGButtonStyle(JButton button) {
        button.setPreferredSize(BIG_SIZE);
        button.setBackground(BLUE);
        button.setForeground(Color.WHITE);
        button.setFont(NORMAL_FONT);
        //button.setBorderPainted(false);
    }

    public static void setSmallButtonStyle(JComponent component) {
        component.setPreferredSize(SMALL_SIZE);
        component.setBackground(BLUE);
        component.setForeground(Color.WHITE);
        component.setFont(SMALL_FONT);
    }

    public static void setFieldStyle(JComponent component) {
        component.setPreferredSize(NORMAL_SIZE);
        //component.setBackground(Color.WHITE);
        //component.setForeground(Color.WHITE);
        component.setFont(NORMAL_FONT);
    }

    public static void setLabelStyle(JLabel label) {
        label.setForeground(BLUE);
        label.setFont(BOLD_FONT);
    }

    public static void setNomalFontFont(JComponent component) {
        component.setFont(NORMAL_FONT);
    }

    public static void setBoldFontFont(JComponent component) {
        component.setFont(BOLD_FONT);
    }

    public static void setChangeColor(JComponent component) {
        component.setBackground(GREEN);
    }

    public static void setNormalColor(JComponent component) {
        component.setBackground(BLUE);
    }

    public static void setChangeForeColor(JComponent component) {
        component.setForeground(Color.BLACK);
    }

    public static void setNormalForeColor(JComponent component) {
        component.setForeground(Color.WHITE);
    }

}

package com.style;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Admin on 2017/12/19.
 */
public class MyMouseAdapter extends MouseAdapter{
    private JComponent component;

    @Override
    public void mouseEntered(MouseEvent e) {
        Style.setChangeColor(component);
       // Style.setBoldFontFont(component);
    }

    @Override
    public void mouseExited(MouseEvent e) {
       Style.setSmallButtonStyle(component);
    }


    public MyMouseAdapter(JComponent component) {
        this.component = component;
    }
}

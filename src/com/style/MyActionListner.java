package com.style;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by 邓燕 on 2017/12/19.
 */
public class MyActionListner implements ActionListener {
    private JComponent component;

    public MyActionListner(JComponent component) {
        this.component = component;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Style.setBoldFontFont(component);
    }
}

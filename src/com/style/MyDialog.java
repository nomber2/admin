package com.style;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Admin on 2017-12-20
 * 自定义对话框
 */
public class MyDialog extends JDialog{
    private String info;
    private JLabel infoLabel;
    private JButton okButton;

    public MyDialog(String info) {
        this.info = info;
        setModal(true);
        setTitle("提示框");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setLayout(null);
        this.getContentPane().setBackground(new Color(79, 193, 176));
        infoLabel = new JLabel(info);
        Style.setLabelStyle(infoLabel);
        infoLabel.setBounds(200, 50, 200, 50);
        add(infoLabel);
        okButton = new JButton("确定");
        Style.setBIGButtonStyle(okButton);
        okButton.setBounds(180, 140, 120, 50);
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 MyDialog.this.dispose();
            }
        });
        add(okButton);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MyDialog("登录成功");
    }
}

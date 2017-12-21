package com.style;

import com.ui.BeauButton;

import javax.swing.*;
import java.awt.*;

/**
 * Created by 邓燕on 2017/12/18.
 */
public class MainFrame extends JFrame{
    private JPanel mainPanel;
    private JButton button;
    private JLabel label;
    private MyButton myButton;
    private BeauButton beauButton;
    private RoundBorder border = new RoundBorder();

    public MainFrame() {
        setTitle("111");
        setSize(500,400);
        Color bgColor = new Color(166, 197, 182);
        this.setBackground(bgColor);
        button = new JButton("徐江");
        myButton = new MyButton(" 设置","6.png");
        label = new JLabel("徐江");
        Style.setBIGButtonStyle(button);
        Style.setBIGButtonStyle(myButton);
        Style.setLabelStyle(label);
        button.addMouseListener(new MyMouseAdapter(button));
        myButton.addMouseListener(new MyMouseAdapter(myButton));
       // myButton.addActionListener(new MyActionListner(myButton));
        label.addMouseListener(new MyMouseAdapter(label));
        button.setBorder(new RoundBorder());
        button.setBorderPainted(true);
        myButton.setBorder(border);
        beauButton = new BeauButton(100,50,"6.png","设置",Color.BLACK,18,"宋体");
        mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        mainPanel.add(button);
        mainPanel.add(label);
        mainPanel.add(myButton);
        mainPanel.setBorder(border);
        mainPanel.add(beauButton);
        this.add(mainPanel);
        this.setVisible(true);
    }

    public static void main(String[] args) throws Exception{
       // UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        new MainFrame();
    }
}

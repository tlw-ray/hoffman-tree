package com.tlw.haffman;

import javax.swing.*;
import java.awt.*;

public class Driver extends JApplet {
    JTextField text = new JTextField(15);

    public Driver() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception var3) {
            var3.printStackTrace();
        }

        Container content = this.getContentPane();
        content.setLayout(new FlowLayout());
        content.add(new JLabel("Enter String: "));
        this.text.addActionListener(new TextEntryListener(this));
        content.add(this.text);
        Button btn = new Button("Choose File");
        btn.addActionListener(new FileOpenListener(this));
        content.add(btn);
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setContentPane(new Driver());
        f.addWindowListener(new Terminator());
        f.setTitle("Huffman Codes");
        f.pack();
        f.show();
    }

    public String getInputString() {
        String s = this.text.getText();
        this.text.setText("");
        return s;
    }
}

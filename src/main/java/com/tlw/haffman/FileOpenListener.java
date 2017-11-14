package com.tlw.haffman;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileOpenListener implements ActionListener {
    private Driver theDriver;

    public FileOpenListener(Driver d) {
        this.theDriver = d;
    }

    public void actionPerformed(ActionEvent e) {
        try {
            InputStreamReader in;
            try {
                in = WebStartHelper.getInputStreamReader();
            } catch (NoClassDefFoundError var6) {
                in = this.getInputStreamReader();
            } catch (UnsupportedOperationException var7) {
                in = this.getInputStreamReader();
            }

            if (in != null) {
                StringBuffer sb = new StringBuffer();

                for(int c = in.read(); c != -1; c = in.read()) {
                    sb.append((char)c);
                }

                HuffmanFrame f = new HuffmanFrame(new HuffmanTree(sb.toString()));
                f.setTitle("Huffman Tree");
                f.show();
            }
        } catch (IOException var8) {
            JOptionPane.showMessageDialog(this.theDriver, var8.getMessage(), "I/O Error", 2);
        } catch (SecurityException var9) {
            JOptionPane.showMessageDialog(this.theDriver, "Access to the file system is prohibited.", "Security Error", 2);
        } catch (NoClassDefFoundError var10) {
            JOptionPane.showMessageDialog(this.theDriver, "Package EDU.ksu.cis.viewer not found.", "Load Error", 2);
        }

    }

    private InputStreamReader getInputStreamReader() throws SecurityException, IOException {
        JFileChooser fc = new JFileChooser();
        fc.addChoosableFileFilter(new TextFileFilter());
        int ret = fc.showOpenDialog(this.theDriver);
        if (ret == 0) {
            File inFile = fc.getSelectedFile();
            return new FileReader(inFile);
        } else {
            return null;
        }
    }
}
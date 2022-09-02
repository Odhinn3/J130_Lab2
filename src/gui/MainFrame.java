/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author A.Konnov <github.com/Odhinn3>
 */
public class MainFrame extends JFrame {
    JPanel centerPanel;
    JTextArea textArea;

    public MainFrame() {
        init();
        setSize(300, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }
    
    private void init() {
        Container cp = getContentPane();
        textArea = new JTextArea();
        JButton b1 = new JButton("01");
        GridLayout gl = new GridLayout(5, 4, 3, 3);
        centerPanel = new JPanel(gl);
        cp.add(centerPanel, BorderLayout.CENTER);
        cp.add(b1, BorderLayout.WEST);
        cp.add(textArea, BorderLayout.NORTH);
        
        
    }
    

    
    

}

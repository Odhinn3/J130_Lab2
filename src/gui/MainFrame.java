/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import java.awt.Container;


import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import MainPack.Repository;
import javax.swing.JTextField;



/**
 *
 * @author A.Konnov <github.com/Odhinn3>
 */

public class MainFrame extends JFrame {

    public MainFrame() {
        super("Products & orders viewing");
        setSize(600, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        init();
        setVisible(true);
    }
    JButton butt = new JButton("View table");
    JTextField t1 = new JTextField();
    JTextField t2 = new JTextField();

    private static String f1;
    private static String f2;

    private void init() {
        Container con = getContentPane();
        con.setLayout(new BoxLayout(con, BoxLayout.Y_AXIS));

        butt.addActionListener((ActionEvent e) -> {
            Repository repo = new Repository();
            t1.setText(repo.getModelList().toString());
        });
        con.add(t1);
        con.add(t2);
        con.add(butt);
        if(f1==null){
            t1.addActionListener((ActionEvent e) -> {
                setF1(t1.getText());
                t1.getText();
                System.out.println(getF1());
            });
        }
        if(f2==null){
            t2.addActionListener((ActionEvent e) -> {
                setF2(t2.getText());
                t2.getText();
                System.err.println(getF2());
            });
        }
    }

    public static String getF1() {
        return f1;
    }

    private void setF1(String f1) {
        this.f1 = f1;
    }
    
    public static String getF2() {
        return f2;
    }

    private void setF2(String f2) {
        this.f2 = f2;
    }  
}

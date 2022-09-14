/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import dnl.utils.text.table.TextTable;
import java.awt.Container;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import MainPack.Repository;
import javax.swing.JTextField;


/**
 *
 * @author A.Konnov <github.com/Odhinn3>
 */
import MainPack.DataBaseProperties;
public class MainFrame extends JFrame {

    public MainFrame() {
        super("Products & orders viewing");
        setSize(600, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        init();
        setVisible(true);
    }
    
    JButton butt = new JButton("View table");
    JTextField t1 = new JTextField(DataBaseProperties.get().getProperty("db.url"));
    JTextField t2 = new JTextField("javadev.products");
 
    private void init() {
        Container con = getContentPane();
        con.setLayout(new BoxLayout(con, BoxLayout.Y_AXIS));


        ActionListener bl = new ButtonListener();
        butt.addActionListener(bl);
        con.add(t1);
        con.add(t2);
        con.add(butt);
    }

    private class ButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Repository repo = new Repository();
            
            t1.setText(repo.getModelList().toString());
        }
        
    } 
    
    



    //TextTable tt = new TextTable(columnNames, data);
}

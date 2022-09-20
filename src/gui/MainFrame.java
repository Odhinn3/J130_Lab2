
package gui;

import java.awt.event.*;
import java.awt.Container;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import mod.Model;
import MainPack.Repository;

/**
 *
 * @author A.Konnov <github.com/Odhinn3>
 */

public class MainFrame extends JFrame {
    
    private Repository repo = new Repository();
    private List<Model> lst;

    public MainFrame() {
        super("Products & orders viewing");
        setSize(600, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        init();
        setVisible(true);
    }
    JButton butt = new JButton("View table");
    JTextField t1 = new JTextField("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL");
    JTextField t2 = new JTextField("javadev.products");
    JScrollPane scrollpane = new JScrollPane();

    private static String f1;
    private String f2;

    private void init() {
        Container con = getContentPane();
        con.setLayout(new BoxLayout(con, BoxLayout.Y_AXIS));
        con.add(t1);
        con.add(t2);
        con.add(butt);
        con.add(scrollpane);
        butt.addActionListener((ActionEvent e) -> {
                con.remove(t1);
                con.remove(t2);
                JTable t = new JTable(getTableModel());
                con.add(t.getTableHeader(),0);
                con.add(scrollpane.add(t), 1);
                setVisible(true);
        });
 
        t1.addActionListener((ActionEvent e) -> {
            setF1(t1.getText());
            System.out.println(getF1());
            });
        
        t2.addActionListener((ActionEvent e) -> {
            setF2(t2.getText());
            System.out.println(getF2());
            });
    }
    
    private DefaultTableModel getTableModel(){
        switch (f2) {
            case "javadev.products": 
            {
                Object[] columnNames = {"Articul", "Name", "Color", "Price", "Remains"};
                DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
                lst = repo.getModelList(getF2());
                for(int i = 0; i<lst.size(); ++i){
                    Model m = lst.get(i);
                    Object[] tmp = {m.getArticul(), m.getName(), m.getColor(), m.getPrice(), m.getRemain()};
                    tableModel.addRow(tmp);
                }
                return tableModel;
                
            }
            case "javadev.orders": 
            {
                Object[] columnNames = {"ID", "Orderdate", "Customer", "Phone",
                    "email", "Address", "Status", "Shipdate"};
                DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
                lst = repo.getModelList(getF2());
                for(int i = 0; i<lst.size(); ++i){
                    Model m = lst.get(i);
                    Object[] tmp = {m.getId(), m.getOrderdate(),
                        m.getCustomername(), m.getPhone(), m.getEmail(),
                        m.getAddress(), m.getStatus(), m.getShipdate()};        
                    tableModel.addRow(tmp);
                }
                return tableModel;
            }
            case "javadev.orderpos":
            {
                Object[] columnNames = {"Ordercode", "Articul", "Price", "Number"};
                DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
                lst = repo.getModelList(getF2());
                for(int i = 0; i<lst.size(); ++i){
                    Model m = lst.get(i);
                    Object[] tmp = {m.getOrdercode(), m.getArticul(),
                        m.getPrice(), m.getNumber()};        
                    tableModel.addRow(tmp);
                }
                return tableModel;
            }
        }
        return null;
    }

    public static String getF1() {
        return f1;
    }

    private void setF1(String f1) {
        this.f1 = f1;
    }
    
    public String getF2() {
        return f2;
    }

    private void setF2(String f2) {
        this.f2 = f2;
    }   
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainPack;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author A.Konnov <github.com/Odhinn3>
 */
public class DataBaseProperties extends Properties {
    private static DataBaseProperties dbp;
    
    private DataBaseProperties(){}
    
    public static DataBaseProperties get(){
        if(dbp==null) {
            dbp = new DataBaseProperties();
            File file = new File("db.properties");
            try {
            if(!file.exists())
                file.createNewFile();
            dbp.load(new FileInputStream(file));
            } catch (IOException ex) {
                Logger.getLogger(DataBaseProperties.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return dbp;
    }
}

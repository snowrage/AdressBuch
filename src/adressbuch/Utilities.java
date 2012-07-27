/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adressbuch;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;

/**
 *
 * @author msc
 */
public class Utilities {
    
    public static void saveBinary(ObservableList<Person> data) {
        File file = new File("./adressbuch");
        FileOutputStream fos = null;
        DataOutputStream dos = null;

        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            fos = new FileOutputStream(file);
            dos = new DataOutputStream(fos);

            for (Person person : data) {
                dos.writeUTF(person.getFirstName());
                dos.writeUTF(person.getLastName());
                dos.writeUTF(person.getEmail());
            }

        } catch (IOException e) {
            Logger.getLogger(ViewController.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (dos != null) {
                try {
                    dos.close();
                } catch (IOException e) {
                    Logger.getLogger(ViewController.class.getName()).log(Level.SEVERE, null, e);
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    Logger.getLogger(ViewController.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }
    
}

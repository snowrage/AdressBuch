/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adressbuch;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author msc
 */
public class Utilities {
    
    public static ObservableList loadBinary(){
        File file = new File("./adressbuch");
        FileInputStream fis = null;
        DataInputStream dis = null;
        ObservableList<Person> data = FXCollections.observableArrayList();
        boolean EOF = false;
        
        try {
            if(file.exists()){
                fis = new FileInputStream(file);
                dis = new DataInputStream(fis);
                while(!EOF){
                    try{
                        Person person = new Person();
                        person.setFirstName(dis.readUTF());
                        person.setLastName(dis.readUTF());
                        person.setEmail(dis.readUTF());
                        data.add(person);
                    }catch (EOFException e) {
                        EOF = true;
                    }
                }
            }
        }catch (IOException e) {
            Logger.getLogger(ViewController.class.getName()).log(Level.SEVERE, null, e);
        }finally {
            if (dis != null) {
                try {
                    dis.close();
                } catch (IOException e) {
                    Logger.getLogger(ViewController.class.getName()).log(Level.SEVERE, null, e);
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    Logger.getLogger(ViewController.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
        return data;
    }
    
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

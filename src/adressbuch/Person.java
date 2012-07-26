/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adressbuch;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author msc
 */
public class Person {
    
   private final SimpleStringProperty firstName = new SimpleStringProperty("");
   private final SimpleStringProperty lastName = new SimpleStringProperty("");
   private final SimpleStringProperty email = new SimpleStringProperty("");
   
   public Person() {
        this("", "", "");
    }
 
    public Person(String firstName, String lastName, String email) {
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
    }

    public String getFirstName() {
        return firstName.get();
    }
 
    public final void setFirstName(String fName) {
        firstName.set(fName);
    }
        
    public String getLastName() {
        return lastName.get();
    }
    
    public final void setLastName(String fName) {
        lastName.set(fName);
    }
        
    public String getEmail() {
        return email.get();
    }
    
    public final void setEmail(String fName) {
        email.set(fName);
    }
    
}

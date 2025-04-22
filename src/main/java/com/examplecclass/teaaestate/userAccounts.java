package com.examplecclass.teaaestate;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public interface userAccounts {
    public static void createAdminAccount(adminSignUp i) {

        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            f = new File("adminAccount.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(i);

        } catch (IOException ex) {
            Logger.getLogger(adminSignUp.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(adminSignUp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public static boolean CheckAdminAccount(String mail) {
        ObjectInputStream ois = null;
        boolean result = false;
        try {
            adminSignUp b;
            ois = new ObjectInputStream(new FileInputStream("adminAccount.bin"));

            while(true){
                b = (adminSignUp) ois.readObject();
                System.out.println(b.getMail());
                System.out.println(b.getPassword());
                if(b.getMail().equals(mail)) {
                    result = true;
                }
            }
        }
        catch(RuntimeException e){
            e.printStackTrace();
        }
        catch (Exception ex) {
            try {
                if(ois!=null)
                    ois.close();
            } catch (IOException ex1) {  }
        }
        return result;
    }

    public static boolean adminMailPasswordMatch(String mail, String password) {
        ObjectInputStream ois = null;
        boolean result = false;
        try {
            adminSignUp b;
            ois = new ObjectInputStream(new FileInputStream("adminAccount.bin"));

            while(true){
                b = (adminSignUp) ois.readObject();
                if(b.getMail().equals(mail)) {
                    if(b.getPassword().equals(password)) {
                        result = true;
                    }
                }
            }
        }
        catch(RuntimeException e){
            e.printStackTrace();
        }
        catch (Exception ex) {
            try {
                if(ois!=null)
                    ois.close();
            } catch (IOException ex1) {  }
        }
        return result;
    }
}

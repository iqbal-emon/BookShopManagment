package com.example.loginproject;

import java.io.*;
import java.util.ArrayList;

class MyObjectOutputStream extends ObjectOutputStream {


    MyObjectOutputStream() throws IOException
    {

        super();
    }

    MyObjectOutputStream(OutputStream o) throws IOException
    {
        super(o);
    }

    // Method of this class
    public void writeStreamHeader() throws IOException
    {
        return;
    }
}
public class FileConnection {
    private FileInputStream fileInputStream;
    private FileOutputStream fileOutputStream;
    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;
    private File file;

    public UserInfo dataStored(UserInfo user){
        File file = new File("database.out");
        try {
            fileOutputStream = new FileOutputStream("database.out",true);

            if(file.length()==0){
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(user);
                objectOutputStream.close();
            }
            else{
                MyObjectOutputStream myObjectOutputStream = new MyObjectOutputStream(fileOutputStream);
                myObjectOutputStream.writeObject(user);
                myObjectOutputStream.close();
            }

        }catch (Exception e){
            System.out.println("Data Stored Problem.");
            System.exit(0);
        }


        return user;
    }
    public ArrayList<UserInfo> readData(){
        file = new File("database.out");
        ArrayList<UserInfo> users = new ArrayList<>();
        UserInfo user;
        if(file.length()!=0){

            try{
                fileInputStream = new FileInputStream("database.out");
                objectInputStream = new ObjectInputStream(fileInputStream);
                while (fileInputStream.available()!=0){

                    user = (UserInfo) objectInputStream.readObject();

                    users.add(user);
                }
                objectInputStream.close();
            }catch (Exception e){
                System.out.println("Data can't read");
            }
        }
        return users;

    }

}

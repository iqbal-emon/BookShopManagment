package com.example.loginproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class HelloController implements Initializable {
    @FXML
    private Label total;
    @FXML
    private Label pr;
    private ObjectOutputStream objectOutputStream;
    @FXML
    private TextField first;
    @FXML
    private  Label search1;
    @FXML
    private TextField search;
    @FXML
    private PasswordField password;
    @FXML
    private TextField book_id;
    @FXML private TextField book_title;
    @FXML private TextField author;
    @FXML private  DatePicker date;
    @FXML private  TextField price;
    @FXML private  TextField genre;
    @FXML private TableView<UserInfo> table;
    @FXML private TableColumn<UserInfo,String> Book_id;
    @FXML private  TableColumn<UserInfo,String> Book_title;
    @FXML private  TableColumn<UserInfo,String> Author;
    @FXML private  TableColumn<UserInfo,String> Genre;
    @FXML private  TableColumn<UserInfo,String> Date;
    @FXML private  TableColumn<UserInfo,String> Price;
    private double x = 0;
    private double y = 0;
   static Integer count = 0;
    ObservableList<UserInfo> list = FXCollections.observableArrayList();
    boolean loadDataStatus=false;
    char charArray[];
    @FXML
    public void dashboard(){
//        String[] data = new String[100];
//        String[] user = new String[100];
//        String[] pass= new String[100];
//        String[] pass1= new String[100];


        try {
//            File myObj = new File("F:\\logInProject (1)\\logInProject\\login.txt");
//            Scanner myReader = new Scanner(myObj);
//            int i=0;
//            int j=0;
//            int k=0;
//            int m=0;
//            while (myReader.hasNextLine()) {
//
//                data[i]=myReader.nextLine();
//                user=data[i].split(" ");

//            pass[j]=user[0];
//            pass1[k]=user[1];

//                if(first.getText().equals(user[0])&&password.getText().equals(user[1])){
//                    System.out.println("log in successful");

                    // LINK YOUR DASHBOARD FORM : )
                    Parent root = FXMLLoader.load(getClass().getResource("hello-view1.fxml"));

                    Stage stage = new Stage();
                    Scene scene = new Scene(root);

                    root.setOnMousePressed((MouseEvent event) ->{
                        x = event.getSceneX();
                        y = event.getSceneY();
                    });

                    root.setOnMouseDragged((MouseEvent event) ->{
                        stage.setX(event.getScreenX() - x);
                        stage.setY(event.getScreenY() - y);
                    });

                    stage.initStyle(StageStyle.TRANSPARENT);

                    stage.setScene(scene);
                    stage.show();



//                }
//                i++;
//                j++;



//        }
//        catch (FileNotFoundException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
        } catch (IOException e) {
           e.printStackTrace();
        }
    }
    @FXML
    protected void showDetails() {

        if(loadDataStatus==false) {

            list.addAll(fc.readData());
            for (UserInfo ua : list) {
                count = count + Integer.valueOf(ua.getPrice());
//                    System.out.println(ua.getPrice());
//                    System.out.println(list.get(5).getPrice());
//                 count=Integer.parseInt(String.valueOf(list.get(5)));
//            count++;
            }
        }  total.setText(String.valueOf(count));
loadDataStatus=true;

    }


    @FXML
    protected void dataStore() {
        if(loadDataStatus==true) {
            String book_idText = book_id.getText();
            String book_titleText = book_title.getText();
            String genreText = genre.getText();
            String authorText = author.getText();
            String dateText = String.valueOf(date.getValue());
            String priceText = price.getText();

            UserInfo user1 = new UserInfo(book_idText, book_titleText, authorText, genreText, dateText, priceText);

            FileConnection fc = new FileConnection();
            fc.dataStored(user1);
            table.setItems(clear());
            table.setItems(list);
            loadDataStatus = false;
//        }
        }

    }



    FileConnection fc = new FileConnection();
    @FXML protected void searchData(){
        Integer s=0;
        Integer k=0;

        System.out.println(search.getText());
                for(UserInfo u:list) {

                    if (u.getBook_title().equals(search.getText())) {
                                         search1.setText("id: "+u.getBook_id()+" B_id: "+u.getBook_title()+" Auth: "+u.getAuthor()+" Genre: "+u.getGenre()+" Date: "+u.getDate()+" Price: "+u.getPrice());
                        s++;

//                         table.setTableMenuButtonVisible(true);
//                        System.out.println("id:"+u.getBook_id() + "book_title"+u.getBook_id());
//                        System.out.println("Search found");

                    } else {
                        k++;
                    }






                }
                if(k==list.size()){
                    search1.setText("");
                }

    }
    @FXML protected void deleteData() throws IOException {

        File temp = new File("database.out");
        if (temp.exists()) {
            RandomAccessFile raf = new RandomAccessFile(temp, "rw");
            raf.setLength(0);
        }
        for(UserInfo u:list){

            if(u.getBook_id().equals(book_id.getText())){
                list.remove(u);

            }
            fc.dataStored((UserInfo) u);



        }

        System.out.println("done");


    }
    @FXML
    protected void onLoadData(){

//        FileConnection fc = new FileConnection();
//        //System.out.println("Start");
//        list.addAll(fc.dataFatch());
        //System.out.println("end");
//        for(UserInfo u:list){
//            System.out.println(u);
//        }
//        FileConnection fc = new FileConnection();
        if(loadDataStatus == false){
            /// 1. table clear
            /// 2. new upadated file will be loaded
            list.addAll(fc.readData());
            Book_id.setCellValueFactory(new PropertyValueFactory<UserInfo,String>("Book_id"));
            Book_title.setCellValueFactory(new PropertyValueFactory<UserInfo,String>("Book_title"));
            Author.setCellValueFactory(new PropertyValueFactory<UserInfo,String>("Author"));
            Genre.setCellValueFactory(new PropertyValueFactory<UserInfo,String>("Genre"));
            Date.setCellValueFactory(new PropertyValueFactory<UserInfo,String>("Date"));
            Price.setCellValueFactory(new PropertyValueFactory<UserInfo,String>("Price"));
            table.setItems(list);
            loadDataStatus = true;
        }


    }
//    private void storeUserInfo(UserInfo user){
//        FileConnection fc = new FileConnection();
//        fc.dataStored(user);
//    }
@FXML
public void loginAdmin(){
    String[] data = new String[100];
    String[] user = new String[100];
    String[] pass= new String[100];
    String[] pass1= new String[100];


    try {
        File myObj = new File("F:\\logInProject (1)\\logInProject\\login.txt");
        Scanner myReader = new Scanner(myObj);
        int i=0;
        int j=0;
        int k=0;
        int m=0;
        while (myReader.hasNextLine()) {

            data[i]=myReader.nextLine();
            user=data[i].split(" ");

//            pass[j]=user[0];
//            pass1[k]=user[1];

            if(first.getText().equals(user[0])&&password.getText().equals(user[1])){
                System.out.println("log in successful");

                // LINK YOUR DASHBOARD FORM : )
                Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);

                root.setOnMousePressed((MouseEvent event) ->{
                    x = event.getSceneX();
                    y = event.getSceneY();
                });

                root.setOnMouseDragged((MouseEvent event) ->{
                    stage.setX(event.getScreenX() - x);
                    stage.setY(event.getScreenY() - y);
                });

                stage.initStyle(StageStyle.TRANSPARENT);

                stage.setScene(scene);
                stage.show();



            }
            i++;
            j++;

}


    } catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}

    public void close(){
        System.exit(0);
    }

    public void details() throws IOException {



    }


    public ObservableList<UserInfo> clear(){
        list.clear();
        return null;
    }
    public void initialize(URL url, ResourceBundle resourceBundle) {



    }
}
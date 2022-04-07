/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author 1030G3
 */
public class Customer extends Application {
    Connection conn=null;
Statement stm=null;
PreparedStatement pst=null;
ResultSet rs=null;
    
    @Override
    public void start(Stage primaryStage) {
        
        GridPane ni= new GridPane();
          ni.setHgap(13); 
         ni.setVgap(13);
        Button btn = new Button();
        btn.setText("Login");
           Label name_2 = new Label("Username"); 
            TextField username=new TextField();  
           Label name_3 = new Label("Password");
            TextField pass=new TextField(); 
        
        
        
        
        
        ni.addRow(2,name_2,username);
        ni.addRow(4,name_3,pass);
        ni.addRow(10,btn);
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                
                
                
                
                     String ju=username.getText();
       String passi=pass.getText();
        
        Premium connect=new Premium();
        conn=connect.connectdb();
        if(ju.equals("")){
            JOptionPane.showMessageDialog(null,"Enther the user name!");
            return;
        }
      
        if(passi.equals("")){
            JOptionPane.showMessageDialog(null,"Enter valid password!");
            return;
            
        }
         
        try{
            String ff="SELECT*FROM login";
           pst=conn.prepareStatement(ff);
           rs=pst.executeQuery();
           
           while(rs.next()){
         String mtu=      rs.getString("username");
         String fujo=    rs.getString("password");
         
         if(ju.equals("user")&&fujo.equals("user")){
             Stage s= new Stage();
              
              new CarRentalTester().start(s);
            
             return;
         }
           }
           JOptionPane.showMessageDialog(null, " Wrong Password");
           
            
       }catch(Exception e){
            JOptionPane.showMessageDialog(null,"PLEASE OPEN YOUR DATABASE");
            JOptionPane.showMessageDialog(null,"PLEASE CONFIRM YOUR DATABASE IS UP AND RUNNING","SYSTEM ERROR",JOptionPane.INFORMATION_MESSAGE);
        }
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
              
             
              
            }
        });
        
        
        StackPane root = new StackPane();
        root.getChildren().add(ni);
        
        Scene scene = new Scene(root, 500, 450);
        
        primaryStage.setTitle("Transport system");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

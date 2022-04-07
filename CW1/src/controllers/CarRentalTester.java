/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.Color;
import static java.awt.Event.BACK_SPACE;
import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import javax.swing.JOptionPane;


public class CarRentalTester extends Application {
    
   Connection conn=null;
Statement stm=null;
PreparedStatement pst=null;
ResultSet rs=null;
  @Override 
   public void start(Stage stage) {      
      TabPane tabPane = new TabPane();

   
GridPane add_stock = new GridPane();//adding information to the jave add stock pane
GridPane  grid = new GridPane();
GridPane  book = new GridPane();
Label m_i=new Label("Product_ID");  
    Label name_2 = new Label("Product name"); 
    Label modelyear = new Label("Product year");  
    Label number_plate = new Label("Quanity");  
    Label seats = new Label("items");  
    Label colors = new Label("Description");  
    Label Price = new Label("Price");  
    TextField M1_1=new TextField();  
    TextField name_2_2=new TextField();  
     TextField modelyear_1=new TextField(); 
      TextField number_plate_1=new TextField(); 
       TextField seats_1=new TextField(); 
        TextField colors_1=new TextField(); 
         TextField Price_1=new TextField(); 
    Button b = new Button("ADD");
      Button update= new Button("UPDATE");
        Button delete = new Button("DELETE");
    
    Label customer=new Label("Customer _id");  
    Label customer_id = new Label("customer name"); 
    Label customer_addres= new Label("Customer address");  
    Label date = new Label("Date");  
    Label car_id = new Label("Car _id");
    
    
    TextField customer_1=new TextField();  
    TextField customer_id_1=new TextField();  
     TextField customer_addres_1=new TextField(); 
      TextField date_1=new TextField(); 
       TextField car_id_1=new TextField();
       
       Button BK= new Button("ORDER");
        Button del= new Button("DELETE ORDER");
       
       book.addRow(0,customer,customer_1);
        book.addRow(2,customer_id,customer_id_1);
         book.addRow(3,customer_addres,customer_addres_1);
          book.addRow(4,date,date_1);
           book.addRow(5,car_id,car_id_1);
          
              book.addRow(6,BK);
              book.add(del,2,6);
           book.setHgap(13); 
         book.setVgap(13);
    
    
   // add_stock.setStyle("-fx-background-color:#808080; -fx-opacity:1;");//adding the components to the gridpane
   //  grid.setStyle("-fx-background-color:#808080; -fx-opacity:1;");
    add_stock.addRow(0, m_i,M1_1);       
    add_stock.addRow(1, name_2,name_2_2);  
    add_stock.addRow(2, modelyear,modelyear_1); 
    add_stock.addRow(3,number_plate,number_plate_1); 
    add_stock.addRow(4, seats,seats_1); 
    add_stock.addRow(5, colors,colors_1); 
    add_stock.addRow(6, Price,Price_1); 
    
     add_stock.add(b, 1, 7);
     add_stock.add(update,2,7);
     add_stock.add(delete, 3,7);
    add_stock .setHgap(13); 
    add_stock .setVgap(13);
    
    
    
    ///View the informaton on the table
     Car p= new Car();
               p.viewstock();
     String vehicles[][] =new String[p.modelID.size()][7]; 
    
   
    
    
     for(int row=0;row<vehicles.length;row++){
                        
                        for(int col=0;col<vehicles[0].length;col++){
                         if(col==0) {
                            
                               vehicles[row][col]=p.modelID.get(row).replaceAll("\\s+", " ");
                          }
                          if(col==1) {
                            
                               vehicles[row][col]=p.modelname.get(row).replaceAll("\\s+", " ");
                          }
                            if(col==2) {
                            
                               vehicles[row][col]=p.modelyeare.get(row).replaceAll("\\s+", " ");
                          }
                            if(col==3) {
                            
                               vehicles[row][col]=p.number_Plate.get(row);
                          }
                            if(col==4) {
                            
                               vehicles[row][col]=p.seatss.get(row);
                          }
                            if(col==5) {
                            
                               vehicles[row][col]=p.Color.get(row);
                          }
                            if(col==6) {
                            
                               vehicles[row][col]=p.Price.get(row);
                          }
                         //   System.out.print(arrayOfEarth[row][col]+"\t");                   
                        }
                       
                    }
    
    
        ObservableList<String[]> data = FXCollections.observableArrayList();
        data.addAll(Arrays.asList(vehicles));
        data.remove(0);//remove titles from data
        TableView<String[]> table = new TableView<>();
        for (int i = 0; i < vehicles[0].length; i++) {
            TableColumn tc = new TableColumn(vehicles[0][i]);
            final int colNo = i;
            tc.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<String[], String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TableColumn.CellDataFeatures<String[], String> p) {
                    return new SimpleStringProperty((p.getValue()[colNo]));
                }
            });
            tc.setPrefWidth(90);
            table.getColumns().add(tc);
        }
        table.setItems(data);
       
   
    
    
        
        
       //loading tab 4
       
       PrintBookingDetails R=new  PrintBookingDetails();
                R.viewstock();
                
        ObservableList<String[]> data1 = FXCollections.observableArrayList();
        data1.addAll(Arrays.asList(R.r_booked));
        data1.remove(0);//remove titles from data
        TableView<String[]> table1 = new TableView<>();
        for (int i = 0; i < R.r_booked[0].length; i++) {
            TableColumn tc = new TableColumn(R.r_booked[0][i]);
            final int colNo = i;
            tc.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<String[], String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TableColumn.CellDataFeatures<String[], String> p) {
                    return new SimpleStringProperty((p.getValue()[colNo]));
                }
            });
            tc.setPrefWidth(90);
            table1.getColumns().add(tc);
        }
        table1.setItems(data1);
        
        
        ObservableList<String[]> data2 = FXCollections.observableArrayList();
        data2.addAll(Arrays.asList(R.r_booked));
        data2.remove(0);//remove titles from data
        TableView<String[]> table2 = new TableView<>();
        for (int i = 0; i < R.r_booked[0].length; i++) {
            TableColumn tc = new TableColumn(R.r_booked[0][i]);
            final int colNo = i;
            tc.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<String[], String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TableColumn.CellDataFeatures<String[], String> p) {
                    return new SimpleStringProperty((p.getValue()[colNo]));
                }
            });
            tc.setPrefWidth(90);
            table2.getColumns().add(tc);
        }
        table2.setItems(data2);
        
        
    
             grid.addColumn(0,table);
            // grid.addRow(4, table1);
             
              grid.setHgap(13); 
              grid.setVgap(13);
    

        Tab tab1 = new Tab("Add Product", new Label(""));
        Tab tab2 = new Tab("View avaiable cars"  , new Label());
        
        Tab tab3 = new Tab("Books  A Product" , new Label(""));
        Tab tab4 = new Tab("Report of each booked Product" , new Label());
        Tab tab5 = new Tab("Status of each Product",new Label() );

    
       
          tab1.setContent(add_stock);//adding the tabs to the tabpane
       tab2.setContent(table);
       tab4.setContent(table1);
       tab5.setContent(table2);
       tab3.setContent(book);
       
      
        tabPane.getTabs().add(tab1);
        tabPane.getTabs().add(tab2);
        tabPane.getTabs().add(tab3);
        tabPane.getTabs().add(tab4);
        tabPane.getTabs().add(tab5);
        
    
         modelyear_1.textProperty().addListener((observable, oldValue, newValue) -> {
        if (!newValue.matches("\\s 0-9*")) {
           modelyear_1.setText(newValue.replaceAll("[^\\s0-9]", ""));
          
        }
       
         });
        
          M1_1.textProperty().addListener((observable, oldValue, newValue) -> {
        if (!newValue.matches("\\s 0-9*")) {
           M1_1.setText(newValue.replaceAll("[^\\s0-9]", ""));
          
        }
       
         });
        
            seats_1.textProperty().addListener((observable, oldValue, newValue) -> {
        if (!newValue.matches("\\s 0-9*")) {
           seats_1.setText(newValue.replaceAll("[^\\s0-9]", ""));
          
        }
       
         });
            
            
              Price_1.textProperty().addListener((observable, oldValue, newValue) -> {
        if (!newValue.matches("\\s 0-9*")) {
          Price_1.setText(newValue.replaceAll("[^\\s0-9]", ""));
          
        }
       
         });
              
                customer_1.textProperty().addListener((observable, oldValue, newValue) -> {
        if (!newValue.matches("\\s 0-9*")) {
           customer_1.setText(newValue.replaceAll("[^\\s0-9]", ""));
          
        }
       
         });
                
                  car_id_1.textProperty().addListener((observable, oldValue, newValue) -> {
        if (!newValue.matches("\\s 0-9*")) {
           car_id_1.setText(newValue.replaceAll("[^\\s0-9]", ""));
          
        }
       
         });
      customer_id_1.textProperty().addListener((observable, oldValue, newValue) -> {
        if (!newValue.matches("\\sa-zA-Z*")) {
           customer_id_1.setText(newValue.replaceAll("[^\\sa-zA-Z]", ""));
          
        }
       
        
    });
        colors_1.textProperty().addListener((observable, oldValue, newValue) -> {
        if (!newValue.matches("\\sa-zA-Z*")) {
            colors_1.setText(newValue.replaceAll("[^\\sa-zA-Z]", ""));
          
        }
       
        
    });
        
        name_2_2.textProperty().addListener((observable, oldValue, newValue) -> {
        if (!newValue.matches("\\sa-zA-Z*")) {
            name_2_2.setText(newValue.replaceAll("[^\\sa-zA-Z]", ""));
          
        }
       
        
    });
      
       del.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            
                
                
                
                
                
             if( customer_1.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Enter customer id to delete the booked Product");
                return;
                }
           
            
            
            
             JOptionPane.showMessageDialog(null,"The booked car has been deleted");
              // return;
             
            
            
            
            }});
      
      
       
      
      
       
       
       
       
       
       
       
      
      
      
      
      
      
      
     
        BK.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            
                 
                
                
                
                
             if( customer_1.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Enter customer id");
                return;
                }
            if( customer_id.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Enter customer name");
                return;
                }
            
            if( customer_addres_1.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Enter customer address");
                return;
                }
            if(date_1.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Enter date");
                return;
                }
            
            if( car_id_1.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Enter  Product  id");
                return;
                }
            CarBooking k= new  CarBooking();
           
               k.customer_name=customer_1.getText();
              
               k.customerId=customer_id_1.getText();
               
               k.CustomerAddress=customer_addres_1.getText();
               
               k.date=date_1.getText();
               
               String carid=car_id_1.getText();
               
               if(p.modelID.contains(carid)){
               
               }else{
             //  JOptionPane.showMessageDialog(null,"Can does not exist");
              // return;
             
              
               }
            
            
            
             JOptionPane.showMessageDialog(null,"Item BOOKED");
              // return;
             
            
            
            
            }});
        
        
        
         delete.setOnAction(new EventHandler<ActionEvent>() {//update the information that is saved on the file
            @Override
            public void handle(ActionEvent event) {// the action even to save information to the database
               Car p= new Car();
               p.viewstock();
                PrintBookingDetails R=new  PrintBookingDetails();
                R.viewstock();
               if(  R.modelID.contains(M1_1.getText())){
               
               JOptionPane.showMessageDialog(null,"The Product with the ID exists");
               return;
               }
                if(M1_1.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Enter the Product model number you want to delete");
                return;
                }
               
                      JOptionPane.showMessageDialog(null,"The Product model is deleted");//shows that the message has been saved to the database
                      
                      M1_1.setText("");
                      
            }
        });
        
         update.setOnAction(new EventHandler<ActionEvent>() {//update the information that is saved on the file
            @Override
            public void handle(ActionEvent event) {// the action even to save information to the database
               Car p= new Car();
               p.viewstock();
                PrintBookingDetails R=new  PrintBookingDetails();
                R.viewstock();
               if(  R.modelID.contains(M1_1.getText())){
               
               JOptionPane.showMessageDialog(null,"The Product with the ID exists");
               return;
               }
               if(p.modelID.contains(M1_1.getText())){
               
               JOptionPane.showMessageDialog(null,"The Product with the ID exists");
               return;
               }
                if(M1_1.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Enter the Product number");
                return;
                }
                if(name_2_2.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Enter the Product name");
                return;
                }
                 if(modelyear_1.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Enter the Product year");
                return;
                }
                  if( number_plate_1.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Enter the Product model plate");
                return;
                }
                   if(seats_1.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Enter the number of items");
                return;
                }
                    if(colors_1.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Enter the color of the Product");
                return;
                }
                     if(Price_1.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Enter the price of the Product");
                return;
                }
                     
                     
                     
                    
                      JOptionPane.showMessageDialog(null,"The data is updated");//shows that the message has been saved to the database
                      
                      M1_1.setText("");
                      name_2_2.setText("");
                      modelyear_1.setText("");
                      number_plate_1.setText("");
                      seats_1.setText("");
                      colors_1.setText("");
                      Price_1.setText("");
            }
        });
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        b.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {// the action even to save information to the database
               Car p= new Car();
               p.viewstock();
                PrintBookingDetails R=new  PrintBookingDetails();
                R.viewstock();
               if(  R.modelID.contains(M1_1.getText())){
               
               JOptionPane.showMessageDialog(null,"The Product with the ID exists");
               return;
               }
               if(p.modelID.contains(M1_1.getText())){
               
               JOptionPane.showMessageDialog(null,"The Product with the ID exists");
               return;
               }
                if(M1_1.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Enter the Product number");
                return;
                }
                if(name_2_2.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Enter the Product name");
                return;
                }
                 if(modelyear_1.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Enter the Product year");
                return;
                }
                  if( number_plate_1.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Enter the Product Product number");
                return;
                }
                   if(seats_1.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Enter the number of items");
                return;
                }
                    if(colors_1.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Enter the color of the Product");
                return;
                }
                     if(Price_1.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Enter the price of the Product");
                return;
                }
                     
                int n =Integer.valueOf(Price_1.getText());
                if (n<10){
                 JOptionPane.showMessageDialog(null,"The price must be 1O euros and above");
                return;
                }
                     
                     
                      try {
                          
                          
                          for(int i=0;i<p.modelID.size();i++){
                           p.all.add(p.modelID.get(i)+","+p.modelname.get(i)+","+p.modelyeare.get(i)+","+p.number_Plate.get(i)+","+p.seatss.get(i)+","+p.Color.get(i)+","+p.Price.get(i));
                          //adding the information to the variables
                          }
                          
                          p.all.add(M1_1.getText()+","+name_2_2.getText()+","+modelyear_1.getText()+","+number_plate_1.getText()+","+seats_1.getText()+","+colors_1.getText()+","+Price_1.getText());
   FileWriter myWriter = new FileWriter("vehicles_avaiblle.txt");//saving information to the text file for future use
 for(String str: p.all) {
myWriter.write(str + System.lineSeparator());
}
   myWriter.close();
  // System.out.println("Successfully wrote to the file.");
 } catch (Exception e) {
   System.out.println("An error occurred.");
   e.printStackTrace();
 }
                      JOptionPane.showMessageDialog(null,"Information saved");//shows that the message has been saved to the database
                      
                      M1_1.setText("");
                      name_2_2.setText("");
                      modelyear_1.setText("");
                      number_plate_1.setText("");
                      seats_1.setText("");
                      colors_1.setText("");
                      Price_1.setText("");
            }
        });
        VBox vBox = new VBox(tabPane);
        Scene scene = new Scene(vBox);

        stage.setScene(scene);
        stage.setTitle("Product system");
        stage.setMaxHeight(600);
        stage.setMaxWidth(1200);
        stage.show();
      stage.show(); 
   } 
   public static void main(String args[]){
      launch(args);  
   } 
    
  
  
}

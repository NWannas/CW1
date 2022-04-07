
package controllers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;


public class Car {
    public int model_id;     // variables for storing information of the system are declared as below 
     public String model_name;
     public String numberplate;
     public String model_year;
     public String seats;
     public String colour;
     public String price;
     
     
public   ArrayList<String>modelID = new ArrayList<>();// the arrays for storing information from the file are declared as shown in the filed below 
public   ArrayList<String>modelname= new ArrayList<>();
public   ArrayList<String>modelyeare= new ArrayList<>();
public   ArrayList<String>number_Plate = new ArrayList<>();
public   ArrayList<String>seatss= new ArrayList<>();
public   ArrayList<String>Color= new ArrayList<>();
public   ArrayList<String>Price= new ArrayList<>();
public   ArrayList<String>all = new ArrayList<>();
public   ArrayList<String>booked = new ArrayList<>();
    
  public  void viewstock(){
  
  try {
      BufferedReader br = new BufferedReader(new FileReader("vehicle.csv"));// reading information from the file 
           String line;
while ((line = br.readLine()) != null) {
   String[] values = line.split(",");// file data are separated by comma so the split used is the comma as shhow in the figure 
   
   	modelID.add(values[0]); // storing inforamaion from the file into the arrays files.
  modelname.add(values[1]); 
  modelyeare.add(values[2]);
    number_Plate.add(values[3]);
       seatss.add(values[4]);
       Color.add(values[5]);
        // Price.add(values[6]);
    

    

} 
           
          br.close();
           
       } catch (Exception e) {
      
       System.out.println(e.getMessage());
       }
  
  
}


}

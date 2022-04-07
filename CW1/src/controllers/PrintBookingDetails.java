
package controllers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;


public class PrintBookingDetails {
    public   ArrayList<String>customername = new ArrayList<>();
    public   ArrayList<String>customerID = new ArrayList<>();
    public   ArrayList<String>custoMERAddress = new ArrayList<>();
    public   ArrayList<String>date = new ArrayList<>();
    
public   ArrayList<String>modelID = new ArrayList<>();// the arrays for storing information from the file are declared as shown in the filed below 
public   ArrayList<String>modelname= new ArrayList<>();
public   ArrayList<String>modelyeare= new ArrayList<>();
public   ArrayList<String>number_Plate = new ArrayList<>();
public   ArrayList<String>seatss= new ArrayList<>();
public   ArrayList<String>Color= new ArrayList<>();
public   ArrayList<String>Price= new ArrayList<>();
public   ArrayList<String>all = new ArrayList<>();
public   ArrayList<String>booked = new ArrayList<>();
public String r_booked[][]; 


 public  void viewstock(){
  
  try {
      BufferedReader br = new BufferedReader(new FileReader("Bookedcars.txt"));// reading information from the file 
           String line;
while ((line = br.readLine()) != null) {
   String[] values = line.split(",");// file data are separated by comma so the split used is the comma as shhow in the figure 
   
   
   	modelID.add(values[0]); // storing inforamaion from the file into the arrays files.
        customername.add(values[1]);
        customerID.add(values[2]);
        custoMERAddress.add(values[3]);
        date.add(values[4]);
        
  modelname.add(values[5]); 
  modelyeare.add(values[6]);
    number_Plate.add(values[7]);
       seatss.add(values[8]);
       Color.add(values[9]);
         Price.add(values[10]);
    

    

} 
           
          br.close();
           
       } catch (Exception e) {
      
       System.out.println(e.getMessage());
       }
  r_booked=new String[modelID.size()][11];

                   for(int row=0;row<r_booked.length;row++){
                        
                        for(int col=0;col<r_booked[0].length;col++){
                         if(col==0) {
                            
                               r_booked[row][col]=modelID.get(row);
                            
                          }
                          if(col==1) {
                            
                               r_booked[row][col]=customername.get(row);
                          }
                            if(col==2) {
                            
                               r_booked[row][col]=customerID.get(row);
                            }
                            if(col==3) {
                            
                               r_booked[row][col]=custoMERAddress.get(row);
                          }
                            if(col==4) {
                            
                               r_booked[row][col]=date.get(row);
                          }
                            if(col==5) {
                            
                               r_booked[row][col]=modelname.get(row);
                          }
                            if(col==6) {
                            
                               r_booked[row][col]=modelyeare.get(row);
                          }
                            if(col==7) {
                            
                               r_booked[row][col]=number_Plate.get(row);
                                
                          }
                            if(col==8) {
                            
                               r_booked[row][col]=seatss.get(row);
                          }
                            if(col==9) {
                            
                               r_booked[row][col]=Color.get(row);
                          }
                            if(col==10) {
                            
                               r_booked[row][col]=Price.get(row);
                          }
                         //   System.out.print(arrayOfEarth[row][col]+"\t");                   
                        
                        }
                    }
  
//  for ( int row=0;row< r_booked.length;row++){
//                        
//                        for(int col=0;col<r_booked[0].length;col++){
//                          String jj=  String.format("%-20s",r_booked[row][col]);
//                         
//                        System.out.print(jj);                   
//                        }
//                         System.out.println();
//                    }
  
  }

 
    
}

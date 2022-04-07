
package controllers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;


public class MenuDisplay {

 
    public static void main(String[] args) {
        MenuDisplay  n =new MenuDisplay();
        n.displayCarList();
        
    }
    public void displayCarList(){
        Scanner sc = new Scanner(System.in); 
        Car p= new Car();
        
        CarBooking k= new  CarBooking();
        PrintBookingDetails R=new  PrintBookingDetails();
        
        R.viewstock();
        p.viewstock();
        String vehicles[][] =new String[p.modelID.size()][6]; 
        
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
        
        
         System.out.println("*****************Welcome to the system************************\n");
            System.out.println("*************The following are some of the details:*********\n\n");
            
            
             for ( int row=0;row<vehicles.length;row++){
                        
                        for(int col=0;col<vehicles[0].length;col++){
                           
                          String jj=  String.format("%-15s",vehicles[row][col]);
                         
                        System.out.print(jj);                   
                        }
                         System.out.println();
                    }
              System.out.println("***********************************************************************");
               System.out.println("Total "+(vehicles.length-1)+" the detial that are avaible are\n");

              System.out.println("\n");
             
             
                System.out.println("1.To move an item ");  
		System.out.println("2.To exit the system ");
		 
               System.out.println("Select from the above choices:");
		  String name = sc.nextLine(); 
                  if(name.equals("1")) {
                      
               System.out.println("Enter the the id you want to move");
               String carid=sc.nextLine();
               if(p.modelID.contains(carid)){
               
               }else{
               System.err.println("id does not exits");
               displayCarList();
               
               }
                   
               int year,month,day;
             System.err.println("Please enter the start date");
             System.err.println("Please enter the year for example'2020'");
             year=sc.nextInt();
             System.err.println("Please enter the month for example'6'");
              month=sc.nextInt();
             System.err.println("Please enter the day for example'21'");
              day=sc.nextInt();
             
               int eyear,emonth,eday;
             System.err.println("Please enter the end date");
             System.err.println("Please enter the year for example'2020'");
             eyear=sc.nextInt();
             System.err.println("Please enter the montn for example'6'");
              emonth=sc.nextInt();
             System.err.println("Please enter the day for example'21'");
              eday=sc.nextInt();
             
             
                      System.out.println("\n");
               System.out.println(" Your name");
               k.customer_name=sc.nextLine();
               System.out.println(" Your email");
               k.customerId=sc.nextLine();
               System.out.println(" Residential address");
               k.CustomerAddress=sc.nextLine();
        
               k.date=""+eyear+":"+emonth+":"+emonth+"";
               
                 System.out.println("Thanks for  you for moveing "+k.customer_name+"");
                 System.out.println("Email \t"+k.customerId+"");
                 System.out.println("Address\t "+k.CustomerAddress+"");
                 
                 System.out.println("Book confirmed ");
                 System.out.println("Your booking summary ");
                 System.out.println("******************************************* ");
                         System.out.println("Car selected \t"+p.modelname.get(2)+"");
                          System.out.println("Start date \t"+""+year+"-"+month+"-"+month+"");
                           System.out.println("End  date \t"+k.date);
                            System.out.println("Number of days booked \t"+"9");
                            System.out.println("car rate \t"+"$115.5");
                             System.out.println("_________________________________________________");
                             System.out.println("Total cost \t"+"9");
          for(int i=0;i<p.modelID.size();i++){
                if(i==0){
                      p.all.add("CarNO,Car Name,seats,Transmisson,car Type,Rate");
                continue;
                }
                 if(p.modelID.get(i).equals(carid)){
                     
                    p.booked.add(carid+","+k.customer_name+","+k.customerId+","+k.CustomerAddress+","+k.date+","+p.modelname.get(i)+","+p.modelyeare.get(i)+","+p.number_Plate.get(i)+","+p.seatss.get(i)+","+p.Color.get(i)+","+p.Color.get(i)); 
                     
                    try
{
    String filename= "Bookedcars.txt";   
    
    
    
     
        //Set true for append mode
    BufferedWriter writer = new BufferedWriter(new FileWriter("Bookedcars.txt", true));
            
 
    writer.append(System.lineSeparator()+p.booked.toString());
    writer.close();
}
catch(Exception ioe)
{
    System.err.println("IOException: " + ioe.getMessage());
}
                     continue;
                  
                 
                 }
               
                 p.all.add(p.modelID.get(i)+","+p.modelname.get(i)+","+p.modelyeare.get(i)+","+p.number_Plate.get(i)+","+p.seatss.get(i)+","+p.Color.get(i)+","+p.Color.get(i));
       
                  
                      }     
               
          
          
         try {
   FileWriter myWriter = new FileWriter("vehicle.csv");
 for(String str: p.all) {
myWriter.write(str + System.lineSeparator());
}
   myWriter.close();
  // System.out.println("Successfully wrote to the file.");
 } catch (Exception e) {
   System.out.println("An error occurred.");
   e.printStackTrace();
 }
         
            
                  displayCarList();
                      
                  }
                  else
	if(name.equals("5")) {
         
            
          
        displayCarList();
    } else
	if(name.equals("3")) {
        
        System.out.println(" Report on the booked cars are:\n\n");
                    for ( int row=0;row< R.r_booked.length;row++){
                        
                        for(int col=0;col<R.r_booked[0].length;col++){
                          String jj=  String.format("%-20s",R.r_booked[row][col]);
                         
                        System.out.print(jj);                   
                        }
                         System.out.println();
                    }
            
                  displayCarList();
        
        }else
	if(name.equals("4")){
        
            System.out.println("\n\n************The vehicles avaiable are and the depot**************** \n");
            
            for ( int row=0;row<vehicles.length;row++){
                        
                        for(int col=0;col<vehicles[0].length;col++){
                          String jj=  String.format("%-15s",vehicles[row][col]);
                         
                        System.out.print(jj);                   
                        }
                         System.out.println();
                    }
            
            
             System.out.println("\n\n************The vehicles avaiable are booked**************** \n");
            
                for ( int row=0;row< R.r_booked.length;row++){
                        
                        for(int col=0;col<R.r_booked[0].length;col++){
                            if(col==3||col==8||col==9||col==10||col==6){
                            continue;
                            }
                          String jj=  String.format("%-20s",R.r_booked[row][col]);
                         
                        System.out.print(jj);                   
                        }
                         System.out.println();
                    }
            
        displayCarList();
        }
		else
	if(name.equals("2")){
        System.exit(0);
        }		  
				  
				  
			  } 
       
    
}

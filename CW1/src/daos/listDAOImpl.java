package daos;

import app.ToDoApp;
import datastructures.ADTSingleLinkedList;
import model.*;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class listDAOImpl extends DAO{
    private ADTSingleLinkedList<Task> theTaskLL;

    public static final char DELIMITER = ',';
    public static final char EOLN='\n';
    public static final String QUOTE="\"";
    public static final String USERDIRECTORY = System.getProperty("user.dir");

    private String stripQuotes(String str) {
        return str.substring(1, str.length()-1);
    }

    public listDAOImpl(){
        // Add your code here
    }

    public listDAOImpl(ADTSingleLinkedList<Task> theTaskLL) {
        // Add your code here
    }

    public ADTSingleLinkedList<Task> getTheTaskLL() {
        return null; // Add your return type here
    }

    public void setTheTaskLL(ADTSingleLinkedList<Task> theTaskLL) {
        // Add your code here
    }

    @Override
    public void loadFromFile(String filename) {
        String transactionFile = USERDIRECTORY +"\\" + filename;

        try (BufferedReader br = new BufferedReader(new FileReader(transactionFile))) {
            // Add your variables here

            String[] temp;
            String line = br.readLine();
            while(line!=null){
                // split each line and store the values in your variables

                // Create required instances of your modelled data

                // Insert into the list
                line = br.readLine();

            }
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(ToDoApp.class.getName()).log(Level.INFO, null, ex);
        }
    }

    @Override
    public void writeToFile(ADTSingleLinkedList<Task> listItems, String filename) {
        // Add your code here
    }

    @Override
    public void add(Task aTask) {
        // Add your code here
    }

    @Override
    public Task getTask() {
        // Add your code here
        return null;  // Add your return value here
    }

    @Override
    public Task removeTask(int pos) {
        // Add your code here
        return  null; // Add your return value here
    }

    @Override
    public TeamMember getTeamMember() {
        // Add your code here
        return null;  // Add your return value here
    }

    @Override
    public ADTDate parseDateInput(String aDate) {
        // Add your code here
        return null;  // Add your return value here
    }
}

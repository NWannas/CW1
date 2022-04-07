package controllers;

import helpers.InputHelper;

public class controller {
    //Add your variables here
    InputHelper inputHelper;

    public controller() {
        // Add your code here
        inputHelper = new InputHelper();
    }

    public void run(){
        this.setup();
        boolean finished = false;

        int iChoice = 0;

        do {
            this.theMenu();
            iChoice = inputHelper.readInt("Enter choice", 8,1);
            switch (iChoice) {
                // Add more cases
                case 1:
                    System.out.println();
                    break;

                default: // invalid option
                    System.out.println("Oops! Something has went wrong!");
                    break;
            }
        }while(!finished);
    }

    private void setup(){
        // Add your code here
    }

    private void theMenu() {
        // Print menu to console
        // Add your code here
        System.out.println("1.list view");
        System.out.println("2.Move list");
    }

    // Add your code here
    // Add more private methods for each of your cases
}

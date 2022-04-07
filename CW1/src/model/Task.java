package model;

public class Task {

    private ListType theList;
    // Add your variables here

    public Task() {
        // Add your code here
    }

    public ListType getTheListType() {
        return theList;
    }

    public void setTheListType(ListType theListType) {
        this.theList = theListType;
    }

    public ADTDate getTheDueDate() {
        return null;  // Add your return type here
    }

    public void setTheDueDate(ADTDate aDueDate) {
        // Add your code here
    }

    public String getTheTask() {
        return "";  // Add your return type here
    }

    public void setTheTask(String aTask) {
        // Add your code here
    }

    public TeamMember getAllocatedTeamMember() {
        return null;  // Add your return type here
    }

    public void setAllocatedTeamMember(TeamMember allocatedToTM) {
        // Add your code here
    }

    public String getTaskComments() {
        return null;  // Add your return type here
    }

    public void setTaskComments(String theTaskComments) {
        // Add your code here
    }

    public String getTheTags() {
        return null;  // Add your return type here
    }

    public void setTheTags(String taskTags) {
        // Add your code here
    }


    public String CSVFormat(){
        // Add your code here
        return "";  // Add your return type here
    }

    @Override
    public String toString() {
        // Add your code here
        return "Task{" +
                '}';
    }
}

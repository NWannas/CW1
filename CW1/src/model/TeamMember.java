package model;

public class TeamMember {
    // Add your variables here
    private Role tmRole;

    public TeamMember() {
        // Add your code here
        this.tmRole = Role.ANALYST;
    }

    public TeamMember(String theFirstname, String theLastname, Role theRole) {
        // Add your code here
        this.tmRole = theRole;
    }

    public String getFirstname() {
        return "";  // Add your return type here
    }

    public void setFirstname(String firstname) {
        // Add your code here
    }

    public String getLastname() {
        return "";  // Add your return type here
    }

    public void setLastname(String lastname) {
        // Add your code here
    }

    public Role getTmRole() {
        return null;  // Add your return type here
    }

    public void setTmRole(Role tmRole) {
        // Add your code here
    }

    public String getRoleAsString(){
        return "";  // Add your return type here
    }

    public String getAllocatedTo(){
        return "";  // Add your return type here
    }

    public String CSVFormat(){
        // Add your code here
        return "";  // Add your return type here
    }

    @Override
    public String toString() {
        // Add your code here
        return "TeamMember{" +
                '}';
    }
}

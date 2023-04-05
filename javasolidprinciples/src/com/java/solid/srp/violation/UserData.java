package com.java.solid.srp.violation;

public class UserData {
    private String userName="Saicharan";
    private String password="password";
    //validate user
    public boolean isUserValidated(String userName,String password){
        System.out.println("Please wait..validating user");
        if(this.userName.equals(userName) && (this.password.equals(password))) {
            return true;
        }
        return false;
    }

    //storing user-data in database
    public void store(String userName,String password){
        System.out.println("storing username -"+userName+ "- and password- "+password+" -in database");
    }

    public void displayUser(String userName,String password){
        System.out.println("displaying user information on website");
    }
}

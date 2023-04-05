package com.java.solid.srp.corrected;

public class ValidateUser {
    private String userName="Saicharan";
    private String password="password";
    //validating user data
    public boolean isUserValidated(String userName,String password){
        System.out.println("Please wait..validating user");
        if(this.userName.equals(userName) && (this.password.equals(password))) {
            return true;
        }
        return false;
    }
}

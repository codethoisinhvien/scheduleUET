/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Phongthien
 */
public class LoginInformation {
    private String useName;
    private String passWord;
    public String RequestVerificationToken;
    public LoginInformation(String useName, String passWord,String RequestVerificationToken){
        this.useName=useName;
        this.passWord=passWord;
        this.RequestVerificationToken=RequestVerificationToken;
    }
    public LoginInformation(){
        
    }
   public void setRequestVerificationToken(String a){
       a = a.substring(a.indexOf("value="));
            a=a.substring(0, a.indexOf("/> "));
            a=a.substring(a.indexOf("\"")+1,a.length()-2);
   }
   // private 
}

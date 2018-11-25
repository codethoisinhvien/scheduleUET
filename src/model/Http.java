/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Phongthien
 */
public class Http {
    public  URL myurl;
    public  HttpURLConnection con;
    public  String cookie;
    public String getFormLoginUET() throws MalformedURLException, IOException{
        String result ="";
       // String url = "http://dangkyhoc.vnu.edu.vn/dang-nhap";
       String url = "http://dangkyhoc.vnu.edu.vn";

        try {

             myurl = new URL(url);
            con = (HttpURLConnection) myurl.openConnection();

            con.setRequestMethod("GET");

            StringBuilder content;
            	Map<String, List<String>> map = con.getHeaderFields();
                System.out.println(map.get("Set-Cookie").size());
                this.cookie =map.get("Set-Cookie").get(0);
                            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()))) {

                String line;
                content = new StringBuilder();

                while ((line = in.readLine()) != null) {
                    if(line.contains("RequestVerificationToken")){
                    content.append(line);
                   break;
                    }
                }
            }
           String a  = content.toString();
            a = a.substring(a.indexOf("value="));
            a=a.substring(0, a.indexOf("/> "));
            a=a.substring(a.indexOf("\"")+1,a.length()-2);
           result=a;
        } finally {
            
            con.disconnect();
        }
    
        return  result;
    }
    public String postLogin() throws MalformedURLException, IOException{
       
        String url = "http://dangkyhoc.vnu.edu.vn/dang-nhap";
         String formData="__RequestVerificationToken="+this.getFormLoginUET()+"&LoginName=17020705&Password=thao2104";
         
         byte [] byteCode = formData.getBytes();
        try {

             myurl = new URL(url);
            con = (HttpURLConnection) myurl.openConnection();
             con.setDoOutput(true);
            con.setRequestMethod("POST");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            con.setRequestProperty("Cookie",this.cookie);
try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
                wr.write(byteCode);
            }
            
            StringBuilder content;
            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()))) {

                String line;
                content = new StringBuilder();

                while ((line = in.readLine()) != null) {
                    
                    content.append(line);
                     content.append(System.lineSeparator());
                  
                    
                }
                System.out.println(content.toString());
            }
            
                } finally {
            
            con.disconnect();
        }
            
    
        return""; 
    }
}

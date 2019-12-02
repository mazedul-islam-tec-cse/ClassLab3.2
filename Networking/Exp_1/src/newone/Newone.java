/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newone;

import java.net.*; 
import java.*; 
  
class Newone { 
    public static void main(String args[]) 
        throws UnknownHostException 
    { 
        // The URL for which IP address needs to be fetched 
        String s = "https://www.google.com/"; 
  
        try { 
            // Fetch IP address by getByName() 
            InetAddress ip = InetAddress.getByName(new URL(s) 
                                                       .getHost()); 
  
            // Print the IP address 
            System.out.println("Public IP Address of: " + ip); 
        } 
        catch (MalformedURLException e) { 
            // It means the URL is invalid 
            System.out.println("Invalid URL"); 
        } 
    } 
} 

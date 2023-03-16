/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.yunusemrejr.sqlquerybuilder;
import java.io.IOException;

/**
 *
 * @author yunus
 */
public class Main {
    
 
   
    
  
    
    public static void main(String[] args) throws IOException {
        
        String asciiart1 = "          ,-._\n" +
"           _.-'  '--.\n" +
"         .'      _  -`\\_\n" +
"        / .----.`_.'----'\n" +
"        ;/     `\n" +
"       /_;";
        
  
         
        System.out.println(asciiart1+"\nSQL Query Builder v1.0.0\n\n *******************\n\n programmed by Yunus Emre Vurgun in 2023\n\nyunusemrevurgun.com\n\n**********\n\n");
        System.out.println("type '-help' to view the instructions\n or start giving commands right away.\n ");
        
      
       
        Listener.listener();
        
        
    }
}

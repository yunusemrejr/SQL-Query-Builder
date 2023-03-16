/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yunusemrejr.sqlquerybuilder;

import static com.yunusemrejr.sqlquerybuilder.Listener.listener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author yunus
 */
public class Create {
        
    public static void create() throws IOException{
        
        System.out.println("What would you like to create? \n 1==TABLE \n 2==DATABASE \n 3==INDEX \n 4==UNIQUE INDEX \n 5==VIEW \n 6==CREATE VIEW \n"
                + "7==REPLACE VIEW\n(enter the number only)\n");
        
             BufferedReader reader = new BufferedReader(
        new InputStreamReader(System.in));
        
        String line = reader.readLine();
        
        if("1".equals(line)){
       
            CreateTable.createtable();
           
        }
        
        
        
        
        
        
        
         if(null == line){
             System.out.println("\nyou entered an unknown command. try again:\n");
             listener();
         }
         
         else switch (line) {
            case "2" -> {
            }
            case "3" -> {
            }
            case "4" -> {
            }
            case "5" -> {
            }
            case "6" -> {
            }
            case "7" -> {
            }
            default -> {
                System.out.println("\nyou entered an unknown command. try again:\n");
                listener();
            }
        }
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yunusemrejr.sqlquerybuilder;

import static com.yunusemrejr.sqlquerybuilder.Create.create;
import static com.yunusemrejr.sqlquerybuilder.ReplaceChar.replaceCharacters;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author yunus
 */
public class CreateTable {
    
     static List<String> arrayOfColumnNames=new ArrayList<String>();
     static   List<String> listOfForbiddenTableChars=new ArrayList<String>();
       static   List<String> columnsWithFeatures=new ArrayList<String>();
   static String newAbility;    
                                                           
     
    public static void tableNameIsSafe(String line2) throws IOException{
        
         BufferedReader reader = new BufferedReader(
        new InputStreamReader(System.in));
         
         
                System.out.println("\n How many columns will "+line2+" have? (1-20)");
            
                    String line3 = reader.readLine();
                    
                    String[] arrayOfNumbers={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20"};
                    String isItEqual="no";
                for (String i : arrayOfNumbers) {
                    if(line3.equals(i)){
                        isItEqual="yes";
                    }  
                }
                
                if(isItEqual=="yes"){
                    System.out.println("ok, so you will have "+line3+" columns in your table and your table name will be "+line2+".\nNow, for the amount"
                            + "of columns you entered, write their names one by one and press enter each time:\n");
                    
                             
                            int wantedNumberOfColumns=parseInt(line3);
                           
                            
                               
                              listOfForbiddenTableChars.add("-");
                              listOfForbiddenTableChars.add("@");
                              listOfForbiddenTableChars.add("'");
                              listOfForbiddenTableChars.add("\"");
                              listOfForbiddenTableChars.add("\\");
                              listOfForbiddenTableChars.add("/");
                              listOfForbiddenTableChars.add("*");
                              listOfForbiddenTableChars.add(")");
                              listOfForbiddenTableChars.add("(");
                              listOfForbiddenTableChars.add("]");
                              listOfForbiddenTableChars.add("[");
                              listOfForbiddenTableChars.add("{");
                              listOfForbiddenTableChars.add("}");
                              listOfForbiddenTableChars.add("=");
                              listOfForbiddenTableChars.add("!");
                              listOfForbiddenTableChars.add("?");
                              listOfForbiddenTableChars.add("^");
                              listOfForbiddenTableChars.add("#");
                              listOfForbiddenTableChars.add("&");
                              listOfForbiddenTableChars.add("+");
                              listOfForbiddenTableChars.add("%");
                              listOfForbiddenTableChars.add("$");
                              listOfForbiddenTableChars.add(".");
                              listOfForbiddenTableChars.add(",");
                              listOfForbiddenTableChars.add(";");
                              listOfForbiddenTableChars.add(":");
                              listOfForbiddenTableChars.add("~");
                              listOfForbiddenTableChars.add("´");
                              listOfForbiddenTableChars.add("|");
                              listOfForbiddenTableChars.add("<");
                              listOfForbiddenTableChars.add(">");
                              listOfForbiddenTableChars.add("é");
                              listOfForbiddenTableChars.add("€");
                              
                              
                            for(int i=0; i < wantedNumberOfColumns; i++){
                                
                                 String readerSuper = reader.readLine();
                                 
                                 for(int j=0;j<listOfForbiddenTableChars.size();j++){
                                       if(!readerSuper.contains(listOfForbiddenTableChars.get(j))){
                                     
                                           if(!arrayOfColumnNames.contains(readerSuper)){
                                               arrayOfColumnNames.add(readerSuper);
                                           }
                                 }else{
                                           arrayOfColumnNames.clear();
                                           listOfForbiddenTableChars.clear();
                                      System.out.println("illegal input for table column name. start over."); create();
                                 } 
                                 }
                              
                                 
                                
                                
                            }
                           
                            System.out.println("\n your columns are: "+arrayOfColumnNames+"\nEnter their types and lengths the same way as before (format-->'TYPE length')(example-->'VARCHAR 100'): \n");
                            
                             List<String> arrayOfColumnNamesTypesLen= new  ArrayList<String>();
                            
                            for(int i=0; i < wantedNumberOfColumns; i++){
                                
                                 String readSuper2 = reader.readLine();
                                 
                                  boolean checkillegals=false;
                                  
                        for (String ForbiddenTableChar : listOfForbiddenTableChars) {
                            if(readSuper2.contains(ForbiddenTableChar)){
                                checkillegals=true;
                            } 
                        }
                                            if(checkillegals==true){
                                         
                                                arrayOfColumnNames.clear();
                                           listOfForbiddenTableChars.clear();
                                      System.out.println("illegal input for column type/length. start over."); create();
                                            }else{
                                                arrayOfColumnNamesTypesLen.add(readSuper2);
                                            }
                                     
                                    
                                   
                                  } 
                                       
                                      
                                  
                                      
                            
                            for(int i=0; i<arrayOfColumnNamesTypesLen.size();i++){
                                
                                 String each = arrayOfColumnNamesTypesLen.get(i);
                                 char ch1='(';
                                 int index1=each.indexOf(" ");
                                 var result=replaceCharacters(each,ch1,index1);
                                  result = result + ")";
                               arrayOfColumnNamesTypesLen.set(i, result);
                                 
                                
                            }
                            
                            System.out.println("\nHere is your SQL Query:\n");
                            
                           String SQLQuery="CREATE TABLE "+line2+" (\n ";
                           
                           List<String> arrayOfTableCreationColumnQueries=new ArrayList<String>();

                           var lastItem = arrayOfColumnNamesTypesLen.get(arrayOfColumnNamesTypesLen.size()-1);
                           for(int i=0;i<wantedNumberOfColumns;i++){
                               
                              if(!lastItem.equals(arrayOfColumnNamesTypesLen.get(i))){
                                  arrayOfTableCreationColumnQueries.add(arrayOfColumnNames.get(i)+" "+arrayOfColumnNamesTypesLen.get(i)+",");
                              }else{
                                  arrayOfTableCreationColumnQueries.add(arrayOfColumnNames.get(i)+" "+arrayOfColumnNamesTypesLen.get(i));
                              }
                               
                           }
                           
                           
                          
                           
                           for(int i=0;i<wantedNumberOfColumns;i++){
                               SQLQuery+=arrayOfTableCreationColumnQueries.get(i)+"\n";
                           }
                           
                           
                          
                           
                           
                           System.out.println(SQLQuery+"\n);");
                          System.out.println("Do you want to add NOT NULL / AUTO-INCREMENT / PRIMARY KEY / FOREIGN KEY to your table? (y/n)\n");

                            String readerForPrimaryAndNullAndAutoInc = reader.readLine();
                            
                           if("y".equals(readerForPrimaryAndNullAndAutoInc)||"Y".equals(readerForPrimaryAndNullAndAutoInc)){
                               System.out.println("\n type 1 to set NOT NULLs, 2 for AUTO-INC, 3 for PRIMARY KEY and 4 for FOREIGN KEY\n");
                                                           String readerForPrimaryAndNullAndAutoInc2 = reader.readLine();

                                                           
                                                           
                                    
                               switch(readerForPrimaryAndNullAndAutoInc2){
                                   
                                   
                                   case "1" -> {
                                       columnsWithFeatures.clear();
                                       
                                       System.out.println("You have "+wantedNumberOfColumns+" columns, enter the columns you want to add NOT NULL to in this format:"
                                           + "column1 column3 column7");
                                       
                                       
                                   String notnullcolslisten = reader.readLine();
                                   
                                   
                                   if(notnullcolslisten.contains(" ")){
                                       String[] temp_array_Str = notnullcolslisten.split(" ");
                                       
                                         
                                       
                                         columnsWithFeatures  = Arrays.asList(temp_array_Str);

 
                                   }else{
                                        columnsWithFeatures.add(notnullcolslisten);
                                         
                                   }
                                    
                                   newAbility = "NOT NULL";
                                   
                                   
                            }
                                   
                                   
                                   
                                   case "2" -> { columnsWithFeatures.clear();
                                        System.out.println("You have "+wantedNumberOfColumns+" columns, enter the columns you want to add AUTO-INCREMENT to in this format:"
                                           + "column1 column3 column7");
                                  
                                   String notnullcolslisten = reader.readLine();
                                   
                                   
                                   if(notnullcolslisten.contains(" ")){
                                       String[] temp_array_Str = notnullcolslisten.split(" ");
                                       
                                         
                                       
                                         columnsWithFeatures  = Arrays.asList(temp_array_Str);

 
                                   }else{
                                        columnsWithFeatures.add(notnullcolslisten);
                                         
                                   }
                                    
                                   
                                    newAbility = "AUTO-INCREMENT";
                                       
                            }
                                   
                                   
                                   
                                   case "3" -> { columnsWithFeatures.clear();
                                       
                                         System.out.println("You have "+wantedNumberOfColumns+" columns, enter the column you want to add PRIMARY KEY to:"
                                           );
                                  
                                   String notnullcolslisten = reader.readLine();
                                   
                               
                                        columnsWithFeatures.add(notnullcolslisten);
                                         
                                    
                                    
                                   
                                   newAbility = "PRIMARY KEY";
                                   
                               
                            }
                                   case "4" -> { columnsWithFeatures.clear();
                                       
                                       
                                         System.out.println("You have "+wantedNumberOfColumns+" columns, enter the columns you want to add FOREIGN KEY to in this format:"
                                           + "column1 column3 column7");
                                         
                                  
                                   String notnullcolslisten = reader.readLine();
                                   
                                   
                                   if(notnullcolslisten.contains(" ")){
                                       String[] temp_array_Str = notnullcolslisten.split(" ");
                                       
                                         
                                       
                                         columnsWithFeatures  = Arrays.asList(temp_array_Str);

 
                                   }else{
                                        columnsWithFeatures.add(notnullcolslisten);
                                         
                                   }
                                    
                                   
                                    newAbility = "FOREIGN KEY";
                                   
                            }
                                   default ->{ columnsWithFeatures.clear();
                                        System.out.println("\nunknown command, try again.\n"); create();
                                   }
                               }
                         System.out.println("\nHere is your updated SQL Query:\n");
                            
                         String element;
                         
                      
                         
                            for(int x=0; x < columnsWithFeatures.size(); x++){
                                
                           
                                
                                 element = columnsWithFeatures.get(x);
                                 
                                 
                                  
                                 
                                  if(SQLQuery.contains(element)){
                                      
                                                            //it contains works, checked.
                    
                                SQLQuery = SQLQuery.replaceAll(element, element +" "+ newAbility);
                                      
                                     
                              
                               }
                                  
                                  
                                  else{
                                       System.out.println("\n an error occured.\n");
                                  }
                            }
                           
                             
                                       
                               System.out.println(SQLQuery);
                                System.exit(0);
                               
                           }else{
                               System.out.println("exiting");
                               System.exit(0);
                           }
                           
                           arrayOfColumnNames.clear();
                           listOfForbiddenTableChars.clear();
                            columnsWithFeatures.clear();
                     System.exit(0);
                }else{
                    
                    arrayOfColumnNames.clear();
                                           listOfForbiddenTableChars.clear();
                                  System.out.println("illegal input for table column amount. start over."); create();
 System.exit(0);
                }
                    
                    System.exit(0);
        
    }
    
    
    
    
    
    
    
    public static boolean checkIfTableNameIsSafe(String TabName) throws IOException{
        
          List<String> arrayOfInvalidTableChars = new ArrayList<String>();
          arrayOfInvalidTableChars.add("-");
                    arrayOfInvalidTableChars.add(" ");

                    boolean checker = false;

                    
         for(String arrayOfInvalidTableChar : arrayOfInvalidTableChars){
             if(TabName.contains(arrayOfInvalidTableChar)){
                 checker= true;
                 
             }
         }
          
        
        if(checker==true /*cehcker found an invalid char */){
            return true;
        }
        
       
        
        else{
                return false;
                }
        
    }
    
    
    
    
      public static void createtable() throws IOException {
             System.out.println("\n what will your table name be?\n");
             
             BufferedReader reader = new BufferedReader(
        new InputStreamReader(System.in));
         
        String line2 = reader.readLine();
        
        
         
        
          if(checkIfTableNameIsSafe(line2)==false){
            tableNameIsSafe(line2);
        }
          
          
          else{
              arrayOfColumnNames.clear();
                           listOfForbiddenTableChars.clear();
              System.out.println("illegal input for table name. start over."); create();
          }
        
      }
}

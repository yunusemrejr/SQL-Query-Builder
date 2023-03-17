from listener import *

def queryengine(x):
    
    x= str(x)
    
    print("You entered: "+ x)
    
    #check amount of "|" chars (must be 7)
    

    count_for_pipe = x.count("|")
    
    if count_for_pipe !=8: 
        print("wrong format")
        return
    
    else:
        
  #example 1: My_Table|5|col1 col2 col3 col4 col5|INT VARCHAR(10) SUPER INT INT|0|1|0|0|1 1 1
   #example 2: Customers | 3 | ID name email | INT VARCHAR(255) VARCHAR(255) 
   # | 1 | 1 | 2 registered name | 1\n"
    
     arr = x.split("|")
     arr[0]=arr[0].replace("Type here: ","")
     print(arr)
     print(
         "Your table name is: " +str( arr[0]) + "\n" +
         
         "Your column count is: " + str(arr[1].split())  + "\n" +
         
         "Your columns are: " + str(arr[2].split())  + "\n"  +
         
         "Your column types are: "+str(arr[3].split())  + "\n"  +
          
         "Columns with NOT NULL (column index): " + str(arr[4].split())+"\n"+
         
         "Column with Primary Key (column index): " + str(arr[5])+"\n"+
         
         "Columns with Foreign Key (column index): " + str(arr[6].split(","))+"\n"+
         
         "Columns with Auto Increment (column index): " + str(arr[7].split())+"\n"+
         
         "Columns with Identity (column index): " + str(arr[8].split(","))+"\n" )

         
        
     
     
         
      
     
    
    
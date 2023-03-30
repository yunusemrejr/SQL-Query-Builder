from listener import *
import re

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


     tab_name_arr = arr[0] #tab1
     col_count_arr =arr[1].split() #['3']
     col_names_arr =arr[2].split() #['col1', 'col2', 'col3']
     col_type_arr =arr[3].split() #['int', 'int', 'varchar(100)']
     col_NN_arr =arr[4].split() #['1', '2', '3']
     col_PK_arr =arr[5] #1
     col_FK_arr =arr[6].split(",") #['2 tab2 col2', '3 tab3 col3']
     col_AI_arr =arr[7].split() #['1']
     col_ID_arr =arr[8].split(",") #['2 1 1']
     
     

     #check input logic
     
     if str(tab_name_arr).count(" ")>=1:
        print("wrong format")
        return
      
     if len(str(tab_name_arr)) > 64 or len(str(tab_name_arr)) < 1 :
        print("wrong format")
        return
     
     
      
     if int(col_count_arr[0]) != int(len(col_names_arr)):
        print("wrong format")
        return
      
      
     if int(col_count_arr[0]) != len(col_type_arr):
        print("wrong format")
        return
      
     if int(col_count_arr[0]) < len(col_NN_arr):
        print("wrong format")
        return
      
     if len(col_PK_arr) !=1:
        print("wrong format")
        return
      
     if int(col_count_arr[0]) < len(col_FK_arr):
        print("wrong format")
        return

     if int(col_count_arr[0]) < len(col_AI_arr):
        print("wrong format")
        return
 
     if int(col_count_arr[0]) < len(col_ID_arr):
        print("wrong format")
        return
      
      
     print(
         "Your table name is: " +str( arr[0]) + "\n" +
         
         "Your column count is: " + str(arr[1].split())  + "\n" +
         
         "Your columns are: " + str(arr[2].split())  + "\n"  +
         
         "Your column types are: "+str(arr[3].split())  + "\n"  +
          
         "Columns with NOT NULL (column index): " + str(arr[4].split())+"\n"+
         
         "Column with Primary Key (column index): " + str(arr[5])+"\n"+
         
         "Columns with Foreign Key (column index): " + str(arr[6].split(","))+"\n"+
         
         "Columns with Auto Increment (column index): " + str(arr[7].split())+"\n"+
         
         "Columns with Identity (column index followed by parameters): " + str(arr[8].split(","))+"\n\n\n" )
     
     print("Your SQL Query --->\n\n")
     
          
     
     
     QUERY = "CREATE TABLE " + str(tab_name_arr) + "(\n"
     
     print(col_FK_arr)
     FK_parameters=[]
     FK_index_parameters=[]
     FK_table_parameters=[]
     FK_col_parameters=[]
     
      
     for n in col_FK_arr:  #each FK such as "2 tab2 coloftab2"  is one FK
      x=col_FK_arr.index(n)  #index of eack FK
      FK_parameters+=col_FK_arr[x].split(" ") #the FK with the above index will be split into pars
      
     start_point=1
     for m in FK_parameters:
                  
                   if start_point==1:
                     index_here=FK_parameters.index(m)#index of each FK par in format as ['1','tab2','colof2','2','tabx','colof...]
            #if len(str(re.findall('[0-9]+',m)[0]))==len(m):
                   if (index_here >=len(FK_parameters))==0:   
               
                     FK_index_parameters.append(str(FK_parameters[index_here]))
                     
                     index_here=index_here+1
                    
                     FK_table_parameters.append(str(FK_parameters[index_here]))
                      
                     index_here=index_here+1
                    
                     FK_col_parameters.append(str(FK_parameters[index_here]))
                      
                     index_here=index_here+1
                   
                     start_point=0
      
                   
     print("indexes-->"+str(FK_index_parameters)+"\n")
     print("tables-->"+str(FK_table_parameters)+"\n")
     print("cols-->"+str(FK_col_parameters)+"\n")
       
      
     i=0;
     
     for x in col_names_arr:
           
         QUERY += x + " "+ col_type_arr[i]
         
         if int(col_PK_arr[0])==i:
            
                QUERY +=" PRIMARY KEY"   
         
        
         for y in col_NN_arr:
              if int(y)==col_names_arr[i]:
               QUERY +=" NOT NULL" 
               
               
         for z in col_AI_arr:
              if int(z)==col_names_arr[i]:
               QUERY +=" AUTO_INCREMENT"
               
        # for w in col_ID_arr:
        #      if int(w)==col_names_arr[i]:
         #      QUERY +=" AUTO_INCREMENT"
        
         QUERY+=",\n"
         i=i+1        
     
    print(QUERY)
         
        
     
     
         
      
     
    
    
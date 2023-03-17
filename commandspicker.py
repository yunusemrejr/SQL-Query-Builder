

def commandspicker(x):
    if  x=="-ex":
        print("#example 1: My_Table|5|col1 col2 col3 col4 col5|INT VARCHAR(10) SUPER INT INT|0|1|0|0|1 1 1\n")
        print("#example 2: Customers | 3 | ID name email | INT VARCHAR(255) VARCHAR(255) | 1 | 1 | 2 registered name, 3 register name | 1 | 1 1 1, 2 1 1\n")
        
        return "-ex"
       
        
    elif x=="-format":
        print("input format: table name | number of columns | names of columns in order| types of columns in order |"+
"NOT NULL index(s) | PRIMARY KEY index | FOREIGN KEY FOR index(s) FOREIGN KEY OF table_name column_name | AUTO INCREMENT index(s)|"+
"IDENTITY index parameter1 parameter2\n")
        
        return "-format"
    
    
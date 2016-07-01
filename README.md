# CsvToMySQL
CSV To MySQL data transfer tool


Put your csv file to root directory of the project.

Then go to Main.java file and change the value of this variable: private static String fileName = "YOURFILENAME.csv";

After you should create Database object. You have two options for your database setup: 

1. Go to Database.java and change the attributes of class according to your MySQL database informations. Then create your object like this : Database db = new Database();	

2. You can directly create Database object with its informations : 

Database db = new Database("portNumber", "databaseName", "databaseUsername", "databasePassword");


After setups and name definition completed, just run the Main.java and it automatically adds data to your MySQL database

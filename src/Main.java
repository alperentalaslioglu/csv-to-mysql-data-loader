import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;


public class Main {
	private static String fileName = "alg_1.csv";

	public static void main(String[] args) throws SQLException, ClassNotFoundException, FileNotFoundException {		
		//table name
		String tableName = fileName.substring(0, fileName.length()-4);
		
		//Creating database
		Database db = new Database();		
		
		//CSV Reader
		Scanner inputReader = new Scanner(new File(fileName));
		
		//Getting column names from first line
		String columns = (inputReader.nextLine()).replace(";", ",");

		//Check the table if does not exist, create a table
		db.createTable(tableName, columns);
		
		//Inserting data to database		
		while(inputReader.hasNextLine()){
			db.addData(tableName, columns, generateRow(inputReader.nextLine()));		
		}
	}

	public static String generateRow(String row){
		String rowForSQL = "";
		String[] cols = row.split(";");
		for(int i = 0; i < cols.length; i++){
			rowForSQL += "'"+cols[i]+"'" + ( i != (cols.length-1) ? "," : "");	
		}		
		return rowForSQL;
	}
	
}


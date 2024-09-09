package database;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner; 

public class PaymentDatabase {
		
	File fileDoc;
	
	Scanner scan = null; 
	
	public String[] upgrade; 
	public int count = 0; 
	
	public static PaymentDatabase instance; 
	
	//hacer infinta la matriz
	public  String[][] payment;
	
	BufferedReader br = null; 
	
	
	/* my path: /Users/luisbenvenuto/Desktop/internal info paulina/INTERNAL_eclipsee/Internal_Info/src/database/db.txt */
	
	private PaymentDatabase(String path) throws IOException{
		String line;
		int i = 0;
		String[] leer = new String[10000000];  
         try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) { 	
        	 payment = new String[leer.length][3];
        	 while ((line = bufferedReader.readLine()) != null) {
                    leer[i] = line;
                    i++;
                }
        	 System.out.println(leer[0]);
            } catch (IOException e) {
                e.printStackTrace(); // Manejo básico de la excepción; puedes personalizarlo según tus necesidades.
            }
         
        i = 0; 
        int k = 0; 
        while(i<leer.length-1) {
        	for(int j = 0; j<3; j++) {
        		payment[k][j]= leer[i];
        		if(i>leer.length-1) break;
        		i++;
        	}
        	k++;
        }
        
        //x -> numero de registro y y -> dato; 0:fecha 1:cantidad 2:horas

	}
	public static PaymentDatabase getInstance(String newPath) {
		
		
		if (instance == null) {
			try {
				instance = new PaymentDatabase(newPath);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return instance;
	}
	
	
}

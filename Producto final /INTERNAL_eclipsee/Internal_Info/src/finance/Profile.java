package finance;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import database.PaymentDatabase;

public class Profile {

	public String name;
	public double income;
	public double outcome;
	public double AHW;
	public double BasicSavings;
	public String path; 
	
	public double ADW;
	public PaymentDatabase db;
	
	public double TotalIncome; 
	public double TotalOutcome;
	public double AmountMoney; 
	
	public Profile(String name, double income, double outcome, double AHW, double BasicSavings, String path) {
	    this.name = name;
	    this.income = income;
	    this.outcome = outcome;
	    
	    this.BasicSavings = BasicSavings;
	    this.path = path;
		
	    db = PaymentDatabase.getInstance(path);
	    
	    
	    
	    //limite de horas trabajadas por quincena
	    try {
	    	if(AHW > 80)
	    		this.AHW = AHW;
	    }catch(Exception err) {
	    	System.out.println(err.getMessage());
	    }
	    if(AHW > 80)
	    	this.AHW = 0;
	    if(name.charAt(2)!='/'&& name.charAt(5)!='/') {
	    	this.name = null; 
	    }
	    ADW = AHW/5;
	}

	
	public void FinancialStatus() {
		TotalIncome = 0;
		int len = 0; 
		while(db.payment[len][0]!=null) {
			len++;
		}
		TotalOutcome = outcome * len;
		
		int i = 0;
		while(i<db.payment.length && db.payment[i][1] != null) { 
		
			TotalIncome += Double.parseDouble(db.payment[i][1]);
			i++;
		}
		
		AmountMoney = TotalIncome-TotalOutcome; 
		
	}
	public void AddPayment(String date, String amount, String HW) throws IOException {
		int index = 0;
		for(int i = 0; i<db.payment.length-1; i++) {
			if(db.payment[i][0] == null) {
				index = i; 
				break;
			}
		}
		db.payment[index][0] = date; 
		db.payment[index][1] = amount; 
		db.payment[index][2] = HW;
		
		writePaymentToFile(date,amount,HW);
		
			
	}
	private void writePaymentToFile(String date, String amount, String HW) throws IOException {
        // Specify the file path where you want to store the payments
        String filePath = path;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
        	
            writer.write(date);
            writer.newLine();
            writer.write(amount);
            writer.newLine();
            writer.write(HW);
            writer.newLine();
        }
	}
	public String getDate() {
		int i= 0;
		String res = "";
		while (i < db.payment.length-1 && db.payment[i][0] != null) {
			res += db.payment[i][0] + " | ";
			i++;
		}
		return res;
	}
	public String getMoney() {
		int i= 0;
		String res = "";
		while (i < db.payment.length-1 && db.payment[i][1] != null) {
			res += "    " + db.payment[i][1] + "    |";
			i++;
		}
		return res;
	}
	public String getAHW() {
		int i= 0;
		String res = "";
		while (i < db.payment.length-1 && db.payment[i][2] != null) {
			res += "      " + db.payment[i][2] + "      |";
			i++;
		}
		return res;
	}
	public String[] search(String key) {
	    String[] res = new String[3];
	    int index = -1;
	    boolean found = false;
	    int i = 0;
	    int j;

	    while (i < db.payment.length && !found) {
	        j = 0; // Initialize j here
	        while (j < db.payment[0].length && !found) {
	            if (key.equals(db.payment[i][j])) {
	                found = true;
	                index = i;
	            }
	            j++;
	        }
	        i++;
	    }

	    if (found && index != -1) {
	        res[0] = db.payment[index][0];
	        res[1] = db.payment[index][1];
	        res[2] = db.payment[index][2];
	    } else {
	    	res[0] = null;
	        res[1] = null;
	        res[2] = null;
	    }

	    return res;
	}
}

package main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;


public class User {
	
	public String filepath = "members.txt";
	public String statistika = "statistika.txt";
	
	
	
		boolean loggedIN;
		
    	public String username;
	    public String password;
	    public String Ime;
	    public String prezime;
	    public String email;
	    public String pol;
	  
	   
	 
	   

		public void setLoggedIN(boolean loggedIN) {
			this.loggedIN = loggedIN;
		}
		
		public User() {
			
		}
		private static Scanner x;
//		public static void registracija(String username,String password,String email,String pol,String filepath) {
//			
//		}
		
		@SuppressWarnings("unused")
		public void login(String username,String password,String filepath, boolean loggedIN) {
			
			
			String tempUsername=" ";
			String tempPassword = " ";
			String tempIme=" ";
			String tempPrezime=" ";
			String tempEmail = " ";
			String tempPol = " ";
			
			
			
            try {
            	x = new Scanner(new File(filepath));
            	x.useDelimiter("[,\n]");
            	while(x.hasNext() && !loggedIN) {
            		tempUsername = x.next();
            		tempPassword = x.next();
            		tempIme = x.next();
            		tempPrezime= x.next();
            		tempEmail = x.next();
            		tempPol = x.next();
            		

            		
            		
            		if(tempUsername.trim().equals(username.trim()) && tempPassword.trim().equals(password.trim())) {
            			setLoggedIN(true);
            			loggedIN=true;
        				
            		}
            	}
            	
            	x.close();
            	
            }catch (Exception e) {
            	System.out.println("EXNISMO TE NASLI");
            }
		}
            //Ovde registraciju namesti
		public void registracija(String username, String password,String ime,String prezime, String email, String pol) {
			String sve;
			sve= username+","+ password +","+ime+","+prezime+","+email+","+pol+"\n";
		try {
		    Files.write(Paths.get(filepath), sve.getBytes(), StandardOpenOption.APPEND);
		}catch (IOException e) {
		    //exception handling left as an exercise for the reader
			}
		}
		
		
		
		
}
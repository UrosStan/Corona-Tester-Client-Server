package main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;


public class User {
	
		boolean loggedIN;
		public String filepath = "members.txt";
    	public String username;
	    public String password;
	    public String email;
	    public String Ime;
	    public String prezime;
	    public String pol;
	    public boolean test;
	 
	    
		public void setTest(boolean test) {
			this.test = test;
		}

		public void setLoggedIN(boolean loggedIN) {
			this.loggedIN = loggedIN;
		}
		
		public User() {
			
		}
		private static Scanner x;
//		public static void registracija(String username,String password,String email,String pol,String filepath) {
//			
//		}
		
		public void login(String username,String password,String filepath, boolean loggedIN) {
			
			
			String tempUsername=" ";
			String tempPassword = " ";
			
			
            try {
            	x = new Scanner(new File(filepath));
            	x.useDelimiter("[,\n]");
            	while(x.hasNext() && !loggedIN) {
            		tempUsername = x.next();
            		tempPassword = x.next();
            		
            		if(tempUsername.trim().equals(username.trim()) && tempPassword.trim().equals(password.trim())) {
            			setLoggedIN(true);
            			System.out.println("Uspesno ste se ulogovali");
        				
            		}
            	}
            	
            	x.close();
            	System.out.println(loggedIN);
            }catch (Exception e) {
            	System.out.println("NISMO TE NASLI");
            }
		}
            //Ovde registraciju namesti
		public void registracija(String username, String password, String email, String pol) {
			String sve;
			sve="\n"+ username+","+ password +"";
		try {
		    Files.write(Paths.get(filepath), sve.getBytes(), StandardOpenOption.APPEND);
		}catch (IOException e) {
		    //exception handling left as an exercise for the reader
			}
		}
		
		
		
		
}
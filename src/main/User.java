package main;

import java.io.File;
import java.util.Scanner;

public class User {
	
		public String filepath = "members.txt";
    	public String username;
	    public String password;
	    public String email;
	    public String pol;
	 
		public User() {
			
		}
		private static Scanner x;
		public static void registracija(String username,String password,String email,String pol,String filepath) {
			
		}
		
		public void login(String username,String password,String filepath) {
			
			boolean found = false;
			String tempUsername=" ";
			String tempPassword = " ";
			
			
            try {
            	x = new Scanner(new File(filepath));
            	x.useDelimiter("[,\n]");
            	while(x.hasNext() && !found) {
            		tempUsername = x.next();
            		tempPassword = x.next();
            		
            		if(tempUsername.trim().equals(username.trim()) && tempPassword.trim().equals(password.trim())) {
            			found=true;
            			System.out.println("Uspeh");
        				System.out.println("Trazeni, user: " + username+ " sifra: "+password);

            			System.out.println("TEMP, user: " + tempUsername+ " sifra: "+tempPassword);
            		}
            	}
            	
            	x.close();
            	System.out.println(found);
            }catch (Exception e) {
            	System.out.println("NISMO TE NASLI");
            }
		}
            
			
		}
		


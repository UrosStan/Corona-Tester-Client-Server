package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;



public class ClientHandler extends Thread {

		BufferedReader clientInput = null;
	    PrintStream clientOutput = null;
	    Socket soketZaKomunikaciju = null;
	    
	    User user = new User();
	    
	    
	    
	    
	    
	 // Konstruktor za NIT
	    
	    public ClientHandler(Socket soket) {
	        soketZaKomunikaciju = soket;
	    }
	 
	    // Metoda run u kojoj se izvrsava NIT
	 
	    @Override
	    public void run() {
	    	
	        try {
	        	//Odmah stavljamo da user nije loginovan.
	        	 user.loggedIN=false;
	        	 
	            // Inicijalizacija ulazno/izlaznih tokova
	        	//Registracija
	    	    
	            clientInput = new BufferedReader(new InputStreamReader(soketZaKomunikaciju.getInputStream()));
	            clientOutput = new PrintStream(soketZaKomunikaciju.getOutputStream());
	            
	        
	            
	            
	            
	            //Ovde u while ide switch metoda
	            int i;
	            
	           do {
	        	  
	        	    clientOutput.println(">>> *** MENI ***");
	            	clientOutput.println(">>> 1.REGISTRACIJA");
	            	clientOutput.println(">>> 2.LOGIN");
	            	
	            	clientOutput.println(">>> Izaberite iz menija opciju:");
	            	i=Integer.parseInt(clientInput.readLine());
	            	
	            

	            	
	            	Meni(user,i);
	            	
	           }while(i!=0); 
	            	
	            
	            
	            
	            
	            
	            
	            
	            
	            
	            
	            
	            //LOGIN
	            
	            
	            
	            
	            
	            
	            
	            
	            
	            
	            
	            
	 
	            // do while petlja koja proverava da li je korisnik ispravno uneo username.
	            // username ne sme da sadrzi space
	 
	           
	 
	                
	 
	                
	 
	 
	            
	 
	           
	 
	            // Korisniku koji napusta chat se salje pozdravna poruka
	 
	            clientOutput.println(">>> Dovidjenja " +user.username);
	 
	          
	 
	            // Korisnik se izbacuje iz liste sa servera
	 
	            Server.onlineUsers.remove(this);
	 
	            // Zatvaramo soket za komunikaciju
	 
	            soketZaKomunikaciju.close();
	 
	            // Ovde je obradjen izuzetak u slucaju da korisnik nasilno napusti chat. U smislu da ne otkuca ***quit nego da samo ugasi
	            // klijentsku aplikaciju. Ili da mu nestane struje npr. 
	 
	        } catch (IOException e) {
	 
	            for (ClientHandler klijent : Server.onlineUsers) {
	 
	                if (klijent != this) {
	 
	                    klijent.clientOutput.println(">>> Korisnik " +user.username+ " je napustio/la chat!");
	 
	                }
	 
	            }
	 
	            Server.onlineUsers.remove(this);
	 
	        }
	 
	 
	    }
	    
	    public void Meni(User user,int i) {
	    	System.out.println("I u meniju je?"+i);
	    	switch (i) {
	    	
			case 1:
				
				try {
					clientOutput.println(">>> Uspesno ste pokrenuli registraciju!");
					
					clientOutput.println(">>> Unesite korisnicko ime:");
					user.username = clientInput.readLine();
					clientOutput.println(">>> Unesite Lozinku:");
					user.password = clientInput.readLine();
					clientOutput.println(">>> Unesite email:");
					user.email = clientInput.readLine();
					clientOutput.println(">>> Unesite pol:");
					user.pol = clientInput.readLine();
					user.registracija(user.username, user.password, user.email, user.pol);
					clientOutput.println(">>> Uspesna registracija!");
					break;
				} catch (IOException e) {
					clientOutput.println(">>> Neuspesna registracija!");
				}
			
			case 2: 
				
				try {
					clientOutput.println(">>> Login je pokrenut uspesno:");
					clientOutput.println(">>> Unesite korisnicko ime:");
	                user.username = clientInput.readLine();
	                clientOutput.println(">>> Unesite Lozinku:");
	                user.password = clientInput.readLine();
	                user.login(user.username, user.password,"members.txt",user.loggedIN);
				} catch (IOException e) {
					clientOutput.println(">>> Neuspesna registracija!");
				}
				
				break;
			
			default:
				clientOutput.println(">>> Lose uneta komanda, pokusajte ponovo!");
				break;
				
			}
	    	
	    }
	 
	 
	}


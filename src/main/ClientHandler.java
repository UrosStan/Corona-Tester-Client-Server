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
	        	 
	            // Inicijalizacija ulazno/izlaznih tokova
	        	//Registracija
	    	    
	            clientInput = new BufferedReader(new InputStreamReader(soketZaKomunikaciju.getInputStream()));
	            clientOutput = new PrintStream(soketZaKomunikaciju.getOutputStream());
	            
	            boolean isValid = true;
	            
	            
	            //Ovde u while ide switch metoda.
	            //LOGIN
	            
	            while(isValid) {
                clientOutput.println(">>> Unesite korisnicko ime:");
                user.username = clientInput.readLine();
                clientOutput.println(">>> Unesite Lozinku:");
                user.password = clientInput.readLine();
                user.login(user.username, user.password,"members.txt");
	            
	            
	            }
	            
	            
	            
	            
	            
	            
	            
	            
	            
	            
	 
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
	 
	 
	}


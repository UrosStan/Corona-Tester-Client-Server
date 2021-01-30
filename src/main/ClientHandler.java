package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Random;



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
	        	  
	        	    clientOutput.println("*** MENI ***");
	            	clientOutput.println("1.REGISTRACIJA");
	            	clientOutput.println(" 2.LOGIN");
	            	clientOutput.println("3.TEST SAMOPROCENE");
	            	clientOutput.println("0.IZLAZ");
	            	
	            	
	            	clientOutput.println(">>> Izaberite iz menija opciju: ");
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
	    	
	    	switch (i) {
	    	
			case 1:
				
				try {
					clientOutput.println(">>> Uspesno ste pokrenuli registraciju!");
					
					clientOutput.println(">>> Unesite korisnicko ime:");
					user.username = clientInput.readLine();
					clientOutput.println(">>> Unesite Lozinku:");
					user.password = clientInput.readLine();
					clientOutput.println(">>> Unesite svoje ime:");
					user.Ime = clientInput.readLine();
					clientOutput.println(">>> Unesite svoje prezime:");
					user.prezime = clientInput.readLine();
					clientOutput.println(">>> Unesite email:");
					user.email = clientInput.readLine();
					clientOutput.println(">>> Unesite pol:");
					user.pol = clientInput.readLine();
					
					user.registracija(user.username, user.password,user.Ime,user.prezime, user.email, user.pol);
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
	                user.login(user.getUsername(), user.getPassword(),"members.txt",false);
	                if(user.loggedIN) {
	                	clientOutput.println(">>> Uspesno ste se ulogovali");
	                }else {
	                	clientOutput.println(">>> Niste se uspesno  ulogovali");

	                }

	                
				} catch (IOException e) {
					clientOutput.println(">>> ex.Neuspesan login");
				}
				
				break;
				
			case 3:
				try {
				if(user.loggedIN && !user.getUsername().equals("admin")) {
					int temp,j=0;
					clientOutput.println(">>> Zapoceli ste test samoprocene, "
							+ "\nodgovarate pozitivno na pitanja unoseci broj 1(jedan), a negativno"
							+ "\nunoseci broj 0(nula)");
					clientOutput.println("Da li ste putovali van Srbije u okviru 14 dana pre početka simptoma?");
					temp=Integer.parseInt(clientInput.readLine());
					j+=temp;
					clientOutput.println("Da li ste bili u kontaku sa zaraženim osobama?");
					temp=Integer.parseInt(clientInput.readLine());
					j+=temp;
					
					clientOutput.println("Šta imate od sledecih simptoma: ");
					clientOutput.println("Povišena temperatura?");
					temp=Integer.parseInt(clientInput.readLine());
					j+=temp;
					clientOutput.println("Kašalj?");
					temp=Integer.parseInt(clientInput.readLine());
					j+=temp;
					clientOutput.println("Opšta slabost?");
					temp=Integer.parseInt(clientInput.readLine());
					j+=temp;
					clientOutput.println("Gubitak čula mirisa?");
					temp=Integer.parseInt(clientInput.readLine());
					j+=temp;
					clientOutput.println("Gubitak/promena čula ukusa?");
					temp=Integer.parseInt(clientInput.readLine());
					j+=temp;
					
					if(j>=2) {
					boolean brzi_test_rezultat;
					Random random = new Random();
					brzi_test_rezultat=random.nextBoolean();
					clientOutput.println("Pokrecem brzi test...");
					Statistika.tajmerUpis(System.currentTimeMillis(), user.getUsername());	

					if(brzi_test_rezultat) {
						clientOutput.println("Rezultat Vaseg testa je pozitivan");
						


					}else {
						clientOutput.println("Rezultat Vaseg testa je negativan");
					}
				}
					
				}else {
					clientOutput.println("Molimo, prvo se ulogujte");

				}
			
				}catch (IOException e){
					clientOutput.println(">>> Doslo je do greske, molim, pokusajte ponovo");
				}
				break;
			
			case 4:
				if(user.getUsername().equals("admin")){
					clientOutput.println(">>>Uspesno otvorena statistika: ");

					Statistika.citaStat();
				}else {
					clientOutput.println(">>>Samo admin moze pristupiti ovom fajlu");

				}
				
				
				break;
			default:
				clientOutput.println(">>> Lose uneta komanda, pokusajte ponovo!");
				break;
				
			}
	    	
	    }	
	 
	 
	}


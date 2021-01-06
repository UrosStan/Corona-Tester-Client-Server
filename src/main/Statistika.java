package main;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;


public class Statistika {
	public static String statistika = "statistika.txt";
	public static int brojTestova;
	public static int brojPozitivnih;
	public static int brojNegativnih;
	public static int brojNadzorom;
	
	
	public static void upisStat(int brojTestova, int brojPozitivnih,int brojNegativnih,int brojNadzorom) {
		String sve;
		sve= "Broj testova:"+brojTestova+"\n"+ 
		"Broj pozitivnih:" +brojPozitivnih+"\n"+ 
		"Broj negativnih:"+brojNegativnih+"\n"+
		"Pod nadzorom:"+brojNadzorom+"\n";
	try {
	    Files.write(Paths.get(statistika), sve.getBytes(), StandardOpenOption.WRITE);
	}catch (IOException e) {
	    //exception handling left as an exercise for the reader
		}
	}
	
	private static Scanner x;
@SuppressWarnings("unused")
public static void citaStat() {
	String temp1=" ";
	String tempTest = " ";
	String temp2=" ";
	String tempPoz = " ";
	String temp3=" ";
	String tempNeg = " ";
	String temp4=" ";
	String tempNad = " ";
	
	
	
	
    try {
    	x = new Scanner(new File(statistika));
    	x.useDelimiter("[:\n]");
    	
    		temp1 = x.next();
    		tempTest = x.next();
    		
    		temp2 = x.next();
    		tempPoz = x.next();
    		
    		temp3 = x.next();
    		tempNeg = x.next();
    		
    		temp4 = x.next();
    		tempNad = x.next();
    		
    		setBrojTestova(Integer.parseInt(tempTest));
    		System.out.println("Broj testova je:"+Statistika.brojTestova);

    		setBrojPozitivnih(Integer.parseInt(tempPoz));
    		System.out.println("Broj pozitivnih je:" +Statistika.brojPozitivnih);
    		
    		setBrojNegativnih(Integer.parseInt(tempNeg));
    		System.out.println("Broj negativnih je:" +Statistika.brojNegativnih);
    		
    		setBrojNadzorom(Integer.parseInt(tempNad));
    		System.out.println("Pod nadzorom je:" +Statistika.brojNadzorom);
				
    		
    	
    	
    	x.close();
    	
    }catch (Exception e) {
    	System.out.println("EXNISMO TE NASLI");
    }
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public static void setStatistika(String statistika) {
		Statistika.statistika = statistika;
	}


	public static void setBrojTestova(int brojTestova) {
		Statistika.brojTestova = brojTestova;
	}


	public static void setBrojPozitivnih(int brojPozitivnih) {
		Statistika.brojPozitivnih = brojPozitivnih;
	}


	public static void setBrojNegativnih(int brojNegativnih) {
		Statistika.brojNegativnih = brojNegativnih;
	}


	public static void setBrojNadzorom(int brojNadzorom) {
		Statistika.brojNadzorom = brojNadzorom;
	}
	
	
	
	
	
	
	
}

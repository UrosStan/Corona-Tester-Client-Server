package main;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Klijent implements Runnable {

	// Definisemo ulazni i izlazni tok, soket za komunikaciju i ulaz sa tastature
	 
    static Socket soketZaKomunikaciju = null;
    static BufferedReader serverInput = null;
    static PrintStream serverOutput = null;
    static BufferedReader unosSaTastature = null;
 
    // U okviru MAIN metode definisemo prikaz poruka koje dolaze od serverske niti (od servera)
 
    public static void main(String[] args) {
 
        try {
 
            // Kada pokrenemo klijenta gadjamo localhost i port 9000 def. na serverskoj strani
 
            soketZaKomunikaciju = new Socket("localhost", 9000);
 
            // Inicijalizujemo tokove i unos sa tastature
 
            serverInput = new BufferedReader(new InputStreamReader(soketZaKomunikaciju.getInputStream()));
            serverOutput = new PrintStream(soketZaKomunikaciju.getOutputStream());
 
            unosSaTastature = new BufferedReader(new InputStreamReader(System.in));
 
            // Ovde pokrecemo metodu RUN koja je def. nize
 
            new Thread(new Klijent()).start();
 
            // Dokle god stizu poruke, iste se ispisuju na strani klijenta.
            // Ako dodje poruka koja pocinje sa >>> Dovidjenja, a to je u slucaju da smo mi uneli ***quit, zatvara se
            // soket za komunikaciju
 
            String input;
 
            while (true) {
 
                input = serverInput.readLine();
 
                System.out.println(input);
 
                if (input.startsWith(">>> Dovidjenja")) {
 
                    break;
 
                }
 
            }
 
            // Zatvaranje soketa u slucaju kada napustamo chat
 
            soketZaKomunikaciju.close();
 
 
            // Obradjena su dva izuzetka:
            // 1)Prvi u slucacu da je nepoznat host tj. server na koji se kacimo
            // 2)Drugi u slucaju da server iznenada prestane sa radom npr.
 
        } catch (UnknownHostException e) {
 
            System.out.println("NEPOZNAT HOST!");
 
        } catch (IOException e) {
 
            System.out.println("SERVER JE PAO!");
        }
 
    }
 
    // U okviru RUN metode saljemo poruke koje klijent otkuca ka serveru
 
    @Override
    public void run() {
 
 
        String message;
 
 
        while (true) {
 
            try {
 
 
                message = unosSaTastature.readLine();
                serverOutput.println(message);
 
                // Ako otkucamo ***quit napustamo chat
 
                if (message.equals("***quit")) {
 
                    break;
 
                }
 
 
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
 
 
 
        }
 
    }
 
}

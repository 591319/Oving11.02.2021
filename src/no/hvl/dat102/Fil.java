package no.hvl.dat102;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import no.hvl.dat102.ADT.*;

public class Fil {
	final static String SKILLE = "#";				// Eventuelt ha som parameter i
		
											// metodene.
	
	// Lese et Filmarkiv fra tekstfil
	public static void lesFraFil(FILMarkivADT filmarkiv, String filnavn){
			
        FileReader filmFil = null;        
        BufferedReader innfil = null;
           
    try{
        // // 1 - FileReader
       filmFil = new FileReader("C:\\Users\\madso\\Desktop\\Skole\\DAT102\\" + filnavn);
    }
    
    catch(FileNotFoundException unntak){
        System.out.println("Finner ikke filen " + filnavn);
        System.exit(1);
        // Vi kan lage script som kjører programmet fra kommandolinjen 
        // og fanger opp returkoden ved System.exit
        //
    }
    try {          
        // 2 - BufferedReader
        innfil = new BufferedReader(filmFil);
        
        // 3 - Leser den første posten som er antall info-poster
        String linje = innfil.readLine();
        int n = Integer.parseInt(linje);
        
        // 4 - Les postene, en hel post om gangen
        String post = innfil.readLine();
        for (int i = 0; i < n; i++) {
            String[] felt = post.split(SKILLE); 
            // http://docs.oracle.com/javase/8/docs/api/java/lang/String.html#split(java.lang.String, int)
            
            int FNr   = Integer.parseInt(felt[0]);
            String FilmSkaper = felt[1];
            String Tittel = felt[2];
            int lanseringsaar  = Integer.parseInt(felt[3]);
            String sjanger = felt[4];
            String Filmselskap = felt[5];
            
            Film a = new Film(FNr, FilmSkaper, Tittel, lanseringsaar, Sjanger.finnSjanger(sjanger), Filmselskap);
            filmarkiv.leggTilFilm(a);
            
            post = innfil.readLine();
        }
        
        // 4 - Lukk filen
        innfil.close();
		
		
		}
	catch (IOException e) {
        System.out.println("Feil ved lesing av fil: " + e);
        System.exit(2);
        }   
   }

	
// Lagre et Filmarkiv til tekstfil
	public static void skrivTilFil(FILMarkivADT filmarkiv, String filnavn) throws IOException{
		
        
        try {
            // 1 - FileWriter
            FileWriter filmFil = new FileWriter("C:\\Users\\madso\\Desktop\\Skole\\DAT102\\" + filnavn, false);
            
            // 2 - PrintWriter
            PrintWriter utfil = new PrintWriter(filmFil);
            
            //3 - Skriver først ut antall ansatt-info-er på den første linjen            
            utfil.println(filmarkiv.antall());
            
            // 3 - Skriv postene, felt for felt
            Film[] test = filmarkiv.hentFilmTabell();
            
            for (int i = 0; i < filmarkiv.antall()-1; i++) {
            	utfil.print(test[i].getFilmnr()); utfil.print(SKILLE);
            	utfil.print(test[i].getFilmskaper()); utfil.print(SKILLE);
            	utfil.print(test[i].getTittel()); utfil.print(SKILLE);
            	utfil.print(test[i].getAar()); utfil.print(SKILLE);
            	utfil.print(test[i].getSjanger()); utfil.print(SKILLE);
            	utfil.print(test[i].getFilmselskap()); utfil.println();              
            }            
            // 4 - Lukk filen
            utfil.close();
            
        } catch (IOException e) {
            System.out.println("Feil ved skriving til fil : " + e);
            System.exit(3);
        }
    }
	//class
}
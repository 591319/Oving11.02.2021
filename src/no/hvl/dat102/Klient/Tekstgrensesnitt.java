 package no.hvl.dat102.Klient;

import java.util.Scanner;
import no.hvl.dat102.Film;
import no.hvl.dat102.Sjanger;
import no.hvl.dat102.ADT.FILMarkivADT;

public class Tekstgrensesnitt {
		public final static Scanner tast = new Scanner(System.in);
	
	// lese opplysningene om en FILM fra tastatur
	    public Film lesFilm(){
	    	
	    	Film les = new Film();
	    	
	    	
	    	
//	    		Skriver inn Film nummer
	    		System.out.println("Skriv inn FilmNr på filmen du vil legge til: ");
	    			les.setFilmnr(tast.nextInt());
	    			
//	    		Skriver inn Filmskaper
	    		System.out.println("Filmskaper: ");
	    			String filmskaper = tast.next();
	    			filmskaper += tast.nextLine();
	    			les.setFilmskaper(filmskaper);
	    			
//	    		Skriver inn tittelen på film
	    		System.out.println("Tittel på film: ");
	    			String tittel = tast.next();
	    			tittel += tast.nextLine();
	    			les.setTittel(tittel);
	    			
//	    		Skriver inn Året når filmen ble gitt ut
	    		System.out.println("Lanseringår: ");
	    			les.setAar(tast.nextInt());
	    			
//	    		Skriver inn Sjangeren på filmen
	    		System.out.println("Sjanger på filmen: ");
	    			les.setSjanger(Sjanger.finnSjanger(tast.next()));
	    			
//	    		Skriver inn Filmselskapet på filmen
	    		System.out.println("Filmselskap på filmen: ");
	    			String filmselskap = tast.next();
	    			filmselskap += tast.nextLine();
	    			les.setFilmselskap(filmselskap);
	    			
//	    			tast.close();
	    		System.out.println(les.getFilmnr() + " " + les.getFilmskaper()+ " " + les.getTittel() + " " +
	    			les.getAar() + " " + les.getSjanger() + " " + les.getFilmselskap());
	    			
	    			
	    	return les;

	}

	    // vise en film med alle opplysninger på skjerm (husk tekst for sjanger)
	    public void visFilm(Film film){
	    String les = "";
	    les = film.getFilmnr() + "#" + film.getFilmskaper() + "#" + 
	    film.getTittel() + "#" + film.getAar() + "#" + 
	    film.getSjanger() + "#" + film.getFilmselskap();
	    
	    System.out.print(les);
	     
	}

	    // Skrive ut alle Filmer med en spesiell delstreng i tittelen
	    public void skrivUtFilmDelstrengITittel(FILMarkivADT filma, String delstreng){
	    	
	    	for (int i = 0; i < filma.soekTittel(delstreng).length; i++) {
	    		System.out.println(filma.soekTittel(delstreng)[i]);
	    	}
	}

	    // Skriver ut alle Filmerav en produsent/ en gruppe
	    public void skrivUtFilmProdusent(FILMarkivADT filma, String delstreng) {
	    	for (int i = 0; i < filma.soekProdusent(delstreng).length; i++) {
	    		System.out.println(filma.soekProdusent(delstreng)[i]);
	    	}
	    }

	    // Skrive ut en enkel statistikk som inneholder antall Filmertotalt
	    // og hvor mange det er i hver sjanger
	    public void skrivUtStatistikk(FILMarkivADT filma){	   
	    	int tall = filma.antall();
	    	tall = tall-1;
	    	System.out.println(
	    	"Antall filmer: " + tall + "\n" +  
	    	"Antall action: " + filma.antall(Sjanger.ACTION) + "\n" + 
	    	"Antall drama: " + filma.antall(Sjanger.DRAMA) + "\n" + 
	    	"Antall historie: " + filma.antall(Sjanger.HISTORY) + "\n" + 
	    	"Antall SCIFI: " + filma.antall(Sjanger.SCIFI) + "\n" +
	    	"Antall Fantasy: " + filma.antall(Sjanger.FANTASY)
	    	);	
	
	    }//... Ev. andre metoder}//class
	}

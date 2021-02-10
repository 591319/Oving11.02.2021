package no.hvl.dat102.Klient;

import no.hvl.dat102.ADT.*;

import java.io.IOException;

import no.hvl.dat102.*;

public class Meny {
	
	private Tekstgrensesnitt tekstgr;
	private FILMarkivADT filma;
	
	public Meny(FILMarkivADT filma) {
		tekstgr = new Tekstgrensesnitt();
		this.filma = filma;

	}
	
	public void start()  {
		String meny = "\n" + "Hva vil du gjøre: " + "\n" + 
				"Legge til film (Skriv 1)" + "\n" + 
				"Vise Film(tast 2)" + "\n" + 
				"Slette film (Skriv 3)" + "\n" +
				"Skriv ut Statistikk(tast 4)" + "\n" +
				"Lagre som fil(tast 5)" + "\n" +
				"Lese fra fil(tast 6)" + "\n" + 
				"Avslutt meny(tast 7)";
		System.out.println(meny);
		
		int in = Tekstgrensesnitt.tast.nextInt();
		boolean avslutt = false;
		while(avslutt == false){
		switch (in) {
		
		case 1:
			Film b = (tekstgr.lesFilm());
			filma.leggTilFilm(b);
			System.out.println(meny);
			in = Tekstgrensesnitt.tast.nextInt();
		break;
		
		case 2: 
			System.out.println("Hvilken film?");
			
			String test = Tekstgrensesnitt.tast.next();
			test += Tekstgrensesnitt.tast.nextLine();
			Film a = new Film();
			
			for (int i = 0; i< filma.soekTittel(test).length;i++) {
			a = filma.soekTittel(test)[i];
			tekstgr.visFilm(a);
			}
			
			
			System.out.println(meny);
			in = Tekstgrensesnitt.tast.nextInt();
		break;
		
		case 3:
			System.out.println("Skriv filmNr");
			int filmNr = Tekstgrensesnitt.tast.nextInt();
			filma.slettFilm(filmNr);
			System.out.println(meny);
			in = Tekstgrensesnitt.tast.nextInt();
		break;
		
		case 4:	
			tekstgr.skrivUtStatistikk(filma);
			System.out.println(meny);
			in = Tekstgrensesnitt.tast.nextInt();
		break;
		case 5:

			try {
				Fil.skrivTilFil(filma, "Film.txt");
				System.out.println(meny);
			in = Tekstgrensesnitt.tast.nextInt();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("Feil ved skriving til fil : " + e);
			}
			
		break;
		case 6:
			Fil.lesFraFil(filma, "Film.txt");
			System.out.println(meny);
			in = Tekstgrensesnitt.tast.nextInt();
		break;
			
		
		default:
		System.out.println("Avsluttet");
		avslutt = true;
		Tekstgrensesnitt.tast.close();
		 
			}
		} 

	}
}

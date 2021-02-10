package no.hvl.dat102.Klient;

import no.hvl.dat102.ADT.*;
import no.hvl.dat102.*;

public class KlientFilmarkiv {

	public static void main(String[] args) {
	//... meny  
		FILMarkivADT filma = new FILMarkiv();
		Meny meny = new Meny(filma);

		
		meny.start();
		   }
	
}//class	
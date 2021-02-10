package no.hvl.dat102;

import no.hvl.dat102.ADT.FILMarkivADT;

public class FILMarkiv implements FILMarkivADT{

	private Film[] filmTabell;
	private int antall;
	

	
	public FILMarkiv() {
		antall = 1;
		filmTabell = new Film[antall];
		
	}
	private Film[] trimTab(Film[] tab, int n) {

		Film[] filmtab2= new Film[n];
		int i= 0;
		while(i< n) {
			filmtab2[i] = tab[i];
			i++;	
			
		}
		return filmtab2;
}

	@Override
	public Film[] hentFilmTabell() {

//		filmTabell = trimTab(filmTabell, antall);
		return filmTabell;
	}
	
	private void utvidKapasitet() {
		Film[] hjelpetabell = new Film [(int)Math.ceil(1.1 * filmTabell.length)];
			for (int i = 0; i < filmTabell.length; i++) {
				hjelpetabell[i] = filmTabell[i];
			}
			filmTabell = hjelpetabell;
	}


	@Override
	public void leggTilFilm(Film nyFilm) {
//		if(antall == 0) {
//			utvidKapasitet2();
//			filmTabell[0] = nyFilm;
//		}
		if(antall == filmTabell.length) {
		filmTabell[antall-1] = nyFilm;
		antall++;
		} else {
			utvidKapasitet();
			filmTabell[antall-1] = nyFilm;
			antall++;
		}
}

	@Override
	public boolean slettFilm(int filmnr) {
	boolean finnes = false;
	boolean slettet = false;
		
	for (int i = 0; i < filmTabell.length;i++) {
		if (filmTabell[i].getFilmnr() == (filmnr)) {
			finnes = true;
		}
		if (finnes == true) {
			if(antall-2 < 0) {
				filmTabell[i] = new Film();
			} else {
			filmTabell[i] = filmTabell[antall-2];
			antall--;
			slettet = true;
			}
		}
	}
	filmTabell = trimTab(filmTabell, antall);
	return slettet;
	} 

	@Override
	public Film[] soekTittel(String delstreng) {
		int antall = 0;
		Film[] soktab = new Film[this.antall];
		for (int i = 0; i < filmTabell.length; i++) {
				if (filmTabell[i].getTittel().toUpperCase().contains(delstreng.toUpperCase())) {
					soktab[antall] = filmTabell[i];
					
					antall++;
			}
		}
		soktab = trimTab(soktab, antall);
		return soktab;
	}

	@Override
	public Film[] soekProdusent(String delstreng) {
		int antall = 0;
		Film[] soktab = new Film[this.antall];
		for (int i = 0; i < filmTabell.length; i++) {
				if (filmTabell[i].getFilmskaper().toUpperCase().contains(delstreng.toUpperCase())) {
					soktab[antall] = filmTabell[i];
					soktab = trimTab(soktab, antall);
					antall++;
			}
		}
		return soktab;
	}

	@Override
	public int antall(Sjanger sjanger) {
		int antall = 0;
		
		for (int i = 0; i < filmTabell.length; i++) {
				if (filmTabell[i].getSjanger().equals(sjanger)) {
					antall++;
			}
		}
		return antall;
	}

	@Override
	public int antall() {
		
		return antall;
	}

}

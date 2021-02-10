package no.hvl.dat102;

public class Film {
//	Nr#Produsent#Tittel#år#Sjanger#Filmselskap
	private int filmnr;
	private String filmskap;
	private String tittel;
	private int aar;
	private Sjanger sjanger;
	private String filmselskap;
	

	public Film() {
		
	}
	
	public Film(int filmnr, String filmskaper, String tittel, int aar, Sjanger sjanger, String filmselskap) {

		this.filmnr = filmnr;
		filmskap = filmskaper;
		this.tittel = tittel;
		this.aar = aar;
		this.sjanger = sjanger;
		this.filmselskap = filmselskap;
	}

	public int getFilmnr() {
		return filmnr;
	}

	public void setFilmnr(int filmnr) {
		this.filmnr = filmnr;
	}

	public String getFilmskaper() {
		return filmskap;
	}

	public void setFilmskaper(String filmskap) {
		this.filmskap = filmskap;
	}

	public String getTittel() {
		return tittel;
	}

	public void setTittel(String tittel) {
		this.tittel = tittel;
	}

	public int getAar() {
		return aar;
	}

	public void setAar(int aar) {
		this.aar = aar;
	}

	public Sjanger getSjanger() {
		return sjanger;
	}

	public void setSjanger(Sjanger sjanger) {
		this.sjanger = sjanger;
	}

	public String getFilmselskap() {
		return filmselskap;
	}

	public void setFilmselskap(String filmselskap) {
		this.filmselskap = filmselskap;
	}

	
}
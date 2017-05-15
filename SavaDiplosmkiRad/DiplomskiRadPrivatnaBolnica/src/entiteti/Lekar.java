package entiteti;

import java.sql.Date;

public class Lekar {

	public String JmbgLekar;
	public int PTT;
	public int ZvanjeID;
	public String Ime;
	public String Prezime;
	public String KorisnicnoIme;
	public int Sifra;
	public Date DatumRodjenja;
	public String UlicaiBroj;
	public String BrojTelefona;
	
	public String toString(){
		return JmbgLekar + " " + Ime + " " + Prezime + " ";
	}
	
	
	
	
	

	public String getJmbgLekar() {
		return JmbgLekar;
	}


	public void setJmbgLekar(String jmbgLekar) {
		JmbgLekar = jmbgLekar;
	}


	public int getPTT() {
		return PTT;
	}
	public void setPTT(int pTT) {
		PTT = pTT;
	}
	public int getZvanjeID() {
		return ZvanjeID;
	}
	public void setZvanjeID(int zvanjeID) {
		ZvanjeID = zvanjeID;
	}
	public String getIme() {
		return Ime;
	}
	public void setIme(String ime) {
		Ime = ime;
	}
	public String getPrezime() {
		return Prezime;
	}
	public void setPrezime(String prezime) {
		Prezime = prezime;
	}
	public String getKorisnicnoIme() {
		return KorisnicnoIme;
	}
	public void setKorisnicnoIme(String korisnicnoIme) {
		KorisnicnoIme = korisnicnoIme;
	}
	public int getSifra() {
		return Sifra;
	}
	public void setSifra(int sifra) {
		Sifra = sifra;
	}
	public Date getDatumRodjenja() {
		return DatumRodjenja;
	}
	public void setDatumRodjenja(Date datumRodjenja) {
		DatumRodjenja = datumRodjenja;
	}
	public String getUlicaiBroj() {
		return UlicaiBroj;
	}
	public void setUlicaiBroj(String ulicaiBroj) {
		UlicaiBroj = ulicaiBroj;
	}
	public String getBrojTelefona() {
		return BrojTelefona;
	}
	public void setBrojTelefona(String brojTelefona) {
		BrojTelefona = brojTelefona;
	}
	
	
	
	
}

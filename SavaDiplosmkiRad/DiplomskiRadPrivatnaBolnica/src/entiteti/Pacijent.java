package entiteti;

import java.sql.Date;

public class Pacijent {
	
	public String JmbgPacijent;
	public int PTT;
	public String ImeOca;
	public String Ime;
	public String Prezime;
	public Date DatumRodjenja;
	public String BrojTelefona;
	public String UlicaiBroj;
	public int BrojZdravstveneKnjizice;
	
	public String toString(){
		return JmbgPacijent + " " + Ime + " " + ImeOca + " " + Prezime + " ";
	}
	

	
	
	

	public String getJmbgPacijent() {
		return JmbgPacijent;
	}


	public void setJmbgPacijent(String jmbgPacijent) {
		JmbgPacijent = jmbgPacijent;
	}


	public String getImeOca() {
		return ImeOca;
	}
	public void setImeOca(String imeOca) {
		ImeOca = imeOca;
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
	public Date getDatumRodjenja() {
		return DatumRodjenja;
	}
	public void setDatumRodjenja(Date datumRodjenja) {
		DatumRodjenja = datumRodjenja;
	}
	public String getBrojTelefona() {
		return BrojTelefona;
	}
	public void setBrojTelefona(String brojTelefona) {
		BrojTelefona = brojTelefona;
	}
	public String getUlicaiBroj() {
		return UlicaiBroj;
	}
	public void setUlicaiBroj(String ulicaiBroj) {
		UlicaiBroj = ulicaiBroj;
	}
	public int getPTT() {
		return PTT;
	}
	public void setPTT(int pTT) {
		PTT = pTT;
	}

	public int getBrojZdravstveneKnjizice() {
		return BrojZdravstveneKnjizice;
	}

	public void setBrojZdravstveneKnjizice(int brojZdravstveneKnjizice) {
		BrojZdravstveneKnjizice = brojZdravstveneKnjizice;
	}
	
	
	
}

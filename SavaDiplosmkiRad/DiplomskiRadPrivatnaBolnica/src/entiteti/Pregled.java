package entiteti;

import java.sql.Date;

public class Pregled {
	
	public int PregledID;
	public String JmbgLekar;
	public String JmbgPacijent;
	public Date DatumPregleda;
	
	public int getPregledID() {
		return PregledID;
	}
	public void setPregledID(int pregledID) {
		PregledID = pregledID;
	}
	public String getJmbgLekar() {
		return JmbgLekar;
	}
	public void setJmbgLekar(String jmbgLekar) {
		JmbgLekar = jmbgLekar;
	}
	public String getJmbgPacijent() {
		return JmbgPacijent;
	}
	public void setJmbgPacijent(String jmbgPacijent) {
		JmbgPacijent = jmbgPacijent;
	}
	public Date getDatumPregleda() {
		return DatumPregleda;
	}
	public void setDatumPregleda(Date datumPregleda) {
		DatumPregleda = datumPregleda;
	}

}

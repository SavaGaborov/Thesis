package entiteti;

import java.sql.Date;

public class Recept {

	public int ReceptID;
	public int LekID;
	public int PregledID;
	
	public int getReceptID() {
		return ReceptID;
	}
	public void setReceptID(int receptID) {
		ReceptID = receptID;
	}
	public int getLekID() {
		return LekID;
	}
	public void setLekID(int lekID) {
		LekID = lekID;
	}
	public int getPregledID() {
		return PregledID;
	}
	public void setPregledID(int pregledID) {
		PregledID = pregledID;
	}
	
}

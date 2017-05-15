package entiteti;

public class ZdravstvenaUstanova {
	
	public int ZdravstvenaUstanovaID;
	public String NazivZdravstveneUstanove;
	
	public String toString(){
		return  NazivZdravstveneUstanove + " ";
	}
	
	public int getZdravstvenaUstanovaID() {
		return ZdravstvenaUstanovaID;
	}
	public void setZdravstvenaUstanovaID(int zdravstvenaUstanovaID) {
		ZdravstvenaUstanovaID = zdravstvenaUstanovaID;
	}
	public String getNazivZdravstveneUstanove() {
		return NazivZdravstveneUstanove;
	}
	public void setNazivZdravstveneUstanove(String nazivZdravstveneUstanove) {
		NazivZdravstveneUstanove = nazivZdravstveneUstanove;
	}
	
	

}

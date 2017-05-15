package metode;

import java.lang.Thread.State;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.concurrent.SynchronousQueue;
import com.mysql.jdbc.PreparedStatement;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

import entiteti.Bolest;
import entiteti.Dijagnoza;
import entiteti.Faktura;
import entiteti.IzvrseneUsluge;
import entiteti.Lek;
import entiteti.Lekar;
import entiteti.Mesto;
import entiteti.Pacijent;
import entiteti.Pregled;
import entiteti.Proizvodjac;
import entiteti.Recept;
import entiteti.Region;
import entiteti.StavkaFakture;
import entiteti.Uput;
import entiteti.Usluga;
import entiteti.ZdravstvenaUstanova;
import entiteti.Zvanje;

public class ManipulacijaSaBazom {
	

private PreparedStatement  ps;

//*********** #FREJM 3 *********Dodavanje (Insertovanje) pacijenata u bazu************************************
	
	public boolean UnosPacijenta (Pacijent pacijent){
		PreparedStatement ps= null; 				// klasu preparedstatement koristim za pisanje SQL upita
		
		try{
			Konekcija.getKonekcija().setAutoCommit(false);				//ukoliko se ne pozove setAutoCommit metod upit se posle ekzekucije automatski izvrsava
			ps=(PreparedStatement) Konekcija.getKonekcija().prepareStatement("INSERT INTO Pacijent (Jmbg_pacijent, PTT, Ime_oca, Ime, Prezime, Datum_Rodjenja, Broj_telefona, Ulica_i_broj, Broj_zdravstvene_knjizice) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
												
													//setovanje i getovanje vrednosti
			
			ps.setString(1, pacijent.getJmbgPacijent());
			ps.setInt(2, pacijent.getPTT());
			ps.setString(3, pacijent.getImeOca());
			ps.setString(4, pacijent.getIme());
			ps.setString(5, pacijent.getPrezime());
			ps.setDate(6, pacijent.getDatumRodjenja());
			ps.setString(7, pacijent.getBrojTelefona());
			ps.setString(8, pacijent.getUlicaiBroj());
			ps.setInt(9, pacijent.getBrojZdravstveneKnjizice());
			
			
			
			ps.executeUpdate();						//izvrsavanje upita
			
			Konekcija.getKonekcija().commit();		//izvrsavanje upita ukoliko se ne prijavi nikakva greska treba da varti true kako bi se korisnik obavestio o uspesnom unosu
			
			return true;
			
		}catch(Exception e){						// u suprotnom da se obavesti o greski
			
			e.printStackTrace();
			return false;
		}
		finally{
			try {
				ps.close();						// zatvaranje konekcije
			} catch (SQLException e) {
			
				e.printStackTrace();
			}		
		}
		
	};
//********** #FREJM 3/#FREJM5/#FREJM 8/#FREJM10**********Selektovanje PTT na osnovu Naziva mesta iz baze za INSERTOVANJE pacijenata i lekara****************************************
	public static String UzimanjeIDnaOsnovuNazivaMesta (String NazivMesta){
		
		
		
		ResultSet rs=null;
		PreparedStatement ps= null;
		
		
		try {
			Konekcija.getKonekcija().setAutoCommit(false);
			
			ps=(PreparedStatement) Konekcija.getKonekcija().prepareStatement("SELECT PTT FROM mesto WHERE Naziv_mesta='" + NazivMesta + "'");
			
			rs=ps.executeQuery();
			
			while (rs.next()){							// radi i sa while i sa if obicno bez toga se desava da prijavi gresku 
			
			return rs.getString(1).toString();}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "";
	} 
//********** #FREJM  8**********Uzimanje ZvanjeID na osnovu Naziva Zvanja iz baze za INSERTOVANJE lekara****************************************

	public static String UzimanjeZvanjaIDnaOsnovuProsledjenogNazivaZvanja(String Zvanje){
		
		PreparedStatement ps=null;
		ResultSet rs=null;
		int ZvanjeID=0;
		
		
		
		try {
			Konekcija.getKonekcija().setAutoCommit(false);
			ps=(PreparedStatement) Konekcija.getKonekcija().prepareStatement("SELECT Zvanje_ID FROM zvanje WHERE Zvanje='" + Zvanje + "'");
			rs=ps.executeQuery();
			while(rs.next()){
				return rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "";
		
		
	}
//********** #FREJM 8 **********Dodavanje (Insertovanje) lekara u bazu****************************************
	
	public boolean UnosLekara (Lekar lekar){
		
		PreparedStatement ps=null;
		
		
		try{
			Konekcija.getKonekcija().setAutoCommit(false);
			ps=(PreparedStatement) Konekcija.getKonekcija().prepareStatement("INSERT INTO Lekar(Jmbg_lekar, PTT, Zvanje_ID, Ime, Prezime, Korisnicko_ime, Sifra, Datum_rodjenja, Ulica_i_broj, Broj_telefona) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			ps.setString(1, lekar.getJmbgLekar());
			ps.setInt(2, lekar.getPTT());
			ps.setInt(3, lekar.getZvanjeID());
			ps.setString(4, lekar.getIme());
			ps.setString(5, lekar.getPrezime());
			ps.setString(6, lekar.getKorisnicnoIme());
			ps.setInt(7, lekar.getSifra());
			ps.setDate(8, lekar.getDatumRodjenja());
			ps.setString(9, lekar.getUlicaiBroj());
			ps.setString(10, lekar.getBrojTelefona());
			
			ps.executeUpdate();
			
			Konekcija.getKonekcija().commit();
			
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		finally{
			try{
				ps.close();
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	//********** #FREJM 11/#FREJM 12**********Uzimanje ProizvodjacaID na osnovu Naziva Proizvodjaca iz baze za INSERTOVANJE Leka****************************************
	
	public static String SelektovanjeProizvodjacIDnaOsnovuImenaProizvodjaca (String NazivProizvodjaca){
		 
		 PreparedStatement ps=null;
		 ResultSet rs=null;
		 
		 
		 try {
			Konekcija.getKonekcija().setAutoCommit(false);
			ps=(PreparedStatement) Konekcija.getKonekcija().prepareStatement("SELECT Proizvodjac_ID FROM proizvodjac WHERE Naziv_proizvodjaca='" + NazivProizvodjaca + "'");
		
			rs=ps.executeQuery();
			
			String ProizvodjacID = "";
			while(rs.next()){
				ProizvodjacID= rs.getString(1);
			}
			return ProizvodjacID;
		 } catch (Exception e) {
			e.printStackTrace();
		}
		return ""; 
	}
//********** #FREJM 11 **************Dodavanje (Insertovanje) leka u bazu****************************************
	
public boolean UnosLeka (Lek lek){
	
	PreparedStatement ps= null;
	
	try{
		Konekcija.getKonekcija().setAutoCommit(false);
		ps=(PreparedStatement) Konekcija.getKonekcija().prepareStatement("INSERT INTO lek (Proizvodjac_ID, Naziv_leka, Jacina) VALUES (?, ?, ?) ");
		
		ps.setInt(1, lek.getProizvodjacID());
		ps.setString(2, lek.getNazivLeka());
		ps.setString(3, lek.getJacina());
		ps.executeUpdate();
		
		Konekcija.getKonekcija().commit();
		
		return true;
		
	}catch(Exception e){
		e.printStackTrace();
		return false;
		
	}finally{
		
		try {
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}}
		
}
	
//********** #FREJM 3/#FREJM5/#FREJM 8/#FREJM10 **********Uslovno ubacivanje spiska Naziva mesta na osnovu Naziva regiona u combobox******************************************
	public static Vector<Mesto> SpisakNazivaMesta(int RegionID)
	{
		Vector <Mesto> vectorMesto = new Vector<Mesto>();
		Statement st=null;
		ResultSet rs=null;
		
		try{
			st=Konekcija.getKonekcija().createStatement();
			rs=st.executeQuery("SELECT Naziv_mesta FROM mesto WHERE Region_ID='"+ RegionID + "' ORDER BY Naziv_mesta ASC");
			Mesto mesto=null; //definise se promenljiva
			
			while(rs.next()){
				mesto = new Mesto();		//ovde se kreira objekat
				mesto.setNazivMesta(rs.getString(1).toString());
				vectorMesto.add(mesto);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		
		
		return vectorMesto;
	}
//********** #FREJM 8/#FREJM10 **********Ubacivanje spiska Zvanja u combobox******************************************

	public static Vector<Zvanje> SpisakZvanja(){
		
		Vector<Zvanje> vectorZvanje = new Vector<Zvanje>();			// kreira se vektor koji ce primiti vrednosti 
		
		Statement st=null;											//statement koristimo posto nije potrebna parametarizacija
		ResultSet rs=null;											// ResultSet je potreban da bi omogucio izlistavanje rezultata
		
		try{
			st=Konekcija.getKonekcija().createStatement();			// kreira se statement i trazi konekcija
			rs=st.executeQuery("SELECT Zvanje from zvanje ORDER BY Zvanje ASC");		// izvrasava se upit
			
			Zvanje zvanje=null;									
			while (rs.next()){										// while petlja da se vrti dok god postoji sledeci resultat, odnosno sledeca torka u resultSetu
				
				zvanje= new Zvanje();								// kreira se novi objekat kako bi primio vrednost svaki put kada se pronadje rezultat
				zvanje.setZvanje(rs.getString(1));					// setuje se vrednost promenljive objekta u ovom slucaju zvanja 
				vectorZvanje.add(zvanje);							// dodaje se rezultat odnosno pronadjena torka u vektor kako bi se sacuvala 
				
			}}catch(Exception e){
				e.printStackTrace();								// prikazuje se greska ukoliko postoji
			}finally{
				try{
					rs.close();	
				}catch(SQLException e){								// prikazuje se greska SQL upita ukoliko postoji 
					e.printStackTrace();
				}
			}
			return vectorZvanje;									// vraca se vektor koji se sacuvao sve pronadjene i zahtevane vrednosti
		
	}
//********** #FREJM 11/#FREJM12/FREJM 13 **********Ubacivanje spiska Proizvodjaca u combobox******************************************
	public static Vector <Proizvodjac> SpisakProizvodjaca(){
		
		Vector<Proizvodjac> vectorProizvodjac = new Vector<Proizvodjac>();
		
		Statement st=null;
		ResultSet rs=null;
		
		try{
			st=Konekcija.getKonekcija().createStatement();
			rs=st.executeQuery("SELECT Naziv_proizvodjaca FROM proizvodjac ORDER BY Naziv_proizvodjaca ASC");
			
			Proizvodjac proizvodjac=null;
			while(rs.next()){
				proizvodjac= new Proizvodjac();
				proizvodjac.setNazivProizvodjaca(rs.getString(1).toString());
				vectorProizvodjac.add(proizvodjac);
			}}catch(Exception e){
				e.printStackTrace();
			}finally{
				try{
					rs.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
			
		return vectorProizvodjac;
		}
//********** #FREJM17 **********Ubacivanje spiska Lekova u combobox******************************************
	public static Vector<Lek> SpisakNazivaLekova(){
		
		Vector<Lek> vectorLek = new Vector<Lek>();
		
		Statement st=null;
		ResultSet rs=null;
		
		try{
			st=Konekcija.getKonekcija().createStatement();
			rs=st.executeQuery("SELECT Naziv_leka FROM lek ORDER BY Naziv_leka ASC");
			
			Lek lek=null;
			while(rs.next()){
				lek= new Lek();
				lek.setNazivLeka(rs.getString(1).toString());
				vectorLek.add(lek);
			}

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			}try{
				rs.close();
			}catch(SQLException e){
				e.printStackTrace();
			}	
			return vectorLek;
	}
//********** #FREJM4/#FREJM6 **********Ubacivanje spiska Pacijenata u combobox******************************************
	public static Vector<Pacijent> SpisakPacijenata(){
		
		Vector<Pacijent> vectorPacijent= new Vector<Pacijent>();
		
		Statement st=null;
		ResultSet rs=null;
		
		try{
			st=Konekcija.getKonekcija().createStatement();
			rs=st.executeQuery("SELECT Jmbg_pacijent, Ime_oca, Ime, Prezime FROM pacijent");
			
			Pacijent pacijent= null;
			while(rs.next()){
				pacijent= new Pacijent();
				pacijent.setJmbgPacijent(rs.getString(1).toString());
				pacijent.setIme(rs.getString(3).toString());
				pacijent.setImeOca(rs.getString(2).toString());
				pacijent.setPrezime(rs.getString(4).toString());
				
				vectorPacijent.add(pacijent);
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			}try{
				rs.close();
			}catch(SQLException e){
				e.printStackTrace();
			}	
			return vectorPacijent;
	}
//********** #FREJM9 **********Ubacivanje spiska Lekara u combobox******************************************

	public static Vector<Lekar> SpisakLekara(){
		
		Vector<Lekar> vectorLekar= new Vector<Lekar>();
		
		Statement st=null;
		ResultSet rs=null;
		
		try{
			st=Konekcija.getKonekcija().createStatement();
			rs=st.executeQuery("SELECT Jmbg_lekar, Ime, Prezime FROM lekar");
			
			Lekar lekar= null;
			while(rs.next()){
				lekar= new Lekar();
				lekar.setJmbgLekar(rs.getString(1).toString());
				lekar.setIme(rs.getString(2).toString());
				lekar.setPrezime(rs.getString(3).toString());
				
				vectorLekar.addElement(lekar);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			}try{
				rs.close();
			}catch(SQLException e){
				e.printStackTrace();
			}	
			return vectorLekar;
		
	}
//********** FREJM16 **********Ubacivanje spiska Zdravstvenih ustanova u combobox******************************************
public static Vector<ZdravstvenaUstanova> SpisakZdravstvenihUstanova(){
		
		Vector<ZdravstvenaUstanova> vektorUstanova= new Vector<ZdravstvenaUstanova>();
		
		Statement st=null;
		ResultSet rs=null;
		
		try{
			st=Konekcija.getKonekcija().createStatement();
			rs=st.executeQuery("SELECT Naziv_zdravstvene_ustanove FROM zdravstvena_ustanova ORDER BY Naziv_zdravstvene_ustanove DESC");
			
			ZdravstvenaUstanova zdravstvenaUstanova= null;
			while(rs.next()){
				zdravstvenaUstanova= new ZdravstvenaUstanova();
				zdravstvenaUstanova.setNazivZdravstveneUstanove(rs.getString(1));
				
				vektorUstanova.addElement(zdravstvenaUstanova);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			}try{
				rs.close();
			}catch(SQLException e){
				e.printStackTrace();
			}	
			return vektorUstanova;
		}

//********** #FREJM3/#FREJM5/#FREM8/FREJM10 **********Ubacivanje spiska Regiona u combobox******************************************

public static Vector<Region> SpisakRegiona() {
	
	Vector<Region> vectorRegion = new Vector<Region>();
	
	Statement st=null;
	ResultSet rs=null;
	
	try{
		st=Konekcija.getKonekcija().createStatement();
		rs=st.executeQuery("SELECT Naziv_regiona FROM region ORDER BY Naziv_regiona ASC");
		
		Region region=null;
		while (rs.next()){
			region = new Region();
			region.setNazivRegiona(rs.getString(1).toString());
			vectorRegion.add(region);
		}
	}catch(Exception e){
		e.printStackTrace();
	}finally {
		}try{
			rs.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	
	
	return vectorRegion;
}


//********** #FREJM1 **********#Logovanje lekara******************************************
	
public boolean Logovanje (Lekar lekar){
	
	PreparedStatement ps= null;																	// prepared statement zato sto se koristi parametar 
	ResultSet rs=null;
	int Brojac = 0;
	
	try{
		Konekcija.getKonekcija().setAutoCommit(false);											// trazi se konekcija 
		ps=(PreparedStatement) Konekcija.getKonekcija().prepareStatement("SELECT Korisnicko_ime, Sifra FROM lekar WHERE Korisnicko_ime=? and Sifra=?");	 //kreira se  prepared statement
		
		ps.setString(1, lekar.getKorisnicnoIme());											// setuju se vrednosti koje su prosledjene sa forme kako bi se selektovale u bazi ukoliko postoje 
		ps.setInt(2, lekar.getSifra());
		
		rs=ps.executeQuery();																// izvrsava se upit 
		
		while(rs.next()){																	// pomocu resultseta proverava se da li je selektovana neka vrednost po zadatim kriterijumima
			Brojac++;																		// ukoliko jeste to znaci da korisnicko ime kao i sifra postoje u bazi
		} 
		if (Brojac>0){
				return true;																// vraca se vrednost true
		}else {
			return false;																	// u suprotnom vraca se vrednost false
		}
		
		
	}catch(Exception e){
		e.printStackTrace();
		return false;
	}finally{
		try{
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
}


//********** #FREJM3/#FREJM5/#FREJM8/FREJM10 **********Vracanje RegionID-ja na osnovu prosledjenog Naziva Mesta******************************************
 public static String VracanjeRegionID (String NazivMesta){
	 
	 PreparedStatement ps=null;
	 ResultSet rs=null;
	 
	 try {
		Konekcija.getKonekcija().setAutoCommit(false);
		ps=(PreparedStatement) Konekcija.getKonekcija().prepareStatement("SELECT Region_ID FROM region WHERE Naziv_regiona='" + NazivMesta + "'");
	
		rs=ps.executeQuery();
		
		String RegionID = null;
		while(rs.next()){
			RegionID= rs.getString(1).toString();
		}
		return RegionID;
	 } catch (Exception e) {
		e.printStackTrace();
	}
	return "";
	 
 }


//********** #FREJM6 **********Pravljenje spiska usluga za Pregled ******************************************************************************

public static Vector<Usluga> SpisakUsluga(){
	
	Vector<Usluga> VektorUsluge= new Vector<Usluga> ();
	Statement st=null;
	ResultSet rs=null;
	
	try{
		st=Konekcija.getKonekcija().createStatement();
		rs=st.executeQuery("SELECT Naziv_usluge	FROM usluga ORDER BY Naziv_usluge ASC");
		
		Usluga usluga=null;
		while(rs.next()){
			usluga = new Usluga();
			usluga.setNazivUsluge(rs.getString(1).toString());;
			VektorUsluge.addElement(usluga);
		}
		
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	return VektorUsluge;
}

//********** #FREJM6 **********Pravljenje spiska bolesti za Pregled ******************************************************************************
public static Vector<Bolest> SpisakBolesti (){
	
	Vector<Bolest>	VektorBolest= new Vector<Bolest>();
	
	Statement st=null;
	ResultSet rs=null;
	
	try{
		st=Konekcija.getKonekcija().createStatement();
		rs=st.executeQuery("SELECT Naziv_bolesti FROM bolest ORDER BY Naziv_bolesti ASC");
		
		Bolest bolest=null;
		
		while(rs.next()){
			bolest=new Bolest();
			bolest.setNazivBolesti(rs.getString(1).toString());
			VektorBolest.addElement(bolest);
		}
	}catch(Exception e){
		e.printStackTrace();
	}
	finally {
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return VektorBolest;
	
	}
//********** #FREJM4/#FREJM6 **********Selektovanje podataka o izabranom pacijentu za azuriranje *****************************************
	public Pacijent SelektovanjePacijenta(Pacijent pac){
		
		Statement st=null;
		ResultSet rs=null;
		
		try{
			st=Konekcija.getKonekcija().createStatement();
			rs=st.executeQuery("SELECT Jmbg_pacijent, PTT, Ime_oca, Ime, Prezime, Broj_telefona, Ulica_i_broj, Broj_zdravstvene_knjizice FROM pacijent WHERE Jmbg_pacijent='" + pac.getJmbgPacijent() + "'");
			
			
			while(rs.next()){
				pac.setJmbgPacijent(rs.getString(1));
				pac.setPTT(rs.getInt(2));
				pac.setImeOca(rs.getString(3));
				pac.setIme(rs.getString(4));
				pac.setPrezime(rs.getString(5));
				pac.setBrojTelefona(rs.getString(6));
				pac.setUlicaiBroj(rs.getString(7));
				pac.setBrojZdravstveneKnjizice(rs.getInt(8));
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return pac;
	}
//********** #FREJM5 **********Azuriranje podataka o pacijentu ********************************************************
public boolean AzuriranjePacijenta (Pacijent AzuriranPacijent){
	
	PreparedStatement ps=null;
	
	try {
		Konekcija.getKonekcija().setAutoCommit(false);
		ps=(PreparedStatement) Konekcija.getKonekcija().prepareStatement("UPDATE pacijent SET PTT=?, Ime_oca= ?, Ime= ?, Prezime= ?, Broj_telefona= ?, Ulica_i_broj= ?, Broj_zdravstvene_knjizice= ? WHERE Jmbg_Pacijent='" + AzuriranPacijent.getJmbgPacijent() + "' ");
		
		ps.setInt(1, AzuriranPacijent.getPTT());
		ps.setString(2, AzuriranPacijent.getImeOca());
		ps.setString(3, AzuriranPacijent.getIme());
		ps.setString(4, AzuriranPacijent.getPrezime());
		ps.setString(5, AzuriranPacijent.getBrojTelefona());
		ps.setString(6, AzuriranPacijent.getUlicaiBroj());
		ps.setInt(7, AzuriranPacijent.getBrojZdravstveneKnjizice());
		
		
		
		ps.executeUpdate();
		
		Konekcija.getKonekcija().commit();
		
		
		return true;
	} catch (Exception e) {
		e.printStackTrace();
		return false;
	}finally{
		
	}
	
}
//**********FREJM12*************Selektovanje odabranog leka za azuriranje iz baze podataka***************************
public Lek SelektovanjeLekaZaAzuriranje(Lek lek){
	
	Statement st=null;
	ResultSet rs=null;
	
	try {
		st=Konekcija.getKonekcija().createStatement();
		rs=st.executeQuery("SELECT Lek_ID, Jacina FROM lek WHERE Naziv_leka='"+lek.getNazivLeka()+"' and Proizvodjac_ID='"+lek.getProizvodjacID()+"'");
		
		while(rs.next()){
			lek.setLekID(rs.getInt(1));
			lek.setJacina(rs.getString(2).toString());
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		try{
		rs.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	return lek;
}
//********** #FREJM5/#FREJM10 **********Uzimanje naziva mesta na osnovu prosledjenog PTT-a Azuriranje podataka o pacijentu ********************************************************
public static String VracanjeNazivaMestaNaOsnovuPTT (int PTT){
	
	Statement st=null;
	ResultSet rs=null;
	
	try{
		st=Konekcija.getKonekcija().createStatement();
		rs=st.executeQuery("SELECT Naziv_mesta FROM mesto WHERE PTT='" + PTT + "'");
		
		
		while(rs.next()){
			return rs.getString(1);
			
		}
				
	}catch(Exception e){
		e.printStackTrace();
	}finally {
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return null;
}
//********** #FREJM5/#FREJM10 ********** Vracanje Regiona ID na osnovu prosdjenog PTT ********************************************************
public static int SelektovanjeRegionID (int PTT){
	 
	 PreparedStatement ps=null;
	 ResultSet rs=null;
	 
	 try {
		Konekcija.getKonekcija().setAutoCommit(false);
		ps=(PreparedStatement) Konekcija.getKonekcija().prepareStatement("SELECT Region_ID FROM mesto WHERE PTT='" + PTT + "'");
	
		rs=ps.executeQuery();
		
		int RegionID = 0;
		while(rs.next()){
			RegionID= rs.getInt(1);
		}
		return RegionID;
	 } catch (Exception e) {
		e.printStackTrace();
	}
	return 0;
	 
}
//********** #FREJM5/#FREJM10 ********** Vracanje Naziva regiona na osnovu prosledjenog ID-ja  ********************************************************
public static String SelektovanjeNazivaRegionaNaOsnovuID (int RegionID){
	 
	 PreparedStatement ps=null;
	 ResultSet rs=null;
	 
	 try {
		Konekcija.getKonekcija().setAutoCommit(false);
		ps=(PreparedStatement) Konekcija.getKonekcija().prepareStatement("SELECT Naziv_regiona FROM region WHERE Region_ID='" + RegionID + "'");
	
		rs=ps.executeQuery();
		
		String PocetniNazivRegiona = null;
		while(rs.next()){
			PocetniNazivRegiona= rs.getString(1);
		}
		return PocetniNazivRegiona;
	 } catch (Exception e) {
		e.printStackTrace();
	}
	return "";
	 
}
//********** FREJM1 ********** #Vracanje Naziva regiona na osnovu prosledjenog ID-ja  ********************************************************
public static String SelektovanjeJmbgLekara(String KorisnickoIme, int Sifra) {
	
	Statement st=null;
	ResultSet rs=null;
	
	try {
		st = Konekcija.getKonekcija().createStatement();
		rs=st.executeQuery("SELECT Jmbg_lekar FROM lekar WHERE Korisnicko_ime='"+ KorisnickoIme +"' and Sifra='" + Sifra + "'");
		
		String JmbgLekar=null;
		while(rs.next()){
			JmbgLekar=rs.getString(1).toString();
			
		} 
		return JmbgLekar;
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
		return "";}
//********** #FREJM9 ********** Selektovanje lekara za azuriranje  ********************************************************

public Lekar SelektovanjeLekara(Lekar dr){
	
	Statement st=null;
	ResultSet rs=null;
	
		Lekar lekar = new Lekar();
	
	try{
		st=Konekcija.getKonekcija().createStatement();
		rs=st.executeQuery("SELECT Jmbg_lekar, PTT, Zvanje_ID, Ime, Prezime, Korisnicko_ime, Sifra, Ulica_i_broj, Broj_telefona FROM lekar WHERE Jmbg_lekar='"+ dr.getJmbgLekar() +"'");
		
		
		while(rs.next()){
			
			lekar.setJmbgLekar(rs.getString(1));
			lekar.setPTT(rs.getInt(2));
			lekar.setZvanjeID(rs.getInt(3));
			lekar.setIme(rs.getString(4));
			lekar.setPrezime(rs.getString(5));
			lekar.setKorisnicnoIme(rs.getString(6));
			lekar.setSifra(rs.getInt(7));
			lekar.setUlicaiBroj(rs.getString(8));
			lekar.setBrojTelefona(rs.getString(9));
		}
		
		
	}catch(Exception e){
		e.printStackTrace();
	}finally {
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return lekar;
}
//********** #FREJM10********** Vracanje ZvanjaID na osnovu Jmbg   *********************************************************************************

public static int VracanjeZvanjaIDnaOsnovuJmbg (String JMBG){
	 
	 PreparedStatement ps=null;
	 ResultSet rs=null;
	 
	 try {
		Konekcija.getKonekcija().setAutoCommit(false);
		ps=(PreparedStatement) Konekcija.getKonekcija().prepareStatement("SELECT Zvanje_ID FROM lekar WHERE Jmbg_lekar='" + JMBG + "'");
	
		rs=ps.executeQuery();
		
		int ZvanjeID = 0;
		while(rs.next()){
			ZvanjeID= rs.getInt(1);
		}
		return ZvanjeID;
	 } catch (Exception e) {
		e.printStackTrace();
	}
	return 0;
	 
}
//********** #FREJM10********** Vracanje Naziva zvanje na osnovu ZvanjaID   *********************************************************************************
public static String SelektovanjeZvanjanaOsnovuZvanjeID (int ZvanjeID){
	
	Statement st=null;
	ResultSet rs=null;
	
	try{
		st=Konekcija.getKonekcija().createStatement();
		rs=st.executeQuery("SELECT Zvanje FROM zvanje WHERE Zvanje_ID='" + ZvanjeID + "'");
		
		String Naziv_zvanje=null;
		while(rs.next()){
			Naziv_zvanje=rs.getString(1);
			
		}
		return Naziv_zvanje;
				
	}catch(Exception e){
		e.printStackTrace();
	}finally {
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return null;
}
//********** #FREJM10**********Selektovanje Zvanja ID na osnovu Naziva zvanja iz baze za Azuriranje lekara****************************************
	public static String SelektovanjeIDZvanjaNaOsnovuNazivaZvanja (String NazivZvanja){
		
		
		
		ResultSet rs=null;
		PreparedStatement ps= null;
		
		
		try {
			Konekcija.getKonekcija().setAutoCommit(false);
			
			ps=(PreparedStatement) Konekcija.getKonekcija().prepareStatement("SELECT Zvanje_ID FROM zvanje WHERE Zvanje='" + NazivZvanja + "'");
			
			rs=ps.executeQuery();
			
			String Zvanje="";
			while (rs.next()){							// radi i sa while i sa if obicno bez toga se desava da prijavi gresku 
				Zvanje=rs.getString(1).toString();
			}
			return Zvanje;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "";
	} 
	//********** #FREJM10 **********Azuriranje podataka o lekaru ********************************************************
	public boolean AzuriranjeLekara (Lekar AzuriranLekar){
		
		PreparedStatement ps=null;
		
		try {
			Konekcija.getKonekcija().setAutoCommit(false);
			ps=(PreparedStatement) Konekcija.getKonekcija().prepareStatement("UPDATE lekar SET PTT= ?, Zvanje_ID=?, Ime= ?, Prezime= ?, Korisnicko_ime= ?, Sifra= ?, Ulica_i_broj= ?, Broj_telefona= ?  WHERE Jmbg_lekar='" + AzuriranLekar.getJmbgLekar() + "' ");
			
			ps.setInt(1, AzuriranLekar.getPTT());
			ps.setInt(2, AzuriranLekar.getZvanjeID());
			ps.setString(3, AzuriranLekar.getIme());
			ps.setString(4, AzuriranLekar.getPrezime());
			ps.setString(5, AzuriranLekar.getKorisnicnoIme());
			ps.setInt(6, AzuriranLekar.getSifra());
			ps.setString(7, AzuriranLekar.getUlicaiBroj());
			ps.setString(8, AzuriranLekar.getBrojTelefona());
			
			
			ps.executeUpdate();
			
			Konekcija.getKonekcija().commit();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
		}
		
	}
//********** #FREJM6 **********Evidentiranje pregleda onosno unos pregleda ********************************************************
public boolean EvidentiranjePregelda(Pregled pregled){
	
	PreparedStatement ps=null;
	
	
	try{
		Konekcija.getKonekcija().setAutoCommit(false);
		ps=(PreparedStatement) Konekcija.getKonekcija().prepareStatement("INSERT INTO pregled (Pregled_ID, Jmbg_pacijent, Jmbg_lekar, Datum_pregleda ) VALUES (?, ?, ?, ?)");
		
		ps.setInt(1, pregled.getPregledID());
		ps.setString(2, pregled.getJmbgPacijent());
		ps.setString(3, pregled.getJmbgLekar());
		ps.setDate(4, pregled.getDatumPregleda());
		
		
		ps.executeUpdate();
		
		Konekcija.getKonekcija().commit();
		
		return true;
	}catch(Exception e){
		e.printStackTrace();
		return false;
	}
	finally{
		try{
			ps.close();
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
}
//********** #FREJM6 **********Evidentiranje dijagnoze onosno unos dijagnoze ********************************************************
public boolean EvidentiranjeDijagnoze(Dijagnoza dijagnoza){
	
	PreparedStatement ps=null;
	
	
	try{
		Konekcija.getKonekcija().setAutoCommit(false);
		ps=(PreparedStatement) Konekcija.getKonekcija().prepareStatement("INSERT INTO dijagnoza (Pregled_ID, Redni_broj, Bolest_ID) VALUES (?, ?, ?)");
		
		ps.setInt(1, dijagnoza.getPregledID());
		ps.setInt(2, dijagnoza.getRedniBroj());
		ps.setInt(3, dijagnoza.getBolestID());
		
		
		
		ps.executeUpdate();
		
		Konekcija.getKonekcija().commit();
		
		return true;
	}catch(Exception e){
		e.printStackTrace();
		return false;
	}
	finally{
		try{
			ps.close();
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
}
//********** #FREJM6 **********Vracanje Bolesti ID na osnovu prosledjenog NazivaBolesti ********************************************************
public static int VracanjeBolestID (String NazivBolesti){
	 
	 PreparedStatement ps=null;
	 ResultSet rs=null;
	 
	 try {
		Konekcija.getKonekcija().setAutoCommit(false);
		ps=(PreparedStatement) Konekcija.getKonekcija().prepareStatement("SELECT Bolest_ID FROM bolest WHERE Naziv_bolesti='" + NazivBolesti + "'");
	
		rs=ps.executeQuery();
		
		int BolestID = 0;
		while(rs.next()){
			BolestID= rs.getInt(1);
		}
		
		return BolestID;
	 } catch (Exception e) {
		e.printStackTrace();
	}
	return 0;
	 
}
//********** #FREJM6 **********Provera da li je bolest izleciva u nasoj zdravstvenoj ustanovi ako ne izdaje se uput ********************************************************
public static boolean ProveraIzlecivosti (int bolestID){
	 
	 PreparedStatement ps=null;
	 ResultSet rs=null;
	 
	 try {
		Konekcija.getKonekcija().setAutoCommit(false);
		ps=(PreparedStatement) Konekcija.getKonekcija().prepareStatement("SELECT Moguce_pruzanje_zdravstvenih_usluga FROM bolest WHERE Bolest_ID='" + bolestID + "'");
	
		rs=ps.executeQuery();
		
		int Izlecivo=0;
		while(rs.next()){
			Izlecivo=Integer.parseInt(rs.getString(1).toString());
			
		}
		if(Izlecivo == 1)
			return true;
		
	 } catch (Exception e) {
		e.printStackTrace();
	}
	return false;

}
//********** #FREJM6 ********** Selektovanje PregledID-ja kako bi se ubacivale dijagnoza i izvrsene usluge ********************************************************

public static int SelektovanjePregledID(java.sql.Date trenutniDatum, String jmbgIzabranogPacijenta) {
	
	Statement st=null;
	ResultSet rs=null;
	
	try {
		st=Konekcija.getKonekcija().createStatement();
		rs=st.executeQuery("SELECT Pregled_ID from pregled WHERE Jmbg_pacijent='" + jmbgIzabranogPacijenta + "' and Datum_pregleda='" + trenutniDatum + "' ");
		
			
			int PregledID=0;
			
			while(rs.next()){
			
			PregledID=rs.getInt(1);
			}
			return PregledID;
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return 0;
}
//********** #FREJM6 ********** Metoda za pravljenje Jtable i za ubacivanje u nju ********************************************************
// u ovaj metod se prosledi rezultat iz selekta i na osnovu njega se kreiraju kolone i redovi odnosno na osnovu rezultata
// zatim se taj metod vrcaca sa podacima i nazivima kolona

public static DefaultTableModel PravljenjeTabeleZaPregled(ResultSet rs)
        throws SQLException {

    ResultSetMetaData metaData = rs.getMetaData();

    // names of columns
    Vector<String> columnNames = new Vector<String>();
    int columnCount = metaData.getColumnCount();
    for (int column = 1; column <= columnCount; column++) {
        columnNames.add(metaData.getColumnName(column));
        //columnNames.add(metaData.getColumnName(column));
    }

    // data of the table
    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
    while (rs.next()) {
        Vector<Object> vector = new Vector<Object>();
        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
            vector.add(rs.getObject(columnIndex));
        }
        data.add(vector);
    }

    return new DefaultTableModel(data, columnNames);

}

//********** #FREJM6 ********** Selektovanje bolesti i prosledjivanje u metod koji pravi kolone i daje im nazive i zatim vraca iste podatke ********************************************************

public static DefaultTableModel SelektovanjeBolestiZaTabelu(int pregledID) {
	Statement st=null;
	ResultSet rs=null;
	
	try {
		st=Konekcija.getKonekcija().createStatement();
		rs=st.executeQuery("SELECT DISTINCT Naziv_bolesti FROM bolest b,dijagnoza d, pregled p WHERE b.Bolest_ID=d.Bolest_ID and p.Pregled_ID=d.Pregled_ID and p.Pregled_ID=" + pregledID + "");
		
		
		return PravljenjeTabeleZaPregled(rs);
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return null;
}
//********** #FREJM6 **********Selektovanje Imena i Prezimena lekara ********************************************************
public static String SelektovanjeImenaILekara(String jmbgLekar) {
	
	Statement st=null;
	ResultSet rs=null;
	
	try {
		st=Konekcija.getKonekcija().createStatement();
		rs=st.executeQuery("SELECT Ime FROM lekar WHERE Jmbg_lekar='" + jmbgLekar + "' ");
	
		String Ime=null;
		while (rs.next()) {
			Ime=rs.getString(1).toString();		
		}
		return Ime;
	} catch (Exception e) {
		e.printStackTrace();
	}
	return "";
}
//********** #FREJM6 **********Selektovanje Prezimena lekara ********************************************************
public static String SelektovanjePrezimenaILekara(String jmbgLekar) {
	
	Statement st=null;
	ResultSet rs=null;
	
	try {
		st=Konekcija.getKonekcija().createStatement();
		rs=st.executeQuery("SELECT Prezime FROM lekar WHERE Jmbg_lekar='" + jmbgLekar + "' ");
	
		String Prezime=null;
		while (rs.next()) {
			Prezime=rs.getString(1).toString();		
		}
		return Prezime;
	} catch (Exception e) {
		e.printStackTrace();
	}
	return "";
}
//********** #FREJM12 **********Uslovno ubacivanje spiska Naziva lekova na osnovu naziva proizvodjaca odnsno ID-ja proizvodjaca ********************************************************
public static Vector<Lek> SpisakUslovnihNazivaLekova(int ProizvodjacID)
{
	Vector <Lek> VektorLek = new Vector<Lek>();
	Statement st=null;
	ResultSet rs=null;
	
	try{
		st=Konekcija.getKonekcija().createStatement();
		rs=st.executeQuery("SELECT Naziv_leka FROM lek WHERE Proizvodjac_ID='"+ ProizvodjacID + "' ORDER BY Naziv_leka ASC");
		
		Lek lek=null; //definise se promenljiva 
		while(rs.next()){
			lek = new Lek();		//ovde se kreira objekat
			lek.setNazivLeka(rs.getString(1).toString());
			VektorLek.add(lek);
		}
		
	}catch(SQLException e){
		e.printStackTrace();
	}
	
	
	
	return VektorLek;
}
//********* #FREJM12 **********Uslovno ubacivanje spiska Naziva lekova na osnovu naziva proizvodjaca odnsno ID-ja proizvodjaca ********************************************************
public static boolean AzuriranjeLeka(Lek LekAzuriranje) {
	
		PreparedStatement ps=null;
	
	try {
		Konekcija.getKonekcija().setAutoCommit(false);
		ps=(PreparedStatement) Konekcija.getKonekcija().prepareStatement("UPDATE lek SET Lek_ID= ?, Proizvodjac_ID= ?, Naziv_leka= ?, Jacina=? WHERE Lek_ID='" + LekAzuriranje.getLekID() + "' ");
		
		ps.setInt(1, LekAzuriranje.getLekID());
		ps.setInt(2, LekAzuriranje.getProizvodjacID());
		ps.setString(3, LekAzuriranje.getNazivLeka());
		ps.setString(4, LekAzuriranje.getJacina());
		
		
		ps.executeUpdate();
		
		Konekcija.getKonekcija().commit();
		
		return true;
	} catch (Exception e) {
		e.printStackTrace();
		return false;
	}finally{
	}
	
}

//********* #FREJM6 *********Vracanje usluge ID na osnovu naziva usluge ********************************************************
public static int SlektovanjeUslugeID (String NazivUsluge){
	 
	 PreparedStatement ps=null;
	 ResultSet rs=null;

	 
	 try {
		Konekcija.getKonekcija().setAutoCommit(false);
		ps=(PreparedStatement) Konekcija.getKonekcija().prepareStatement("SELECT Usluga_ID FROM usluga WHERE Naziv_usluge='" + NazivUsluge + "'");
	
		rs=ps.executeQuery();
		
		
		int UslugaID = 0;
		while(rs.next()){
			UslugaID= rs.getInt(1);
		}
		return UslugaID;
	 } catch (Exception e) {
		e.printStackTrace();
	}
	return 0;
	 
}
//********* #FREJM6 *********Vracanje Cena usluge na osnovu Uluge ID  ********************************************************

public static int SelektovanjeCene (int uslugaID){
	 
	 PreparedStatement ps=null;
	 ResultSet rs=null;
	
	 try {
		Konekcija.getKonekcija().setAutoCommit(false);
		ps=(PreparedStatement) Konekcija.getKonekcija().prepareStatement("SELECT Cena FROM usluga WHERE Usluga_ID='" + uslugaID + "'");
	
		rs=ps.executeQuery();
		
		int CenaUsluge = 0;
		while(rs.next()){
			CenaUsluge= rs.getInt(1);
			
		}
		
		return CenaUsluge;
	 } catch (Exception e) {
		e.printStackTrace();
	}
	return 0;
	 
}
//********* #FREJM6 *********Vracanje Cena usluge na osnovu Uluge ID  ********************************************************
public static boolean EvidentiranjeUsluga(IzvrseneUsluge izvrseneUsluge){
	
	PreparedStatement ps=null;
	
	
	try{
		Konekcija.getKonekcija().setAutoCommit(false);
		ps=(PreparedStatement) Konekcija.getKonekcija().prepareStatement("INSERT INTO izvrsene_usluge (Pregled_ID, Redni_broj, Usluga_ID) VALUES (?, ?, ?)");
		
		ps.setInt(1, izvrseneUsluge.getPregledID());
		ps.setInt(2, izvrseneUsluge.getRedniBroj());
		ps.setInt(3, izvrseneUsluge.getUslugaID());
		
		
		ps.executeUpdate();
		
		Konekcija.getKonekcija().commit();
		
		return true;
	}catch(Exception e){
		e.printStackTrace();
		return false;
	}
	finally{
		try{
			ps.close();
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
}
//********* #FREJM6 *********Metoda za elektronski karton u ubacivanje u tabelu  ********************************************************
public static DefaultTableModel SelektovanjeBolestiZaIstorijatLecenja(String jmbgPacijenta) {
	Statement st=null;
	ResultSet rs=null;
	
	try {
		st=Konekcija.getKonekcija().createStatement();
		rs=st.executeQuery("SELECT DISTINCT b.Naziv_bolesti, p.Datum_pregleda FROM pacijent pac, pregled p, dijagnoza d, bolest b where pac.Jmbg_pacijent='" + jmbgPacijenta + "' and pac.Jmbg_pacijent=p.Jmbg_pacijent and p.Pregled_ID=d.Pregled_ID and d.Bolest_ID=b.Bolest_ID ORDER BY p.Datum_pregleda DESC");
		
		
		return PravljenjeTabeleZaPregled(rs);
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return null;
}
//********* #FREJM17 *********Selektovanje LekID-ja na osnovu naziva leka za unos Recepta ********************************************************
public static int SelektovanjeLekIDnaOsnovuNazivaLeka (String nazivLeka){
	 
	 PreparedStatement ps=null;
	 ResultSet rs=null;
	 
	 try {
		Konekcija.getKonekcija().setAutoCommit(false);
		ps=(PreparedStatement) Konekcija.getKonekcija().prepareStatement("SELECT Lek_ID FROM lek WHERE Naziv_leka='" + nazivLeka + "'");
	
		rs=ps.executeQuery();
		
		int LekID = 0;
		while(rs.next()){
			LekID= rs.getInt(1);
		}
		return LekID;
	 } catch (Exception e) {
		e.printStackTrace();
	}
	return 0;
	 
}
//********* #FREJM17 *********Evidentiranje Recepta u bazu podataka  ********************************************************
public boolean EvidentiranjeRecepta(Recept recept){
	
	PreparedStatement ps=null;
	
	
	try{
		Konekcija.getKonekcija().setAutoCommit(false);
		ps=(PreparedStatement) Konekcija.getKonekcija().prepareStatement("INSERT INTO recept (Lek_ID, Pregled_ID) VALUES (?, ?)");
		
		ps.setInt(1, recept.getLekID());
		ps.setInt(2, recept.getPregledID());
		
		ps.executeUpdate();
		
		Konekcija.getKonekcija().commit();
		
		return true;
	}catch(Exception e){
		e.printStackTrace();
		return false;
	}
	finally{
		try{
			ps.close();
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
}
//********* #FREJM16 *********Selektovanje ID zdravstvene ustanove za unos Uputa  ********************************************************
public static int SelektovanjeZdrIDnaOsnovuNazivaZdrUstanove (String NazivZdrUstanoveZaKojuSeIzdajeUput){
	 
	 PreparedStatement ps=null;
	 ResultSet rs=null;
	 
	 try {
		Konekcija.getKonekcija().setAutoCommit(false);
		ps=(PreparedStatement) Konekcija.getKonekcija().prepareStatement("SELECT Zdravstvena_ustanova_ID FROM zdravstvena_ustanova WHERE Naziv_zdravstvene_ustanove='" + NazivZdrUstanoveZaKojuSeIzdajeUput + "'");
	
		rs=ps.executeQuery();
		
		int ZdrID = 0;
		while(rs.next()){
			ZdrID= rs.getInt(1);
		}
		return ZdrID;
	 } catch (Exception e) {
		e.printStackTrace();
	}
	return 0;
	 
}
//********* #FREJM16 *********Evidentiranje Uputa u bazu podataka  ********************************************************
public boolean EvidentiranjeUputa(Uput uput){
	
	PreparedStatement ps=null;
	
	
	try{
		Konekcija.getKonekcija().setAutoCommit(false);
		ps=(PreparedStatement) Konekcija.getKonekcija().prepareStatement("INSERT INTO uput (Zdravstvena_ustanova_ID, Pregled_ID) VALUES (?, ?)");
		
		ps.setInt(1, uput.getZdravstvenaUstanovaID());
		ps.setInt(2, uput.getPregledID());
		
		ps.executeUpdate();
		
		Konekcija.getKonekcija().commit();
		
		return true;
	}catch(Exception e){
		e.printStackTrace();
		return false;
	}
	finally{
		try{
			ps.close();
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
}
//********* #FREJM6 *********Evidentiranje Uputa u bazu podataka  ********************************************************
public boolean EvidentiranjeStavkeFakture(StavkaFakture stavkaFakture){
	
	PreparedStatement ps=null;
	
	
	try{
		Konekcija.getKonekcija().setAutoCommit(false);
		ps=(PreparedStatement) Konekcija.getKonekcija().prepareStatement("INSERT INTO stavka_fakture (Faktura_ID, Redni_broj, Usluga_ID, Cena) VALUES (?, ?, ?, ?)");
		
		ps.setInt(1, stavkaFakture.getFakutraID());
		ps.setInt(2, stavkaFakture.getRedniBroj());
		ps.setInt(3, stavkaFakture.getUslugaID());
		ps.setInt(4, stavkaFakture.getCena());
		
		
		
		ps.executeUpdate();
		
		Konekcija.getKonekcija().commit();
		
		return true;
	}catch(Exception e){
		e.printStackTrace();
		return false;
	}
	finally{
		try{
			ps.close();
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
}
//********* #FREJM6 *********Evidentiranje pocetne fakture  ********************************************************
public boolean EvidentiranjeFakture(Faktura faktura){
	
	PreparedStatement ps=null;
	
	
	try{
		Konekcija.getKonekcija().setAutoCommit(false);
		ps=(PreparedStatement) Konekcija.getKonekcija().prepareStatement("INSERT INTO faktura (Pregled_ID, Iznos_fakture) VALUES (?, ?)");
		
		ps.setInt(1, faktura.getPregledID());
		ps.setInt(2, faktura.getIznosFakture());
		
		
		ps.executeUpdate();
		
		Konekcija.getKonekcija().commit();
		
		return true;
	}catch(Exception e){
		e.printStackTrace();
		return false;
	}
	finally{
		try{
			ps.close();
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
}
//********* #FREJM6 *********Selektovanje faktureID na osnovu Pregleda Id-ja ********************************************************
public static int SelektovanjeFaktureID (int PregledID){
	 
	 PreparedStatement ps=null;
	 ResultSet rs=null;
	 
	 try {
		Konekcija.getKonekcija().setAutoCommit(false);
		ps=(PreparedStatement) Konekcija.getKonekcija().prepareStatement("SELECT Faktura_ID FROM faktura WHERE Pregled_ID='" + PregledID + "'");
	
		rs=ps.executeQuery();
		
		int FakturaID = 0;
		while(rs.next()){
			FakturaID= rs.getInt(1);
		}
		return FakturaID;
	 } catch (Exception e) {
		e.printStackTrace();
	}
	return 0;
	 
}
//********** #FREJM6 ********** Selektovanje usluga i prosledjivanje u metod koji pravi kolone i daje im nazive i zatim vraca iste podatke  ********************************************************

public static DefaultTableModel SelektovanjeUslugaZaTabelu(int pregledID) {
	Statement st=null;
	ResultSet rs=null;
	
	try {
		st=Konekcija.getKonekcija().createStatement();
		rs=st.executeQuery("SELECT DISTINCT Naziv_usluge, Cena FROM usluga u, izvrsene_usluge iu, pregled p WHERE u.Usluga_ID=iu.Usluga_ID and p.Pregled_ID=iu.Pregled_ID and p.Pregled_ID='" + pregledID + "'");
		
		
		return PravljenjeTabeleZaPregled(rs);
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return null;
}
//********** #FREJM6 ***************************Metod za brisanje Dijagnoze   ********************************************************
public boolean BrisanjeDijagnoza(Pregled pregled) {
	
	String Upit = "DELETE FROM dijagnoza WHERE Pregled_ID=?";

	try {
		
		Konekcija.getKonekcija().setAutoCommit(false);
		Connection kon= Konekcija.getKonekcija();
		com.mysql.jdbc.PreparedStatement ps=(PreparedStatement) kon.prepareStatement(Upit);
		ps.setInt(1, pregled.getPregledID());
		
		int i=ps.executeUpdate();

		if (i>0){
			
		Konekcija.getKonekcija().commit();	
		Konekcija.getKonekcija().setAutoCommit(true);
		
		}
		return true;

		
	} catch (Exception e) {
		e.printStackTrace();
		return false;
	}
	
}
//********** #FREJM6 ***************************Metod za brisanje IzvrseneUsluge   ********************************************************
public boolean BrisanjeIzvrsenihUsluga(Pregled pregled) {
	
	String Upit = "DELETE FROM izvrsene_usluge WHERE Pregled_ID=?";

	try {
		
		Konekcija.getKonekcija().setAutoCommit(false);
		Connection kon= Konekcija.getKonekcija();
		com.mysql.jdbc.PreparedStatement ps=(PreparedStatement) kon.prepareStatement(Upit);
		ps.setInt(1, pregled.getPregledID());
		
		int i=ps.executeUpdate();

		if (i>0){
			
		Konekcija.getKonekcija().commit();	
		Konekcija.getKonekcija().setAutoCommit(true);
		
		}
		return true;

		
	} catch (Exception e) {
		e.printStackTrace();
		return false;
	}
	
}

//********** #FREJM6 ***************************Metod za brisanje Stavke fakture   ********************************************************
public boolean BrisanjeStavkiFakture(Faktura faktura) {
	
	String Upit = "DELETE FROM stavka_fakture WHERE Faktura_ID=?";

	try {
		
		Konekcija.getKonekcija().setAutoCommit(false);
		Connection kon= Konekcija.getKonekcija();
		com.mysql.jdbc.PreparedStatement ps=(PreparedStatement) kon.prepareStatement(Upit);
		ps.setInt(1, faktura.getFakturaID());
		
		int i=ps.executeUpdate();

		if (i>0){
			
		Konekcija.getKonekcija().commit();	
		Konekcija.getKonekcija().setAutoCommit(true);
		
		}
		return true;

		
	} catch (Exception e) {
		e.printStackTrace();
		return false;
	}
	
}

//********** #FREJM6 ***************************Metod za brisanje Fakture   ********************************************************
public boolean BrisanjeFakture(Pregled pregled) {
	
	String Upit = "DELETE FROM faktura WHERE Pregled_ID=?";

	try {
		
		Konekcija.getKonekcija().setAutoCommit(false);
		Connection kon= Konekcija.getKonekcija();
		com.mysql.jdbc.PreparedStatement ps=(PreparedStatement) kon.prepareStatement(Upit);
		ps.setInt(1, pregled.getPregledID());
		
		int i=ps.executeUpdate();

		if (i>0){
			
		Konekcija.getKonekcija().commit();	
		Konekcija.getKonekcija().setAutoCommit(true);
		
		}
		return true;

		
	} catch (Exception e) {
		e.printStackTrace();
		return false;
	}
	
}

//********** #FREJM6 ***************************Metod za brisanje Pregleda   ********************************************************
public boolean BrisanjePregleda(Pregled pregled) {
	
	String Upit = "DELETE FROM pregled WHERE Pregled_ID=?";

	try {
		
		Konekcija.getKonekcija().setAutoCommit(false);
		Connection kon= Konekcija.getKonekcija();
		com.mysql.jdbc.PreparedStatement ps=(PreparedStatement) kon.prepareStatement(Upit);
		ps.setInt(1, pregled.getPregledID());
		
		int i=ps.executeUpdate();

		if (i>0){
			
		Konekcija.getKonekcija().commit();	
		Konekcija.getKonekcija().setAutoCommit(true);
		
		}
		return true;

		
	} catch (Exception e) {
		e.printStackTrace();
		return false;
	}
	
}

//********** #FREJM7 ***************************Selektovanje podataka o Uslugama za tabelu istorijat lecanja********************************************************
public static DefaultTableModel SelektovanjeUslugaZaIstorijatLecenja(String jmbgPacijenta) {
	Statement st=null;
	ResultSet rs=null;
	
	try {
		st=Konekcija.getKonekcija().createStatement();
		rs=st.executeQuery("SELECT DISTINCT Naziv_usluge, Datum_pregleda FROM pacijent pac, pregled p, izvrsene_usluge iu, usluga u WHERE p.Jmbg_pacijent=pac.Jmbg_pacijent and p.Pregled_ID=iu.Pregled_ID and iu.Usluga_ID=u.Usluga_ID and pac.Jmbg_pacijent='" + jmbgPacijenta + "' ORDER BY p.Datum_pregleda DESC");
		
			
		return PravljenjeTabeleZaPregled(rs);
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return null;
}
//********** #FREJM15 ***************************Selektovanje podataka o Uslugama za tabelu istorijat lecanja********************************************************
public static int ObracunUkupnogIznosaFakture(int pregledID, int fakturaID) {
	Statement st=null;
	ResultSet rs=null;
	
	try {
		st=Konekcija.getKonekcija().createStatement();
		rs=st.executeQuery("SELECT SUM(Cena) FROM pregled p, stavka_fakture sf, faktura f WHERE p.Pregled_ID=f.Pregled_ID and sf.Faktura_ID=f.Faktura_ID and p.Pregled_ID='" + pregledID + "' and f.Faktura_ID='" + fakturaID + "'");
		
		int UkupanIznos=0;
		while (rs.next()) {
			UkupanIznos=rs.getInt(1);
			
		}
		return UkupanIznos;

	} catch (Exception e) {
		e.printStackTrace();
	}

	return 0;
}
//********** #FREJM16 ***************************Selektovanje Id-ja na osnovu naziva zdravstvene ustanove********************************************************
public static String SelektovanjeSifraZdravstveneUstanoveNaOsnovuNaziva (String NazivUstanoveZaKojuSeIzdajeUput){
	
	
	
	ResultSet rs=null;
	PreparedStatement ps= null;
	
	
	try {
		Konekcija.getKonekcija().setAutoCommit(false);
		
		ps=(PreparedStatement) Konekcija.getKonekcija().prepareStatement("SELECT Zdravstvena_ustanova_ID FROM zdravstvena_ustanova WHERE Naziv_zdravstvene_ustanove='" + NazivUstanoveZaKojuSeIzdajeUput + "'");
		
		rs=ps.executeQuery();
		
		String ZdrID="";
		while (rs.next()){							// radi i sa while i sa if obicno bez toga se desava da prijavi gresku 
			ZdrID=rs.getString(1).toString();
		}
		return ZdrID;
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return "";
} 
//********** #FREJM16 ***************************Selektovanje BrojaTelefona Lekara na njegovog Jmbg-a ********************************************************
public static String SelektovanjeBrojTelefona (String jmbgLekar){
	
	
	
	ResultSet rs=null;
	PreparedStatement ps= null;
	
	
	try {
		Konekcija.getKonekcija().setAutoCommit(false);
		
		ps=(PreparedStatement) Konekcija.getKonekcija().prepareStatement("SELECT Broj_telefona FROM lekar WHERE Jmbg_lekar='" + jmbgLekar + "'");
		
		rs=ps.executeQuery();
		
		String BrojTelefona="";
		while (rs.next()){							// radi i sa while i sa if obicno bez toga se desava da prijavi gresku 
			BrojTelefona=rs.getString(1).toString();
		}
		return BrojTelefona;
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return "";
} 
//********** #FREJM16 ***************************Selektovanje ZvanjaID Lekara na njegovog Jmbg-a ********************************************************
public static int SelektovanjeZvanjaIDnaOsnovuJmbga (String jmbgLekar){
	
	
	
	ResultSet rs=null;
	PreparedStatement ps= null;
	
	
	try {
		Konekcija.getKonekcija().setAutoCommit(false);
		
		ps=(PreparedStatement) Konekcija.getKonekcija().prepareStatement("SELECT Zvanje_ID FROM lekar WHERE Jmbg_lekar='" + jmbgLekar + "'");
		
		rs=ps.executeQuery();
		
		int ZvanjeID = 0;
		while (rs.next()){							// radi i sa while i sa if obicno bez toga se desava da prijavi gresku 
			ZvanjeID=rs.getInt(1);
		}
		return ZvanjeID;
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return 0;
} 
//********** #FREJM16 ***************************Selektovanje maksimalnog rednog broja bolesti ********************************************************
public static int SelektovanjeMaxRednogBrojBolesti (int pregledID){
	
	
	
	ResultSet rs=null;
	PreparedStatement ps= null;
	
	
	try {
		Konekcija.getKonekcija().setAutoCommit(false);
		
		ps=(PreparedStatement) Konekcija.getKonekcija().prepareStatement("SELECT MAX(Redni_broj) FROM dijagnoza WHERE Pregled_ID='" + pregledID + "'");
		
		rs=ps.executeQuery();
		
		int MaxRbr = 0;
		while (rs.next()){							// radi i sa while i sa if obicno bez toga se desava da prijavi gresku 
			MaxRbr=rs.getInt(1);
		}
		return MaxRbr;
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return 0;
} 
//********** #FREJM16 ***************************Selektovanje maksimalnog rednog broja bolesti ********************************************************
public static int SelektovanjeBolestiIDzaUput (int pregledID, int maxRedniBroj){
	
	
	
	ResultSet rs=null;
	PreparedStatement ps= null;
	
	
	try {
		Konekcija.getKonekcija().setAutoCommit(false);
		
		ps=(PreparedStatement) Konekcija.getKonekcija().prepareStatement("SELECT Bolest_ID FROM dijagnoza WHERE Pregled_ID='" + pregledID + "' and Redni_broj='" + maxRedniBroj +"'");
		
		rs=ps.executeQuery();
		
		int BolestID = 0;
		while (rs.next()){							// radi i sa while i sa if obicno bez toga se desava da prijavi gresku 
			BolestID=rs.getInt(1);
		}
		return BolestID;
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return 0;
} 
//********** #FREJM16 ***************************Selektovanje maksimalnog rednog broja bolesti ********************************************************

public static String SelektovanjeNazivaBolestiNaOsnovuIDBolesti(int BolestID) {
	
	Statement st=null;
	ResultSet rs=null;
	
	try {
		st = Konekcija.getKonekcija().createStatement();
		rs=st.executeQuery("SELECT Naziv_bolesti FROM bolest WHERE Bolest_ID='"+ BolestID +"'");
		
		String NazivBolesti=null;
		while(rs.next()){
			NazivBolesti=rs.getString(1).toString();
			
		} 
		return NazivBolesti;
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
		return "";}

//********** #FREJM15 ***************************Zakljucivanje ukunog iznosa faktura i ispostvaljanje fakture ********************************************************
public static boolean IspostavljanjeFakture(Faktura faktura) {
		
		PreparedStatement ps=null;
		try {
			Konekcija.getKonekcija().setAutoCommit(false);
			ps=(PreparedStatement) Konekcija.getKonekcija().prepareStatement("UPDATE faktura SET Iznos_fakture= ? WHERE Faktura_ID='" + faktura.getFakturaID() + "'");
			
			ps.setInt(1, faktura.getIznosFakture());
			
			ps.executeUpdate();
			
			Konekcija.getKonekcija().commit();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
		}
		
}
//********** #FREJM18a ***************************Metod broj odabljenih pregleda za zadati interval ********************************************************
public int IzvestajBrojObavljenihPregleda(Date datumOD, Date datumDO) {
	Statement st=null;
	ResultSet rs=null;
	
	try {
		st=Konekcija.getKonekcija().createStatement();
		rs=st.executeQuery("SELECT COUNT(Pregled_ID) FROM pregled WHERE Datum_Pregleda BETWEEN '" + datumOD + "' and '" + datumDO + "'");
		
		
		int RezultatIzvestaja = 0;
		while(rs.next()){
			RezultatIzvestaja= rs.getInt(1);
		}
		return RezultatIzvestaja;
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return 0;
}
//********** #FREJM19b ***************************Metod za izvestaj ukupnog broja pacijeanta********************************************************

public static int IzvestajUkupanBrojPacijenata() {
	Statement st=null;
	ResultSet rs=null;
	
	try {
		st=Konekcija.getKonekcija().createStatement();
		rs=st.executeQuery("SELECT COUNT(Jmbg_pacijent) FROM pacijent");
		
		
		int UkupanBrojPacijenata = 0;
		while(rs.next()){
			UkupanBrojPacijenata= rs.getInt(1);
		}
		return UkupanBrojPacijenata;
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return 0;
}
//********** #FREJM20 ***************************Metod za izvestaj obavljeni promet za zadati interval********************************************************
public int IzvestajObavljenogPrometa(Date datumOD, Date datumDO) {
	Statement st=null;
	ResultSet rs=null;
	
	try {
		st=Konekcija.getKonekcija().createStatement();
		rs=st.executeQuery("SELECT SUM(Cena) FROM stavka_fakture sf,pregled p, faktura f WHERE p.Pregled_ID=f.Pregled_ID and f.Faktura_ID=sf.Faktura_ID and p.Datum_pregleda BETWEEN '" + datumOD + "' and '" + datumDO + "'");
		
		
		int RezultatIzvestaja = 0;
		while(rs.next()){
			RezultatIzvestaja= rs.getInt(1);
		}
		return RezultatIzvestaja;
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return 0;
}
//********** #FREJM21 ***************************Metod za izvestaj broj izdatih recepata********************************************************
public int IzvestajBrojIzdatihRecepata(Date datumOD, Date datumDO) {
	Statement st=null;
	ResultSet rs=null;
	
	try {
		st=Konekcija.getKonekcija().createStatement();
		rs=st.executeQuery("SELECT COUNT(Recept_ID) FROM recept r, pregled p WHERE p.Pregled_ID=r.Pregled_ID and p.Datum_pregleda BETWEEN '" + datumOD + "' and '" + datumDO + "'");
		
		
		int RezIzdatiRecepti = 0;
		while(rs.next()){
			RezIzdatiRecepti= rs.getInt(1);
		}
		return RezIzdatiRecepti;
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return 0;
}
//********** #FREJM21 ***************************Metod za izvestaj broj izdatih uputa********************************************************
public int IzvestajBrojIzdatihUputa(Date datumOD, Date datumDO) {
	Statement st=null;
	ResultSet rs=null;
	
	try {
		st=Konekcija.getKonekcija().createStatement();
		rs=st.executeQuery("SELECT COUNT(Recept_ID) FROM recept r, pregled p WHERE p.Pregled_ID=r.Pregled_ID and p.Datum_pregleda BETWEEN '" + datumOD + "' and '" + datumDO + "'");
		
		
		int RezIzdatiUputi = 0;
		while(rs.next()){
			RezIzdatiUputi= rs.getInt(1);
		}
		return RezIzdatiUputi;
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return 0;
}
//********** #FREJM21 ***************************Metod za izvestaj broj izdatih faktura********************************************************
public int IzvestajBrojIzdatihFaktura(Date datumOD, Date datumDO) {
	Statement st=null;
	ResultSet rs=null;
	
	try {
		st=Konekcija.getKonekcija().createStatement();
		rs=st.executeQuery("SELECT COUNT(Faktura_ID) FROM pregled p, faktura f WHERE p.Pregled_ID=f.Pregled_ID and p.Datum_pregleda BETWEEN '" + datumOD + "' and '" + datumDO + "'");
		
		
		int RezIzdatiFakture = 0;
		while(rs.next()){
			RezIzdatiFakture= rs.getInt(1);
		}
		return RezIzdatiFakture;
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return 0;
}
//********** #FREJM22 ***************************Metod za izvestaj prosecan iznos fakture********************************************************
public int IzvestajProsecanIznosFakture(Date datumOD, Date datumDO) {
	
	Statement st=null;
	ResultSet rs=null;
	
	try {
		st=Konekcija.getKonekcija().createStatement();
		rs=st.executeQuery("SELECT AVG(Iznos_fakture) FROM faktura f, pregled p WHERE p.Pregled_ID=f.Pregled_ID and p.Datum_pregleda BETWEEN '" + datumOD + "' and '" + datumDO + "'");
		
		
		int RezIzdatiFakture = 0;
		while(rs.next()){
			RezIzdatiFakture= rs.getInt(1);
		}
		return RezIzdatiFakture;
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return 0;
}
//********** #FREJM23 ***************************Metod za izvestaj najskupnje izvesene usluge za zadati vremenski interval interval********************************************************
public static DefaultTableModel IzvestajNajskupljeIzvrseneUsluge(Date datumOD, Date datumDO) {
	Statement st=null;
	ResultSet rs=null;
	
	try {
		st=Konekcija.getKonekcija().createStatement();
		rs=st.executeQuery("SELECT Naziv_usluge, MAX(Cena) FROM usluga u,pregled p, izvrsene_usluge iu WHERE p.Pregled_ID=iu.Pregled_ID and iu.Usluga_ID=u.Usluga_ID and p.Datum_pregleda BETWEEN '" + datumOD + "' and '" + datumDO + "' GROUP BY u.Naziv_usluge ORDER BY Cena DESC");
		
		
		return PravljenjeTabeleZaPregled(rs);
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return null;
}
//********** #FREJM24 ***************************Metod za izvestaj najcesca oboljenja za zadati vremenski interval ********************************************************
public static DefaultTableModel IzvestajNajcescaOboljenja(Date datumOD, Date datumDO) {
	Statement st=null;
	ResultSet rs=null;
	
	try {
		st=Konekcija.getKonekcija().createStatement();
		rs=st.executeQuery("SELECT Naziv_bolesti, COUNT(d.Bolest_ID)  as Broj_pojavljivanja_bolesti FROM pregled p, dijagnoza d, bolest b WHERE d.Bolest_ID=b.Bolest_ID and p.Pregled_ID=d.Pregled_ID and p.Datum_pregleda BETWEEN '" + datumOD + "' and '" + datumDO + "' GROUP BY b.Naziv_bolesti ORDER BY Broj_pojavljivanja_bolesti DESC");
		
		
		return PravljenjeTabeleZaPregled(rs);
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return null;
}
//********** #FREJM25 ***************************Metod za lekari sa najvise obavljenih pregled za zadati vremenski interval ********************************************************
public static DefaultTableModel IzvestajLekariSaNajvisePregleda(Date datumOD, Date datumDO) {
	Statement st=null;
	ResultSet rs=null;
	
	try {
		st=Konekcija.getKonekcija().createStatement();
		rs=st.executeQuery("SELECT Ime, Prezime, COUNT(p.Jmbg_lekar) as LekarSaNajviseObavljenihPregleda FROM pregled p, lekar l WHERE p.Jmbg_lekar=l.Jmbg_lekar and p.Datum_pregleda BETWEEN '" + datumOD + "' and '" + datumDO + "' GROUP BY l.Prezime;");
		
		return PravljenjeTabeleZaPregled(rs);
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return null;
}
//********** #FREJM26 ***************************Metod za izvestaj najcesce prepisani lekovi za zadati vremenski interval ********************************************************
public static DefaultTableModel IzvestajNajcescePrepisivaniLekovi(Date datumOD, Date datumDO) {
	Statement st=null;
	ResultSet rs=null;
	
	try {
		st=Konekcija.getKonekcija().createStatement();
		rs=st.executeQuery("SELECT Naziv_leka, COUNT(r.Lek_ID) as Broj_recepata FROM pregled p, lek l, recept r WHERE p.Pregled_ID=r.Pregled_ID and r.Lek_ID=l.Lek_ID and p.Datum_pregleda BETWEEN '" + datumOD + "' and '" + datumDO + "' GROUP BY l.Naziv_leka ORDER BY Broj_recepata DESC");
		
		return PravljenjeTabeleZaPregled(rs);
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return null;
}
//********** #FREJM6 ***************************Metod za selektovanje Bolesti ID na osnovu Naziva bolesti ********************************************************

public int SelektovanjeBolestIDnaOsnovuNazivaBolesti(String nazivBolesti) {
	
	Statement st=null;
	ResultSet rs=null;
	
	try {
		st=Konekcija.getKonekcija().createStatement();
		rs=st.executeQuery("SELECT Bolest_ID FROM bolest WHERE Naziv_bolesti='" + nazivBolesti + "'");
		
		int BolestID=0;
		if (rs.next()){
			BolestID=rs.getInt(1);
		}
		
		return BolestID;
		
	} catch (Exception e) {
	}
	
	return 0;
}
//********** #FREJM6 **************************Metod za brisanje selekovane bolesti u tabeli iz dijagnoze u bazi podataka ********************************************************
public boolean BrisanjeSelektovaneBolestiUTabeliSaPregledaIzBaze(int BolestID, int pregledID) {
	
	String Upit = "DELETE FROM dijagnoza WHERE Bolest_ID=? AND Pregled_ID=?";

	try {
		
		Konekcija.getKonekcija().setAutoCommit(false);
		Connection kon= Konekcija.getKonekcija();
		com.mysql.jdbc.PreparedStatement ps=(PreparedStatement) kon.prepareStatement(Upit);
		ps.setInt(1, BolestID);
		ps.setInt(2, pregledID);
		
		int i=ps.executeUpdate();

		if (i>0){
			
		Konekcija.getKonekcija().commit();	
		Konekcija.getKonekcija().setAutoCommit(true);
		
		}
		return true;

		
	} catch (Exception e) {
		e.printStackTrace();
		return false;
	}
	
}

//********** #FREJM6 **************************Metod za selektovranje Usluge ID na osnovu naziva usluga********************************************************
public int SelektovanjeUslugaIDnaOsnovuNazivUsluge(String NazivUsluge) {
	
	Statement st=null;
	ResultSet rs=null;
	
	try {
		st=Konekcija.getKonekcija().createStatement();
		rs=st.executeQuery("SELECT Usluga_ID FROM usluga WHERE Naziv_usluge='" + NazivUsluge + "'");
		
		int UslugaID=0;
		if (rs.next()){
			UslugaID=rs.getInt(1);
		}
		
		return UslugaID;
		
	} catch (Exception e) {
	}
	
	return 0;
}

//********** #FREJM6 **************************Metod za brisanje selekovane usluge u tabeli iz izvrsenih usluga u bazi podataka ********************************************************
public boolean BrisanjeSelektovaneUslugeUTabelisaPregledaizBaze(int UslugaID, int pregledID) {
	
	String Upit = "DELETE FROM izvrsene_usluge WHERE Usluga_ID=? AND Pregled_ID=?";

	try {
		
		Konekcija.getKonekcija().setAutoCommit(false);
		Connection kon= Konekcija.getKonekcija();
		com.mysql.jdbc.PreparedStatement ps=(PreparedStatement) kon.prepareStatement(Upit);
		ps.setInt(1, UslugaID);
		ps.setInt(2, pregledID);
		
		int i=ps.executeUpdate();

		if (i>0){
			
		Konekcija.getKonekcija().commit();	
		Konekcija.getKonekcija().setAutoCommit(true);
		
		}
		return true;

		
	} catch (Exception e) {
		e.printStackTrace();
		return false;
	}
	
}
//********** #FREJM6 **************************Metod za brisanje selektovane usluge u tabeli iz stakvi fakture u bazi podataka ********************************************************
public boolean BrisanjeSelektovaneStakveFaktureUTabeli(int UslugaID, int fakturaID) {
	
	String Upit = "DELETE FROM stavka_fakture WHERE Usluga_ID=? Faktura_ID=?";

	try {
		
		Konekcija.getKonekcija().setAutoCommit(false);
		Connection kon= Konekcija.getKonekcija();
		com.mysql.jdbc.PreparedStatement ps=(PreparedStatement) kon.prepareStatement(Upit);
		ps.setInt(1, UslugaID);
		ps.setInt(2, fakturaID);
		
		int i=ps.executeUpdate();

		if (i>0){
			
		Konekcija.getKonekcija().commit();	
		Konekcija.getKonekcija().setAutoCommit(true);
		
		}
		return true;

		
	} catch (Exception e) {
		e.printStackTrace();
		return false;
	}
	
}

}



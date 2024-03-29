package beans;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class Apartman {

	public enum Tip {
		Soba, Ceo_apartman
	}

	public enum Status {
		Aktivno, Neaktivno
	}

	private Tip tip;
	private int brSoba;
	private int brGostiju;
	private Lokacija lokacija;
	private ArrayList<Date> datumiZaIzdavanje;
	private ArrayList<Date> dostupnostPoDatumima;
	private String domacin;
	private ArrayList<Komentar> komentari = new ArrayList<Komentar>();
	private String slika;// vise slika treba
	private double cenaPoNoci;
	private String vrZaPrijavu;
	private String vrZaOdjavu;
	private Status status;
	private ArrayList<SadrzajApartmana> sadrzajAp;
	private ArrayList<Rezervacija> rezervacije = new ArrayList<Rezervacija>();

	private Boolean uklonjen = false;
	private String idApartmana = UUID.randomUUID().toString();

	public Apartman() {
		super();
		this.status = Status.Neaktivno;
	}

	public Apartman(Tip tip, int brSoba, int brGostiju, Lokacija lokacija, ArrayList<Date> datum, String d,
			String slika, ArrayList<SadrzajApartmana> sadrzaj ,double cena, Boolean uklonjen, String id) {
		super();
		this.tip = tip;
		this.brSoba = brSoba;
		this.brGostiju = brGostiju;
		this.lokacija = lokacija;
		this.datumiZaIzdavanje = datum;
		this.dostupnostPoDatumima = new ArrayList<Date>();
		this.domacin = d;
		this.slika = slika;
		this.cenaPoNoci = cena;
		this.vrZaOdjavu = "";
		this.vrZaPrijavu = "";
		this.status = Status.Aktivno;
		this.sadrzajAp = new ArrayList<SadrzajApartmana>();
		this.uklonjen = uklonjen;
		this.idApartmana = id;
	}

	public Tip getTip() {
		return tip;
	}

	public void setTip(Tip tip) {
		this.tip = tip;
	}

	public int getBrSoba() {
		return brSoba;
	}

	@Override
	public String toString() {
		return "Apartman [tip=" + tip + ", brSoba=" + brSoba + ", brGostiju=" + brGostiju + ", lokacija=" + lokacija
				+ ", datumiZaIzdavanje=" + datumiZaIzdavanje + ", dostupnostPoDatumima=" + dostupnostPoDatumima
				+ ", domacin=" + domacin + ", komentar=" + komentari + ", slika=" + slika + ", cenaPoNoci=" + cenaPoNoci
				+ ", vrZaPrijavu=" + vrZaPrijavu + ", vrZaOdjavu=" + vrZaOdjavu + ", status=" + status + ", sadrzajAp="
				+ sadrzajAp + ", rezervacije=" + rezervacije + ", uklonjen=" + uklonjen + ", idApartmana=" + idApartmana
				+ "]";
	}

	public void setBrSoba(int brSoba) {
		this.brSoba = brSoba;
	}

	public int getBrGostiju() {
		return brGostiju;
	}

	public void setBrGostiju(int brGostiju) {
		this.brGostiju = brGostiju;
	}

	public Lokacija getLokacija() {
		return lokacija;
	}

	public void setLokacija(Lokacija lokacija) {
		this.lokacija = lokacija;
	}

	public ArrayList<Date> getdatumiZaIzdavanje() {
		return datumiZaIzdavanje;
	}

	public void setdatumiZaIzdavanje(ArrayList<Date> datumiZaIzdavanje) {
		this.datumiZaIzdavanje = datumiZaIzdavanje;
	}

	public ArrayList<Date> getDostupnostPoDatumima() {
		return dostupnostPoDatumima;
	}

	public void setDostupnostPoDatumima(ArrayList<Date> dostupnostPoDatumima) {
		this.dostupnostPoDatumima = dostupnostPoDatumima;
	}

	public String getDomacin() {
		return domacin;
	}

	public void setDomacin(String domacin) {
		this.domacin = domacin;
	}

	public ArrayList<Komentar> getKomentari() {
		return komentari;
	}

	public void setKomentari(ArrayList<Komentar> komentari) {
		this.komentari = komentari;
	}

	public String getSlika() {
		return slika;
	}

	public void setSlika(String slika) {
		this.slika = slika;
	}

	public double getCenaPoNoci() {
		return cenaPoNoci;
	}

	public void setCenaPoNoci(double cenaPoNoci) {
		this.cenaPoNoci = cenaPoNoci;
	}

	public String getVrZaPrijavu() {
		return vrZaPrijavu;
	}

	public void setVrZaPrijavu(String vrZaPrijavu) {
		this.vrZaPrijavu = vrZaPrijavu;
	}

	public String getVrZaOdjavu() {
		return vrZaOdjavu;
	}

	public void setVrZaOdjavu(String vrZaOdjavu) {
		this.vrZaOdjavu = vrZaOdjavu;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public ArrayList<SadrzajApartmana> getSadrzajAp() {
		return sadrzajAp;
	}

	public void setSadrzajAp(ArrayList<SadrzajApartmana> sadrzajAp) {
		this.sadrzajAp = sadrzajAp;
	}

	public ArrayList<Rezervacija> getRezervacije() {
		return rezervacije;
	}

	public void setRezervacije(ArrayList<Rezervacija> rezervacije) {
		this.rezervacije = rezervacije;
	}

	public Boolean getUklonjen() {
		return uklonjen;
	}

	public void setUklonjen(Boolean uklonjen) {
		this.uklonjen = uklonjen;
	}

	public String getIdApartmana() {
		return idApartmana;
	}

	public void setIdApartmana(String idApartmana) {
		this.idApartmana = idApartmana;
	}
	
	//dodajemo apartmanu novu rezervaciju u listu
	public void dodajRezervaciju(Rezervacija r) {
		rezervacije.add(r);
	}
	
	public void setOdustanak(String id) {
		for(Rezervacija r : rezervacije) {
			if(r.getIdRezervacije().equals(id)) {
				r.setStatus(Rezervacija.Status.Odustanak);
			}
		}
	}
	
	public void setZavrsetak(String id) {
		for(Rezervacija r : rezervacije) {
			if(r.getIdRezervacije().equals(id)) {
				r.setStatus(Rezervacija.Status.Odustanak);
			}
		}
	}
	
	public void setPrihvacena(String id) {
		for(Rezervacija r : rezervacije) {
			if(r.getIdRezervacije().equals(id)) {
				r.setStatus(Rezervacija.Status.Prihvacena);
			}
		}
	}
	
	public void dodajKomentar(Komentar k) {
		komentari.add(k);
	}
	
	public Rezervacija getRezervacijuID(String id) {
		Rezervacija rezervacija = null;
		for (Rezervacija r : rezervacije) {
			if (r.getIdRezervacije().equals(id)) {
				rezervacija =  r;
				break;
			}	
		}
		return rezervacija;
	}
	
	public void setOdbijena(String id) {
		for(Rezervacija r : rezervacije) {
			if(r.getIdRezervacije().equals(id)) {
				r.setStatus(Rezervacija.Status.Odbijena);
			}
		}
	}
	
	/*public Status getStatusRezervacijeId(String id) {
		Status status = null;
		for(Rezervacija r : rezervacije) {
			if(r.getIdRezervacije().equals(id)) {
				status = r.getStatus();
			}
		}
		return status;
	}*/
	
	
	
}

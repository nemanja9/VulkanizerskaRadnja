package gume;

/**
 * Klasa koja predstavlja jednu gumu
 * 
 * @author Nemanja Jurisic
 * @version 1.0
 *
 */
public class AutoGuma {
	/** Atribut koji opisuje marku i model gume */
	private String markaModel = null;
	/** Atribut koji opisuje precnik gume */
	private int precnik = 0;
	/** Atribut koji opisuje sirinu gume */
	private int sirina = 0;
	/** Atribut koji opisuje visinu gume */
	private int visina = 0;

	/**
	 * Vraca vrednost atributa markaModel
	 * 
	 * @return string marke i modela gume
	 */
	public String getMarkaModel() {
		return markaModel;
	}

	/**
	 * Postavlja vrednost atributa markaModel
	 * 
	 * @param markaModel
	 *            nova vrednost marke i modela
	 * @throws java.lang.RuntimeException
	 *             ako je unet null ili string kraci od 3 karaktera za markuModel
	 */
	public void setMarkaModel(String markaModel) {
		if (markaModel == null || markaModel.length() < 3)
			throw new RuntimeException("Morate uneti marku i model");
		this.markaModel = markaModel;
	}

	/**
	 * Vraca vrednost atributa precnik
	 * 
	 * @return precnik gume kao ceo broj
	 */
	public int getPrecnik() {
		return precnik;
	}

	/**
	 * Postavlja vrednost atributa precnik
	 * 
	 * @param precnik
	 *            nova vrednost precnika
	 * @throws java.lang.RuntimeException
	 *             ako je uneta vrednost za precnik koja je manja od 13 i veca od 22
	 */
	public void setPrecnik(int precnik) {
		if (precnik < 13 || precnik > 22)
			throw new RuntimeException("Precnik van opsega");
		this.precnik = precnik;
	}

	/**
	 * Vraca vrednost atributa sirina
	 * 
	 * @return sirina gume kao ceo broj
	 */
	public int getSirina() {
		return sirina;
	}

	/**
	 * Postavlja vrednost atributa sirina
	 * 
	 * @param sirina
	 *            nova vrednost sirine
	 * @throws java.lang.RuntimeException
	 *             ako je uneta vrednost za sirinu koja je manja od 135 i veca od
	 *             355
	 */
	public void setSirina(int sirina) {
		if (sirina < 135 || sirina > 355)
			throw new RuntimeException("Sirina van opsega");
		this.sirina = sirina;
	}

	/**
	 * Vraca vrednost atributa visina
	 * 
	 * @return visina gume kao ceo broj
	 */
	public int getVisina() {
		return visina;
	}

	/**
	 * Postavlja vrednost atributa visina
	 * 
	 * @param visina
	 *            nova vrednost visine
	 * @throws java.lang.RuntimeException
	 *             ako je uneta vrednost za visinu koja je manja od 25 ili veca od
	 *             95
	 */
	public void setVisina(int visina) {
		if (visina < 25 || visina > 95)
			throw new RuntimeException("Visina van opsega");
		this.visina = visina;
	}

	/**
	 * Vraca string sa svim informacijama o gumi
	 * 
	 * @return celokupna informacija o gumi sa podacima visina, sirina, precnik,
	 *         marka i model u vidu stringa
	 */
	@Override
	public String toString() {
		return "AutoGuma [markaModel=" + markaModel + ", precnik=" + precnik + ", sirina=" + sirina + ", visina="
				+ visina + "]";
	}

	/**
	 * Vraca boolean vrednost koja zavisi od toga da li su dve gume jednake po svim
	 * svojim atributima
	 * 
	 * @return boolean da li su gume iste ili ne
	 * @param obj
	 *            objekat guma sa kojom se poredi
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AutoGuma other = (AutoGuma) obj;
		if (markaModel == null) {
			if (other.markaModel != null)
				return false;
		} else if (!markaModel.equals(other.markaModel))
			return false;
		if (precnik != other.precnik)
			return false;
		if (sirina != other.sirina)
			return false;
		if (visina != other.visina)
			return false;
		return true;
	}
}
package gume.radnja;

import java.util.LinkedList;
import gume.AutoGuma;

/**
 * Klasa koja predstavlja vulkanizersku radnju
 * 
 * @author Nemanja Jurisic
 * @version 1.0
 *
 */
public class VulkanizerskaRadnja {
	/** Atribut koji predstavlja skup guma */
	private LinkedList<AutoGuma> gume = new LinkedList<AutoGuma>();

	/**
	 * Metoda koja dodaje novu gumu u listu guma
	 * @param a guma koja treba da bude dodata u listu guma
	 * @throws java.lang.NullPointerException ako je prosleđen null kao parametar
	 * @throws java.lang.RuntimeException ako guma koju pokusavamo da dodamo vec postoji u listi
	 */
	public void dodajGumu(AutoGuma a) {
		if (a == null)
			throw new NullPointerException("Guma ne sme biti null");
		if (gume.contains(a))
			throw new RuntimeException("Guma vec postoji");
		gume.addFirst(a);
	}
	/**
	 * Metoda koja na osnovu unetog Stringa markaModel pronalazi
	 * istu takvu gumu
	 * @param markaModel marka i model gume koju trazimo u obliku Stringa
	 * @return novaLista lista guma koje imaju dati model i marku
	 * @return null ako je prosledjen null
	 */
	public LinkedList<AutoGuma> pronadjiGumu(String markaModel) {
		if (markaModel == null)
			return null;
		LinkedList<AutoGuma> novaLista = new LinkedList<AutoGuma>();
		for (int i = 0; i < gume.size(); i++)
			if (gume.get(i).getMarkaModel().equals(markaModel))
				novaLista.add(gume.get(i));
		return novaLista;
	}
}
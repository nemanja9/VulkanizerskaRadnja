package gume.radnja.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import gume.AutoGuma;
import gume.radnja.VulkanizerskaRadnja;

public class VulkanizerskaRadnjaTest {

	VulkanizerskaRadnja v;
	AutoGuma g;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		v = new VulkanizerskaRadnja();
		g = new AutoGuma();
	}

	@After
	public void tearDown() throws Exception {
		v = null;
		g = null;
	}

	@Test
	public void testDodajGumuPrimarniScenario() {
		g.setMarkaModel("nekaGuma123");
		v.dodajGumu(g);
		assertEquals(1,v.pronadjiGumu(g.getMarkaModel()).size());
	}
	
	// nadjena greska u metodi pronadji gumu. Ne moze da se poredi objekat sa stringom
	// i zbog toga je metoda uvek vracala praznu listu odnosno kao da nije nasla ni jednu gumu
	// Metoda testDodajGumuPrimarniScenario pokazuje manu (gresku u kodu) koju sam ispravio
	
	@Test (expected = java.lang.NullPointerException.class)
	public void testDodajGumuNull() {
		v.dodajGumu(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testDodajGumuVecPostoji() {
		g.setMarkaModel("1234");
		v.dodajGumu(g);
		
		AutoGuma g1 = new AutoGuma();
		g1.setMarkaModel("1234");
		v.dodajGumu(g1);	
	}
	
	@Test
	public void testPronadjiGumuPrimarniScenario() {
		g.setMarkaModel("1234");
		v.dodajGumu(g);
		assertEquals(1, v.pronadjiGumu(g.getMarkaModel()).size()); 
	}

	@Test
	public void testPronadjiGumuNull() {
		assertEquals(v.pronadjiGumu(null), null);
		
	}
	
	@Test
	public void testPronadjiGumuNema() {
		g.setMarkaModel("1233");
		v.dodajGumu(g);
		assertEquals(v.pronadjiGumu("1234").size(),0);
		
	}

	@Test
	public void testPronadjiGumuViseGuma() {
		AutoGuma g1 = new AutoGuma();
		g1.setMarkaModel("guma1");
		g1.setPrecnik(20);
		g1.setSirina(200);
		g1.setVisina(30);
		v.dodajGumu(g1);
		
		g.setMarkaModel("guma1");
		g.setPrecnik(19);
		g.setSirina(204);
		g.setVisina(31);
		v.dodajGumu(g);
		
		assertEquals(v.pronadjiGumu(g.getMarkaModel()).size(),2);
		
	}
}

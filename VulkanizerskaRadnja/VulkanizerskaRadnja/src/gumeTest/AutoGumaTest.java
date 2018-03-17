package gumeTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import gume.AutoGuma;

public class AutoGumaTest {

	private AutoGuma guma;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		guma = new AutoGuma();
	}

	@After
	public void tearDown() throws Exception {
		guma = null;
	}

	@Test
	public void testSetMarkaModelPrimarniScenario() {
		guma.setMarkaModel("nekaMarkaNekiModel");
		assertEquals("nekaMarkaNekiModel", guma.getMarkaModel());
	}
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetMarkaModelNull() {
		guma.setMarkaModel(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetMarkaModelKratakString() {
		guma.setMarkaModel("n1");
		}

	@Test 
	public void testSetPrecnikPrimarniScenario() { 
		guma.setPrecnik(20);
		assertEquals(20, guma.getPrecnik());
	}
		
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPrecnikMana() { 
		guma.setPrecnik(1000);		//	ovo je test koji pokazuje da metoda setPrecnik ima gresku 
									//	odnosno da nikada ne baca izuzetak iako bi trebala. Promenicu &&
									//	u if uslovu u ||
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPrecnikManjaVrednost() { 
		guma.setPrecnik(2);
		
	}

	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPrecnikVecaVrednost() { 
		guma.setPrecnik(25);
		
	}

	@Test
	public void testSetSirinaPrimarniScenario() {
		guma.setSirina(200);
		assertEquals(200, guma.getSirina());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetSirinaMana() {
		
		guma.setSirina(10000);			//Ova metoda ima manu istu kao i prethodna
										// menjam && u if uslovu u ||
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetSirinaManjaVrednost() {
		
		guma.setSirina(0);	
		
	}
	
	@Test
	public void testSetVisinaPrimarniScenario() {
		guma.setVisina(30);
		assertEquals(30, guma.getVisina());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetVisinaManjaVrednost() {
		guma.setVisina(20);
		
	}
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetVisinaVecaVrednost() {
		guma.setVisina(100);
		
	}

	@Test
	public void testToString() {
		guma.setMarkaModel("mmmm2");
		guma.setPrecnik(20);
		guma.setVisina(50);
		guma.setSirina(140);
		assertEquals("AutoGuma [markaModel=mmmm2, precnik=20, sirina=140, visina=50]", guma.toString());
	}

	@Test
	public void testEquals() {
		guma.setMarkaModel("mmmm2");
		guma.setPrecnik(20);
		guma.setVisina(50);
		guma.setSirina(140);
		
		AutoGuma g = new AutoGuma();
		g.setMarkaModel("mmmm3");
		g.setPrecnik(20);
		g.setVisina(50);
		g.setSirina(141);
		
		assertFalse(guma.equals(g));
		
	}
}

package sommerjobb2020;

import static org.junit.Assert.*;

import org.junit.Test;

public class FrittFlixTest {

	@Test
	public void test() {
		FrittFlix netflix = new FrittFlix();
		
		
		netflix.registerCustomer("Fridtjof", "Drama", "Humor", "Animasjon");
		netflix.registerCustomer("Santhosh", "Krim", "Animasjon", "Gameshow", "Reality");
		netflix.registerCustomer("Andreas", "Reality", "Talkshow", "Animasjon");
		
		
		netflix.registerSeries("BMS", "Humor", "Animasjon", "Drama", "Talkshow", "Krim", "Reality", "Gameshow");
		netflix.registerSeries("Breaking Bad", "Drama", "Krim", "Humor");
		netflix.registerSeries("Mikke Mus", "Animasjon", "Drama");
		netflix.registerSeries("Yolo", "Animasjon", "Humor", "Drama");
		netflix.registerSeries("Wiz", "Drama", "Krim", "Gameshow");
		
		
		assertEquals("BMS",netflix.getHighestIntrest().getTitle());
		assertEquals(3, netflix.getIntrestWeight(netflix.getCustomers().get(0).getID(), netflix.getSeries().get(0).getID()));
		
		
		
		
		
		
	}

}

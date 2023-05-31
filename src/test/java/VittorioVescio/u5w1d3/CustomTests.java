package VittorioVescio.u5w1d3;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import VittorioVescio.u5w1d3.entities.Ferrarelle;
import VittorioVescio.u5w1d3.entities.Pizza;
import VittorioVescio.u5w1d3.entities.Prodotto;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomTests {

	@BeforeAll
	static void beforeAll() {
		log.info("Inizio test");
	}

	@Test
	void testTotOrdine() {
		List<Prodotto> prodotti = new ArrayList<>();
		prodotti.add(new Pizza());
		prodotti.add(new Ferrarelle());

		double totale = totOrdine(prodotti);
		double totaleAtteso = 6.50;
		Assertions.assertEquals(totaleAtteso, totale);
	}

	public double totOrdine(List<Prodotto> p) {
		double somma = p.stream().mapToDouble(Prodotto::getPrezzo).sum();
		return somma;
	}

	@AfterAll
	static void afterAll() {
		log.info("Fine test!");
	}
}

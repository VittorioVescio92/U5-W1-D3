package VittorioVescio.u5w1d3.entities.ordini;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import VittorioVescio.u5w1d3.config.BeansConfiguration;
import VittorioVescio.u5w1d3.entities.BoscaiolaDecorator;
import VittorioVescio.u5w1d3.entities.CocaCola;
import VittorioVescio.u5w1d3.entities.ExtraPepeDecorator;
import VittorioVescio.u5w1d3.entities.Ferrarelle;
import VittorioVescio.u5w1d3.entities.HawaianaDecorator;
import VittorioVescio.u5w1d3.entities.MaxiPizzaDecorator;
import VittorioVescio.u5w1d3.entities.Pizza;
import VittorioVescio.u5w1d3.entities.Prodotto;

@Component
public class OrdiniRunner implements CommandLineRunner {
	@Value("${application.costoCoperto}")
	private double costoCoperto;

	@Override
	public void run(String... args) throws Exception {
		menu(costoCoperto);
	}

	public static void menu(double costoCoperto) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeansConfiguration.class);
		System.out.println();

		Pizza margherita = (Pizza) ctx.getBean("margherita");
		BoscaiolaDecorator boscaiola = (BoscaiolaDecorator) ctx.getBean("boscaiola");
		HawaianaDecorator hawaiana = (HawaianaDecorator) ctx.getBean("hawaiana");
		MaxiPizzaDecorator boscaiolaMaxi = (MaxiPizzaDecorator) ctx.getBean("boscaiolaMaxi");
		MaxiPizzaDecorator margheritaMaxi = (MaxiPizzaDecorator) ctx.getBean("margheritaMaxi");
		MaxiPizzaDecorator hawaianaMaxi = (MaxiPizzaDecorator) ctx.getBean("hawaianaMaxi");
		ExtraPepeDecorator boscaiolaPepata = new ExtraPepeDecorator(boscaiola);
		Ferrarelle ferrarelle = (Ferrarelle) ctx.getBean("ferrarelle");
		CocaCola coca = (CocaCola) ctx.getBean("coca");

		Tavolo tavolo1 = new Tavolo(1, 4, StatoTavolo.LIBERO);
		Tavolo tavolo2 = new Tavolo(2, 4, StatoTavolo.LIBERO);
		Tavolo tavolo3 = new Tavolo(3, 6, StatoTavolo.LIBERO);
		Tavolo tavolo4 = new Tavolo(4, 6, StatoTavolo.OCCUPATO);

		List<Prodotto> comanda1 = new ArrayList<>(Arrays.asList(margherita, ferrarelle));
		Ordine ord1 = new Ordine(tavolo1, comanda1, 1, StatoOrdine.IN_CORSO, 2, LocalDateTime.of(2023, 05, 30, 12, 30),
				costoCoperto);

		List<Prodotto> comanda2 = new ArrayList<>(Arrays.asList(boscaiolaMaxi, hawaiana, boscaiola, ferrarelle, coca));
		Ordine ord2 = new Ordine(tavolo2, comanda2, 2, StatoOrdine.IN_CORSO, 3, LocalDateTime.of(2023, 05, 31, 14, 00),
				costoCoperto);

		Ordine ord3 = (Ordine) ctx.getBean("ord3");
		Ordine ord4 = (Ordine) ctx.getBean("ord3");

		System.out.println("-------------------- MENU --------------------");
		System.out.println(margherita.toString());
		System.out.println(boscaiola.toString());
		System.out.println(hawaiana.toString());
		System.out.println(boscaiolaMaxi.toString());
		System.out.println(margheritaMaxi.toString());
		System.out.println(hawaianaMaxi.toString());
		System.out.println(boscaiolaPepata.toString());
		System.out.println(ferrarelle.toString());
		System.out.println(coca.toString());

		System.out.println();
		System.out.println("-------------------- ORDINI --------------------");
		System.out.println(ord1.toString());
		System.out.println();
		System.out.println(ord2.toString());
		System.out.println();
		System.out.println(ord3.toString());
		System.out.println();
		System.out.println(ord4.toString());

		ctx.close();
	}
}

package VittorioVescio.u5w1d3.config;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import VittorioVescio.u5w1d3.entities.BoscaiolaDecorator;
import VittorioVescio.u5w1d3.entities.CocaCola;
import VittorioVescio.u5w1d3.entities.ExtraPepeDecorator;
import VittorioVescio.u5w1d3.entities.Ferrarelle;
import VittorioVescio.u5w1d3.entities.HawaianaDecorator;
import VittorioVescio.u5w1d3.entities.MaxiPizzaDecorator;
import VittorioVescio.u5w1d3.entities.Pizza;
import VittorioVescio.u5w1d3.entities.Prodotto;
import VittorioVescio.u5w1d3.entities.ordini.Ordine;
import VittorioVescio.u5w1d3.entities.ordini.StatoOrdine;
import VittorioVescio.u5w1d3.entities.ordini.StatoTavolo;
import VittorioVescio.u5w1d3.entities.ordini.Tavolo;

@Configuration
@PropertySource("classpath:application.properties")
public class BeansConfiguration {
	@Value("${application.costoCoperto}")
	private double costoCoperto;

	@Bean
	@Scope("singleton")
	Pizza margherita() {
		return new Pizza();
	}

	@Bean
	@Scope("singleton")
	BoscaiolaDecorator boscaiola(Pizza margherita) {
		return new BoscaiolaDecorator(margherita);
	}

	@Bean
	@Scope("singleton")
	HawaianaDecorator hawaiana(Pizza margherita) {
		return new HawaianaDecorator(margherita);
	}

	@Bean
	@Scope("singleton")
	MaxiPizzaDecorator boscaiolaMaxi(BoscaiolaDecorator b) {
		return new MaxiPizzaDecorator(b);
	}

	@Bean
	@Scope("singleton")
	MaxiPizzaDecorator margheritaMaxi() {
		return new MaxiPizzaDecorator(new Pizza());
	}

	@Bean
	@Scope("singleton")
	MaxiPizzaDecorator hawaianaMaxi() {
		return new MaxiPizzaDecorator(new HawaianaDecorator(new Pizza()));
	}

	@Bean
	@Scope("singleton")
	ExtraPepeDecorator extraPepe(BoscaiolaDecorator b) {
		return new ExtraPepeDecorator(b);
	}

	@Bean
	@Scope("singleton")
	Ferrarelle ferrarelle() {
		return new Ferrarelle();
	}

	@Bean
	@Scope("singleton")
	CocaCola coca() {
		return new CocaCola();
	}

	@Bean
	@Scope("singleton")
	Tavolo tavolo5() {
		return new Tavolo(5, 8, StatoTavolo.LIBERO);
	}

	@Bean
	@Scope("singleton")
	List<Prodotto> comanda3() {
		return new ArrayList<>(Arrays.asList(margherita(), ferrarelle(), coca()));
	}

	@Bean
	@Scope("prototype")
	Ordine ord3() {
		return new Ordine(tavolo5(), comanda3(), 3, StatoOrdine.IN_CORSO, 1, LocalDateTime.of(2023, 05, 31, 12, 00),
				costoCoperto);
	}
}

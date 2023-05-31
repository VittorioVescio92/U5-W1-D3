package VittorioVescio.u5w1d3.entities.ordini;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Tavolo {
	private int numero;
	private int copertiMax;
	private StatoTavolo stato;

}

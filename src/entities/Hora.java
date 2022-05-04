package entities;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Objects;

public class Hora {

	private Integer horas;
	private Integer minutos;
	private Integer segundos;

	public Hora(String hora) {
		
		if (!isValid(hora)) {
			horas = 00;
			minutos = 00;
			segundos = 00;

		} else {

			String[] horaMinutoSegundo = hora.split(":");
			horas = Integer.parseInt(horaMinutoSegundo[0]);
			minutos = Integer.parseInt(horaMinutoSegundo[1]);
			segundos = Integer.parseInt(horaMinutoSegundo[2]);
		}
	}

	private boolean isValid(String hora) {

		try {
			DateTimeFormatter parserHora = DateTimeFormatter.ofPattern("HHmmss");
			LocalTime horas = LocalTime.parse("212010", parserHora);
			DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm:ss");
			String horaFormatada = formatterHora.format(horas);

			return true;

		} catch (DateTimeParseException e) {
			return false;
		}

	}
	
	public String getTime() {
		return toString();
	}

	public Integer getHoras() {
		return horas;
	}

	public Integer getMinutos() {
		return minutos;
	}

	public Integer getSegundos() {
		return segundos;
	}

	public String displayHora() {
		return getTime();

	}
	public Integer compara(Hora hora) {
		
		String[] horaMinutoSegundo = hora.getTime().split(":");
		Integer horas = Integer.parseInt(horaMinutoSegundo[0]);
		Integer minutos = Integer.parseInt(horaMinutoSegundo[1]);
		Integer segundos = Integer.parseInt(horaMinutoSegundo[2]);
		
		if (this.equals(hora)) {
			return 0;
		}else {
			
			DateTimeFormatter f = DateTimeFormatter.ofPattern("HH:mm:ss");

			LocalDateTime dt1= LocalDateTime.parse("10:30:00", f);
			LocalDateTime dt2= LocalDateTime.parse("16:00:00", f);

			long diferencaSeg = Duration.between(dt1, dt2).getSeconds();
			
			return (int) diferencaSeg;
		}
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(horas, minutos, segundos);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hora other = (Hora) obj;
		return Objects.equals(horas, other.horas) && Objects.equals(minutos, other.minutos)
				&& Objects.equals(segundos, other.segundos);
	}

	@Override
	public String toString() {
		return horas + ":" + minutos + ":" + segundos;
	}
}

package entities;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.Locale;
import java.util.Objects;

public class Data {

	private Integer dia;
	private Integer mes;
	private Integer ano;

	public Data(String data) {

		if (!isValid(data)) {
			dia = 01;
			mes = 01;
			ano = 0001;

		} else {
			String[] diaMesAno = data.split("/");
			dia = Integer.parseInt(diaMesAno[0]);
			mes = Integer.parseInt(diaMesAno[1]);
			ano = Integer.parseInt(diaMesAno[2]);
		}
	}

	private boolean isValid(String date) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate.parse(date, formatter);
			return true;
		} catch (DateTimeParseException e) {
			return false;
		}
	}

	public String getData() {
		return toString();
	}
	

	public Integer getDia() {
		return dia;
	}

	public Integer getMes() {
		return mes;
	}

	public Integer getAno() {
		return ano;
	}

	public String getMesExtenso() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(ano, mes - 1, dia);
		return calendar.getDisplayName(Calendar.MONTH, Calendar.LONG,new Locale("pt","BR"));
	}
	
	public boolean isBissexto() {
		if(ano %4 ==0) {
			return true;
		}return false;
	}

	public Integer compara(Data data2) {

		String[] diaMesAno = data2.getData().split("/");
		Integer dia = Integer.parseInt(diaMesAno[0]);
		Integer mes = Integer.parseInt(diaMesAno[1]);
		Integer ano = Integer.parseInt(diaMesAno[2]);

		if (this.equals(data2)) {
			return 0;
		}
		if (this.ano > ano) {
			return 1;
		}
		if (this.mes > mes) {
			return 1;
		}
		if (this.dia > dia) {
			return 1;
		}
		return -1;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ano, dia, mes);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Data other = (Data) obj;
		return Objects.equals(ano, other.ano) && Objects.equals(dia, other.dia) && Objects.equals(mes, other.mes);
	}

	@Override
	public String toString() {
		return dia + "/" + mes + "/" + ano;
	}

}

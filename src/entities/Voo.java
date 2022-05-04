package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;



public class Voo {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");
	
	private int numeroVoo;
	private String dataVoo;
	private String horaVoo;
	
	ArrayList assentos = new ArrayList();
	
	public Voo() {
		super();
	}

	public Voo(int numeroVoo, String dataVoo, String horaVoo) {
		super();
		this.numeroVoo = numeroVoo;
		Data data = new Data(dataVoo);
		this.dataVoo = dataVoo;
		Hora hora = new Hora(horaVoo);
		
		for (int i = 1; i < 101; i++){
            assentos.add(i);
       }
       
       System.out.println(assentos);  
	}

	public int getNumeroVoo() {
		return numeroVoo;
	}

	public void setNumeroVoo(int numeroVoo) {
		this.numeroVoo = numeroVoo;
	}

	public String getDataVoo() {
		return dataVoo;
	}

	public void setDataVoo(String dataVoo) {
		this.dataVoo = dataVoo;
	}

	public String getHoraVoo() {
		return horaVoo;
	}

	public void setHoraVoo(String horaVoo) {
		this.horaVoo = horaVoo;
	}
	
	public void proximoLivre(){      
        for (int i = 0; i<1 ;i++){
        	
        	System.out.printf(null, assentos.get(0));
        }
    }
    
    public boolean ocupa(int nAssento){
       
        if(assentos.contains(nAssento)){
            assentos.remove(Integer.valueOf(nAssento));
            return true;
        }else{
        	System.out.printf(null);
        	System.out.print(" Está Ocupado");
            return false;
        }   
    }
    
    public void vagas(){
        System.out.println(assentos);
        System.out.printf(null, assentos);
    }
	
}

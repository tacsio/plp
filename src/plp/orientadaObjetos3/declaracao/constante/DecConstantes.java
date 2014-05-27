package plp.orientadaObjetos3.declaracao.constante;

import java.util.ArrayList;
import java.util.List;

public class DecConstantes {

	private List<Constante> listaConstantes;
	
	public DecConstantes() {
		this.listaConstantes = new ArrayList<Constante>();
	}
	
	public void add(Constante constante){
		this.listaConstantes.add(constante);
	}
	
	public int count() {
		return this.listaConstantes.size();
	}

}

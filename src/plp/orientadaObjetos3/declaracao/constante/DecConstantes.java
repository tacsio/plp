package plp.orientadaObjetos3.declaracao.constante;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import plp.orientadaObjetos1.memoria.AmbienteCompilacaoOO1;

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

	public boolean checaTipo(AmbienteCompilacaoOO1 ambiente) {
		boolean ret = true;
		
		Iterator<Constante> it = listaConstantes.iterator();
		
		while(it.hasNext() && ret){
			ret = it.next().checaTipo(ambiente);
		}
		
		return ret;
	}

}

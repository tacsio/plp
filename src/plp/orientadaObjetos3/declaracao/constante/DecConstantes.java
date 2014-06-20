package plp.orientadaObjetos3.declaracao.constante;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import plp.orientadaObjetos1.expressao.leftExpression.Id;
import plp.orientadaObjetos1.memoria.AmbienteCompilacaoOO1;
import plp.orientadaObjetos1.memoria.AmbienteExecucaoOO1;
import plp.orientadaObjetos3.memoria.AmbienteExecucaoOO3;

public class DecConstantes {

	private List<Constante> listaConstantes;

	public DecConstantes() {
		this.listaConstantes = new ArrayList<Constante>();
	}

	public void add(Constante constante) {
		this.listaConstantes.add(constante);
	}

	public int count() {
		return this.listaConstantes.size();
	}

	public boolean checaTipo(AmbienteCompilacaoOO1 ambiente) {
		boolean ret = true;

		Iterator<Constante> it = listaConstantes.iterator();

		while (it.hasNext() && ret) {
			ret = it.next().checaTipo(ambiente);
		}

		return ret;
	}

	public AmbienteExecucaoOO1 elabora(AmbienteExecucaoOO3 ambiente) {

		Iterator<Constante> it = listaConstantes.iterator();

		while (it.hasNext()) {
			ambiente = it.next().elabora(ambiente);
		}

		return ambiente;
	}

	public Map<Id, Constante> getMapConstantes() {
		Map<Id, Constante> mapConstantes = new HashMap<Id, Constante>();
		for (Constante constante : listaConstantes) {
			mapConstantes.put(constante.getId(), constante);
		}
		return mapConstantes;
	}
	
	public List<Constante> getListaConstantes(){
		return this.listaConstantes;
	}

}

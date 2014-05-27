package plp.orientadaObjetos3.declaracao;

import java.util.ArrayList;
import java.util.List;

import plp.orientadaObjetos1.declaracao.classe.DecClasse;
import plp.orientadaObjetos2.declaracao.ListaDeclaracaoOO;
import plp.orientadaObjetos3.declaracao.modulo.DecModulo;

public class ListaDeclaracaoOO3 extends ListaDeclaracaoOO {

	private List<DecModulo> modulos = new ArrayList<DecModulo>();

	public ListaDeclaracaoOO3() {
		super();
	}

	public ListaDeclaracaoOO3(DecModulo decModulo) {
		super();
		modulos.add(decModulo);
	}

	public ListaDeclaracaoOO3(DecClasse decClasse) {
		super(decClasse);
	}

	public ListaDeclaracaoOO3(DecClasse decClasse, ListaDeclaracaoOO3 lista) {
		super(decClasse, lista);
		this.modulos.addAll(lista.getModulos());
	}
	
	public ListaDeclaracaoOO3(DecModulo decModulo, ListaDeclaracaoOO3 lista) {
		super(lista.getHead(), (ListaDeclaracaoOO) lista.getTail());
		this.modulos.add(decModulo);
		this.modulos.addAll(lista.getModulos());
	}

	public List<DecModulo> getModulos() {
		return modulos;
	}

	public void printDeclaracoes(){
		System.out.println();
		System.out.println();
		System.out.println("Modulos declarados:");
		for(DecModulo decModulo : modulos){
			System.out.println("Name: " + decModulo.getId());
			System.out.println("Constantes: "+ decModulo.getDecConstantes().count());
		}
		System.out.println();
		
		System.out.println("Declaracoes de classes:");
		System.out.println(this.toString());
		
		System.out.println();
		System.out.println();
	}
}

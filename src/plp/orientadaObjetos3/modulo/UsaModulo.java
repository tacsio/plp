package plp.orientadaObjetos3.modulo;


public class UsaModulo {

	private ListaId listaInclude;
	private ListaId listaExtends;

	public UsaModulo() {
		verificaNull();
	}
	
	public UsaModulo(ListaId listaInclude, ListaId listaExtends) {
		this.listaExtends = listaExtends;
		this.listaInclude = listaInclude;
		
		verificaNull();
	}

	private void verificaNull() {
		if(this.listaExtends == null){
			this.listaExtends = new ListaId();
		}
		
		if(this.listaInclude == null){
			this.listaInclude = new ListaId();
		}
	}

	public void addInclude(ListaId listaInclude) {
		this.listaInclude.addAll(listaInclude);
	}

	public void addExtends(ListaId listaExtends) {
		this.listaExtends.addAll(listaExtends);
	}
	
	public ListaId getListaExtends() {
		return this.listaExtends;
	}
	
	public ListaId getListaInclude(){
		return this.listaInclude;
	}
}

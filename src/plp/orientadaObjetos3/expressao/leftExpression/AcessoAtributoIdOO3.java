package plp.orientadaObjetos3.expressao.leftExpression;

import plp.expressions2.memory.Ambiente;
import plp.expressions2.memory.VariavelJaDeclaradaException;
import plp.expressions2.memory.VariavelNaoDeclaradaException;
import plp.orientadaObjetos1.excecao.declaracao.ClasseNaoDeclaradaException;
import plp.orientadaObjetos1.excecao.declaracao.ObjetoNaoDeclaradoException;
import plp.orientadaObjetos1.excecao.declaracao.ProcedimentoNaoDeclaradoException;
import plp.orientadaObjetos1.expressao.leftExpression.Id;
import plp.orientadaObjetos1.expressao.leftExpression.LeftExpression;
import plp.orientadaObjetos1.expressao.valor.Valor;
import plp.orientadaObjetos1.memoria.AmbienteCompilacaoOO1;
import plp.orientadaObjetos1.memoria.AmbienteExecucaoOO1;
import plp.orientadaObjetos1.util.Tipo;
import plp.orientadaObjetos2.expressao.leftExpression.AcessoAtributoIdOO2;
import plp.orientadaObjetos2.memoria.DefClasseOO2;
import plp.orientadaObjetos3.declaracao.constante.Constante;
import plp.orientadaObjetos3.memoria.AmbienteCompilacaoOO3;
import plp.orientadaObjetos3.memoria.AmbienteExecucaoOO3;
import plp.orientadaObjetos3.memoria.DefClasseOO3;
import plp.orientadaObjetos3.memoria.DefModulo;
import plp.orientadaObjetos3.modulo.ListaId;

public class AcessoAtributoIdOO3 extends AcessoAtributoIdOO2{
	
	protected boolean staticCall = false;

	public AcessoAtributoIdOO3(LeftExpression av, Id id) {
		super(av, id);
		// TODO Auto-generated constructor stub
	}

	protected boolean checaTipoClasseMae (AmbienteCompilacaoOO1 ambiente, Id idClasseMae) throws ClasseNaoDeclaradaException {
		boolean retorno = false;
		DefClasseOO2 defSuperClasse = (DefClasseOO2) ambiente.getDefClasse(idClasseMae);
		
		try {
			defSuperClasse.getTipoAtributo(super.getId());
			retorno = true;
		} catch (VariavelNaoDeclaradaException atrib) {
			if (defSuperClasse.getNomeSuperClasse() != null) {
				retorno = this.checaTipoClasseMae(ambiente, defSuperClasse.getNomeSuperClasse());	
			}
   	 	}
   	 		
		return retorno;
	}	
	
	@Override
	public boolean checaTipo(AmbienteCompilacaoOO1 ambiente) throws VariavelNaoDeclaradaException, ClasseNaoDeclaradaException {
        boolean resposta = false;
        	
        	Id idClasse = null;
        	
            try{
            	
            	//aqui se não for um objeto instanciado já lança exception, que vai tratar chamada de constante
            	Tipo tipo = av.getTipo(ambiente);
            	DefClasseOO3 defClasse = (DefClasseOO3) ambiente.getDefClasse(tipo.getTipo());
            	
                if (defClasse.getNomeSuperClasse() != null) {
                	resposta = this.checaTipoClasseMae(ambiente, defClasse.getNomeSuperClasse());
                }
                
                // Se a verificacao pelo atributo nas classes maes nao encontrou nada
                if (!resposta) {
                    defClasse.getTipoAtributo(super.getId());
                    resposta = true;  
                }   
                
            } catch(VariavelNaoDeclaradaException atrib){
            	
            	//Se não é um atributo da classe ou da superclasse, nem constante do objeto, pode ser uma constante estatica.            	//pega Id da classe
            	idClasse = av.getId();
            	//restaura definição da classe
            	DefClasseOO3 defClasse = (DefClasseOO3) ambiente.getDefClasse(idClasse);// checa se a classe existe
    			staticCall = true;
    			
    			//verifica se a constante está declarada em algum dos módulos estendidos
    			
    			try {
    				
    				Constante constante = null;
    				constante = this.getConstanteHierarquia(ambiente, defClasse, super.getId());
    				if(constante != null){
    					resposta = true;
    				}
    				
    			} catch (VariavelNaoDeclaradaException vnd){
    				//TODO avaliar se é melhor retornar false para dar Erro de tipo ou retornar VariavelNaoDeclarada
    				// resposta = false;
    				throw new VariavelNaoDeclaradaException(this.getId());
    			}
            }
        return resposta;
	}
	
	
	private Constante getConstanteHierarquia(Ambiente ambiente,
			DefClasseOO3 defClasse, Id nomeConstante)
			throws ClasseNaoDeclaradaException, VariavelNaoDeclaradaException {
		Constante constante = null;

		try {
			// tenta buscar o metodo no modulo;
			constante = buscaHierarquiaModulo(ambiente, defClasse, nomeConstante);

			// tenta buscar o metodo na superclasse;
		} catch (ProcedimentoNaoDeclaradoException e2) {
			constante = buscaHierarquiaSuperclasse(ambiente, defClasse,
					nomeConstante);
		}
			
		if (constante == null) {
			throw new VariavelNaoDeclaradaException(nomeConstante);
		}
		return constante;
	}
	
	private Constante buscaHierarquiaSuperclasse(Ambiente ambiente,
			DefClasseOO3 defClasse, Id nomeConstante) 
					throws ClasseNaoDeclaradaException, VariavelNaoDeclaradaException {
		
		Constante constante = null;
		if (defClasse.getNomeSuperClasse() != null) {
			if (ambiente instanceof AmbienteCompilacaoOO1) {
				AmbienteCompilacaoOO1 ambienteCompilacao = (AmbienteCompilacaoOO1) ambiente;
				DefClasseOO3 defClasseMae = (DefClasseOO3) ambienteCompilacao
						.getDefClasse(defClasse.getNomeSuperClasse());
				constante = this.getConstanteHierarquia(ambiente, defClasseMae,
						nomeConstante);
			} else if (ambiente instanceof AmbienteExecucaoOO1) {
				AmbienteExecucaoOO1 ambienteExecucao = (AmbienteExecucaoOO1) ambiente;
				DefClasseOO3 defClasseMae = (DefClasseOO3) ambienteExecucao
						.getDefClasse(defClasse.getNomeSuperClasse());
				constante = this.getConstanteHierarquia(ambiente, defClasseMae,
						nomeConstante);
			}
		}
		return constante;
	}

	public Constante buscaHierarquiaModulo(Ambiente ambiente,
			DefClasseOO3 defClasse, Id nomeConstante)
			throws ProcedimentoNaoDeclaradoException {

		Constante constante = null;

		ListaId modules = null;

		if(staticCall){
			modules = defClasse.getListaExtends();
		} else {
			modules = new ListaId();
			modules.addAll(defClasse.getListaInclude());
			modules.addAll(defClasse.getListaExtends());
		}
		
		for (Id id : modules) {

			if (ambiente instanceof AmbienteCompilacaoOO3) {
				DefModulo modulo = ((AmbienteCompilacaoOO3) ambiente)
						.getDefModulo(id);
				if (modulo != null) {
					try {
						constante = modulo.getConstante(nomeConstante);
						return constante;
					} catch (plp.orientadaObjetos1.excecao.declaracao.VariavelNaoDeclaradaException e) {
						continue;
					}
				}

			} else if (ambiente instanceof AmbienteExecucaoOO1) {
				DefModulo modulo = ((AmbienteExecucaoOO3) ambiente)
						.getDefModulo(id);
				if (modulo != null) {
					try {
						constante = modulo.getConstante(nomeConstante);
						return constante;
					} catch (plp.orientadaObjetos1.excecao.declaracao.VariavelNaoDeclaradaException e) {
						continue;
					}
				}
			}
		}

		if (constante == null) {
			throw new VariavelNaoDeclaradaException(nomeConstante);
		}

		return constante;
	}
	
	public Valor avaliar(AmbienteExecucaoOO1 ambiente) 
	        throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException,
            ObjetoNaoDeclaradoException, ClasseNaoDeclaradaException{
		Valor resposta = null;
		Id idClasse = null;
		try {
			resposta = super.avaliar(ambiente);
		} catch (VariavelNaoDeclaradaException vnd){
			
        	//Se não é um atributo da classe ou da superclasse, nem constante do objeto, pode ser uma constante estatica.
        	//pega Id da classe
        	idClasse = av.getId();
        	//restaura definição da classe
        	DefClasseOO3 defClasse = (DefClasseOO3) ambiente.getDefClasse(idClasse);// checa se a classe existe
			staticCall = true;
			
			//verifica se a constante está declarada em algum dos módulos estendidos
			
			try {
				
				Constante constante = null;
				constante = this.getConstanteHierarquia(ambiente, defClasse, super.getId());
				if(constante != null){
					resposta = constante.getValor();
				}
				
			} catch (VariavelNaoDeclaradaException vnd2){
				throw new VariavelNaoDeclaradaException(this.getId());
			}
        }
    return resposta;
	}
}

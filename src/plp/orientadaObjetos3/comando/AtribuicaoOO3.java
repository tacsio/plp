package plp.orientadaObjetos3.comando;

import plp.expressions2.memory.VariavelNaoDeclaradaException;
import plp.orientadaObjetos1.excecao.declaracao.ClasseNaoDeclaradaException;
import plp.orientadaObjetos1.expressao.Expressao;
import plp.orientadaObjetos1.expressao.leftExpression.AcessoAtributoId;
import plp.orientadaObjetos1.expressao.leftExpression.AcessoAtributoThis;
import plp.orientadaObjetos1.expressao.leftExpression.Id;
import plp.orientadaObjetos1.expressao.leftExpression.LeftExpression;
import plp.orientadaObjetos1.memoria.AmbienteCompilacaoOO1;
import plp.orientadaObjetos1.util.Tipo;
import plp.orientadaObjetos2.comando.AtribuicaoOO2;
import plp.orientadaObjetos2.expressao.leftExpression.AcessoAtributoThisOO2;
import plp.orientadaObjetos3.memoria.AmbienteCompilacaoOO3;
import plp.orientadaObjetos3.memoria.DefClasseOO3;

public class AtribuicaoOO3 extends AtribuicaoOO2 {

	public AtribuicaoOO3(LeftExpression av, Expressao expressao) {
		super(av, expressao);
	}

	public boolean checaTipo(AmbienteCompilacaoOO1 ambiente)
			throws VariavelNaoDeclaradaException, ClasseNaoDeclaradaException {
		boolean retorno = super.checaTipo(ambiente);

		// caso retorno seja positivo, verificamos se é constante para retornar
		// falso (não pode atribuir)
		if (retorno) {

			if ((av instanceof AcessoAtributoId)) {

				Tipo tipoLeftExpression = ((AcessoAtributoId) av).getAv()
						.getTipo(ambiente);
				DefClasseOO3 defClasse = (DefClasseOO3) ambiente
						.getDefClasse(tipoLeftExpression.getTipo());


				// antes de checar se é constante, precisamos ver se a classe
				// tem variável
				// com mesmo id, pois caso seja poderemos atribuir.
				if(buscarConstanteClasses(av.getId(), defClasse, (AmbienteCompilacaoOO3) ambiente)){
					retorno = false;
					System.out.println();
					System.out.println("Não é possível modificar o valor da constante: " + av.getId());
				}

			} else if (av instanceof AcessoAtributoThis) {

				Tipo tipoLeftExpression = ((AcessoAtributoThisOO2) av)
						.getExpressaoObjeto().getTipo(ambiente);
				DefClasseOO3 defClasse = (DefClasseOO3) ambiente
						.getDefClasse(tipoLeftExpression.getTipo());
				
				// antes de checar se é constante, precisamos ver se a classe
				// tem variável
				// com mesmo id, pois caso seja poderemos atribuir.
				if(buscarConstanteClasses(av.getId(), defClasse, (AmbienteCompilacaoOO3) ambiente)){
					retorno = false;
					System.out.println();
					System.out.println("Não é possível modificar o valor da constante: " + av.getId());
				}
			}

		}

		return retorno;
	}

	private boolean buscarConstanteClasses(Id idConstante,
			DefClasseOO3 defClasse, AmbienteCompilacaoOO3 ambiente) {

		boolean retorno = false;

		Id idClass = defClasse.getIdClasse();
		try {
			do {
				DefClasseOO3 classe = (DefClasseOO3) ambiente.getDefClasse(idClass);
				idClass = classe.getNomeSuperClasse();

				try {
					classe.getDecVariavel().getTipo(idConstante);
					idClass = null;//forcar saida do loop ja que exite um atributo
				} catch (VariavelNaoDeclaradaException vnd) {
					if (classe.getConstante(idConstante) != null) {
						retorno = true;
					}
				}

			} while (retorno != true || idClass != null);
		} catch (ClasseNaoDeclaradaException e) {
		}

		return retorno;
	}
}

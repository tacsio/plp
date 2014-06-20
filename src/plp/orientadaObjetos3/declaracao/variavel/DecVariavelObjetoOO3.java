package plp.orientadaObjetos3.declaracao.variavel;

import plp.expressions2.memory.VariavelJaDeclaradaException;
import plp.expressions2.memory.VariavelNaoDeclaradaException;
import plp.orientadaObjetos1.declaracao.variavel.SimplesDecVariavel;
import plp.orientadaObjetos1.excecao.declaracao.ClasseNaoDeclaradaException;
import plp.orientadaObjetos1.excecao.declaracao.ObjetoJaDeclaradoException;
import plp.orientadaObjetos1.excecao.declaracao.ObjetoNaoDeclaradoException;
import plp.orientadaObjetos1.expressao.ListaExpressao;
import plp.orientadaObjetos1.expressao.leftExpression.Id;
import plp.orientadaObjetos1.expressao.valor.ValorNull;
import plp.orientadaObjetos1.memoria.AmbienteExecucaoOO1;
import plp.orientadaObjetos1.util.Tipo;
import plp.orientadaObjetos2.declaracao.variavel.DecVariavelObjetoOO2;
import plp.orientadaObjetos2.memoria.AmbienteExecucaoOO2;
import plp.orientadaObjetos3.comando.NewOO3;

public class DecVariavelObjetoOO3 extends DecVariavelObjetoOO2 {

	private ListaExpressao parametrosReais;

	public DecVariavelObjetoOO3(Tipo tipo, Id objeto, Id classe,
			ListaExpressao parametrosReais) {
		super(tipo, objeto, classe, parametrosReais);
		this.parametrosReais = parametrosReais;
	}

	
	@Override
	public AmbienteExecucaoOO1 elabora(AmbienteExecucaoOO1 ambiente)
			throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException,
			ObjetoNaoDeclaradoException, ObjetoJaDeclaradoException,
			ClasseNaoDeclaradaException {
		
		AmbienteExecucaoOO2 aux = (AmbienteExecucaoOO2) new SimplesDecVariavel(
				getTipo(), getObjeto(), new ValorNull()).elabora(ambiente);

		try {
			aux = new NewOO3(getObjeto(), getClasse(), parametrosReais)
					.executar(aux);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return aux;
	}
}

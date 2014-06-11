package plp.orientadaObjetos3;

import plp.expressions2.memory.VariavelJaDeclaradaException;
import plp.expressions2.memory.VariavelNaoDeclaradaException;
import plp.orientadaObjetos1.comando.Comando;
import plp.orientadaObjetos1.excecao.declaracao.ClasseJaDeclaradaException;
import plp.orientadaObjetos1.excecao.declaracao.ClasseNaoDeclaradaException;
import plp.orientadaObjetos1.excecao.declaracao.ObjetoJaDeclaradoException;
import plp.orientadaObjetos1.excecao.declaracao.ObjetoNaoDeclaradoException;
import plp.orientadaObjetos1.excecao.declaracao.ProcedimentoJaDeclaradoException;
import plp.orientadaObjetos1.excecao.declaracao.ProcedimentoNaoDeclaradoException;
import plp.orientadaObjetos1.excecao.execucao.EntradaInvalidaException;
import plp.orientadaObjetos1.excecao.execucao.EntradaNaoFornecidaException;
import plp.orientadaObjetos1.memoria.colecao.ListaValor;
import plp.orientadaObjetos2.declaracao.ConstrutorNaoDeclaradoException;
import plp.orientadaObjetos3.declaracao.ListaDeclaracaoOO3;
import plp.orientadaObjetos3.excecao.declaracao.ModuloJaDeclaradoException;
import plp.orientadaObjetos3.memoria.AmbienteCompilacaoOO3;
import plp.orientadaObjetos3.memoria.AmbienteExecucaoOO3;

public class Programa {

	private ListaDeclaracaoOO3 declaracoesOO;
	private Comando comando;

	public Programa(ListaDeclaracaoOO3 dec, Comando comando) {
		this.declaracoesOO = dec;
		this.comando = comando;
	}

	public ListaValor executar(AmbienteExecucaoOO3 ambiente)
			throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException,
			ObjetoJaDeclaradoException, ObjetoNaoDeclaradoException,
			ProcedimentoNaoDeclaradoException,
			ProcedimentoJaDeclaradoException, ClasseJaDeclaradaException,
			EntradaInvalidaException, EntradaNaoFornecidaException,
			ConstrutorNaoDeclaradoException, ClasseNaoDeclaradaException {

		if (ambiente == null)
			throw new EntradaNaoFornecidaException();

		ambiente.incrementa();
		ambiente = (AmbienteExecucaoOO3) comando.executar(declaracoesOO
				.elabora(ambiente));
		ambiente.restaura();
		return ambiente.getSaida();
	}

	public boolean checaTipo(AmbienteCompilacaoOO3 ambiente)
			throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException,
			ProcedimentoNaoDeclaradoException,
			ProcedimentoJaDeclaradoException, ClasseJaDeclaradaException,
			 EntradaNaoFornecidaException,
			ConstrutorNaoDeclaradoException, ModuloJaDeclaradoException, ClasseNaoDeclaradaException {

		boolean resposta;
		if (ambiente == null) {
			throw new EntradaNaoFornecidaException();
		}
		ambiente.incrementa();
		resposta = declaracoesOO.checaTipo((AmbienteCompilacaoOO3) ambiente)
				&& comando.checaTipo(ambiente);
		ambiente.restaura();
		return resposta;
	}
}

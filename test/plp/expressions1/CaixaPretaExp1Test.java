package plp.expressions1;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import plp.UtilCaixaPreta;
import plp.expressions1.parser.Exp1Parser;
import plp.expressions1.parser.ParseException;

@RunWith(Parameterized.class)
public class CaixaPretaExp1Test {

    static Exp1Parser parser;
    String input;
    private String resultado;
    private boolean aceitoTipo;
    private boolean aceitoValor;
    private boolean aceitoExcecao;

    public CaixaPretaExp1Test(String input, String resultado, boolean aceitoTipo, boolean aceitoValor
            , boolean aceitoExcecao) {
        super();
        this.input = input;
        this.resultado = resultado;
        this.aceitoTipo = aceitoTipo;
        this.aceitoValor = aceitoValor;
        this.aceitoExcecao = aceitoExcecao;
    }

    @Before
    public void setup() {
        Exp1Parser.disable_tracing();
        ByteArrayInputStream bis = new ByteArrayInputStream(input.getBytes());
        if (parser == null)
            parser = new Exp1Parser(bis);
        else
            Exp1Parser.ReInit(bis);

    }

    @Test
    public void testInput() throws ParseException {
       
        try{
            Programa programa = Exp1Parser.Input();   
            boolean tipoOK = programa.checaTipo();

            assertThat("Erro de Tipo no programa: \n" + input,
                    tipoOK, is(this.aceitoTipo));
           
            if (tipoOK){
                String valor = programa.executar().toString();
                boolean valorOK = valor.equalsIgnoreCase(resultado);                   
                assertThat("Resultado errado para a avaliação de:\n" + input, valorOK, is(this.aceitoValor));
            }           

            if  (this.aceitoExcecao){
                fail("Deveria lançar Excecao");               
            }

        }catch(Exception e){
        	if  (!this.aceitoExcecao){
        		e.printStackTrace();         
            }        	 
        }
       
    }

    @Parameters
    public static List<Object[]> data() {
        ArrayList<Object[]> data = new ArrayList<Object[]>();
        data.addAll(UtilCaixaPreta.getEntradaExp1Test());       
        return data;

    }
}
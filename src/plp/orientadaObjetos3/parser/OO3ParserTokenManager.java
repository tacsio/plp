/* Generated By:JavaCC: Do not edit this line. OO3ParserTokenManager.java */
package plp.orientadaObjetos3.parser;
import java.util.List;
import plp.orientadaObjetos1.comando.ChamadaMetodo;
import plp.orientadaObjetos1.comando.ComDeclaracao;
import plp.orientadaObjetos1.comando.Comando;
import plp.orientadaObjetos1.comando.IO;
import plp.orientadaObjetos1.comando.IfThenElse;
import plp.orientadaObjetos1.comando.Read;
import plp.orientadaObjetos1.comando.Sequencial;
import plp.orientadaObjetos1.comando.Skip;
import plp.orientadaObjetos1.comando.While;
import plp.orientadaObjetos1.comando.Write;
import plp.orientadaObjetos1.comando.Procedimento;
import plp.orientadaObjetos1.declaracao.Declaracao;
import plp.orientadaObjetos1.declaracao.classe.DecClasse;
import plp.orientadaObjetos1.declaracao.procedimento.DecParametro;
import plp.orientadaObjetos1.declaracao.procedimento.DecProcedimento;
import plp.orientadaObjetos1.declaracao.procedimento.DecProcedimentoComposta;
import plp.orientadaObjetos1.declaracao.procedimento.DecProcedimentoSimples;
import plp.orientadaObjetos1.declaracao.procedimento.ListaDeclaracaoParametro;
import plp.orientadaObjetos1.declaracao.variavel.CompostaDecVariavel;
import plp.orientadaObjetos1.declaracao.variavel.DecVariavel;
import plp.orientadaObjetos1.declaracao.variavel.SimplesDecVariavel;
import plp.orientadaObjetos1.expressao.Expressao;
import plp.orientadaObjetos1.expressao.ListaExpressao;
import plp.orientadaObjetos1.expressao.This;
import plp.orientadaObjetos1.expressao.binaria.ExpAnd;
import plp.orientadaObjetos1.expressao.binaria.ExpConcat;
import plp.orientadaObjetos1.expressao.binaria.ExpEquals;
import plp.orientadaObjetos1.expressao.binaria.ExpOr;
import plp.orientadaObjetos1.expressao.binaria.ExpSoma;
import plp.orientadaObjetos1.expressao.binaria.ExpSub;
import plp.orientadaObjetos1.expressao.leftExpression.AcessoAtributo;
import plp.orientadaObjetos1.expressao.leftExpression.Id;
import plp.orientadaObjetos1.expressao.leftExpression.LeftExpression;
import plp.orientadaObjetos1.expressao.unaria.ExpLength;
import plp.orientadaObjetos1.expressao.unaria.ExpMenos;
import plp.orientadaObjetos1.expressao.unaria.ExpNot;
import plp.orientadaObjetos1.expressao.valor.Valor;
import plp.orientadaObjetos1.expressao.valor.ValorBooleano;
import plp.orientadaObjetos1.expressao.valor.ValorInteiro;
import plp.orientadaObjetos1.expressao.valor.ValorNull;
import plp.orientadaObjetos1.expressao.valor.ValorString;
import plp.orientadaObjetos1.memoria.colecao.ListaValor;
import plp.orientadaObjetos1.util.Tipo;
import plp.orientadaObjetos1.util.TipoClasse;
import plp.orientadaObjetos1.util.TipoPrimitivo;
import plp.orientadaObjetos3.Programa;
import plp.orientadaObjetos2.declaracao.DecConstrutor;
import plp.orientadaObjetos3.memoria.ContextoCompilacaoOO3;
import plp.orientadaObjetos3.memoria.ContextoExecucaoOO3;
import plp.orientadaObjetos2.comando.*;
import plp.orientadaObjetos2.expressao.leftExpression.*;
import plp.orientadaObjetos3.modulo.ListaId;
import plp.orientadaObjetos3.modulo.UsaModulo;
import plp.orientadaObjetos3.declaracao.classe.DecClasseSimplesOO3;
import plp.orientadaObjetos3.declaracao.constante.*;
import plp.orientadaObjetos3.declaracao.modulo.DecModulo;
import plp.orientadaObjetos3.declaracao.ListaDeclaracaoOO3;
import plp.orientadaObjetos3.comando.ChamadaMetodoOO3;
import plp.orientadaObjetos3.comando.NewOO3;
import plp.orientadaObjetos3.comando.AtribuicaoOO3;
import plp.orientadaObjetos3.declaracao.variavel.DecVariavelObjetoOO3;

public class OO3ParserTokenManager implements OO3ParserConstants
{
  public  java.io.PrintStream debugStream = System.out;
  public  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private final int jjStopStringLiteralDfa_0(int pos, long active0, long active1)
{
   switch (pos)
   {
      case 0:
         if ((active1 & 0x40L) != 0L)
            return 19;
         if ((active0 & 0x7fffffe00L) != 0L)
         {
            jjmatchedKind = 40;
            return 13;
         }
         return -1;
      case 1:
         if ((active0 & 0x240400L) != 0L)
            return 13;
         if ((active0 & 0x7ffdbfa00L) != 0L)
         {
            jjmatchedKind = 40;
            jjmatchedPos = 1;
            return 13;
         }
         return -1;
      case 2:
         if ((active0 & 0x6fedb7000L) != 0L)
         {
            jjmatchedKind = 40;
            jjmatchedPos = 2;
            return 13;
         }
         if ((active0 & 0x101008a00L) != 0L)
            return 13;
         return -1;
      case 3:
         if ((active0 & 0x1ac92000L) != 0L)
            return 13;
         if ((active0 & 0x6e4125000L) != 0L)
         {
            jjmatchedKind = 40;
            jjmatchedPos = 3;
            return 13;
         }
         return -1;
      case 4:
         if ((active0 & 0x124000L) != 0L)
            return 13;
         if ((active0 & 0x6e4001000L) != 0L)
         {
            jjmatchedKind = 40;
            jjmatchedPos = 4;
            return 13;
         }
         return -1;
      case 5:
         if ((active0 & 0x260000000L) != 0L)
         {
            jjmatchedKind = 40;
            jjmatchedPos = 5;
            return 13;
         }
         if ((active0 & 0x484001000L) != 0L)
            return 13;
         return -1;
      default :
         return -1;
   }
}
private final int jjStartNfa_0(int pos, long active0, long active1)
{
   return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0, active1), pos + 1);
}
private final int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
private final int jjStartNfaWithStates_0(int pos, int kind, int state)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) { return pos + 1; }
   return jjMoveNfa_0(state, pos + 1);
}
private final int jjMoveStringLiteralDfa0_0()
{
   switch(curChar)
   {
      case 33:
         jjmatchedKind = 56;
         return jjMoveStringLiteralDfa1_0(0x8000000000000000L, 0x0L);
      case 37:
         return jjStopAtPos(0, 74);
      case 38:
         jjmatchedKind = 71;
         return jjMoveStringLiteralDfa1_0(0x0L, 0x2L);
      case 40:
         return jjStopAtPos(0, 43);
      case 41:
         return jjStopAtPos(0, 44);
      case 42:
         return jjStopAtPos(0, 69);
      case 43:
         jjmatchedKind = 67;
         return jjMoveStringLiteralDfa1_0(0x0L, 0x4L);
      case 44:
         return jjStopAtPos(0, 50);
      case 45:
         return jjStopAtPos(0, 68);
      case 46:
         return jjStopAtPos(0, 51);
      case 47:
         return jjStartNfaWithStates_0(0, 70, 19);
      case 58:
         jjmatchedKind = 59;
         return jjMoveStringLiteralDfa1_0(0x10000000000000L, 0x0L);
      case 59:
         return jjStopAtPos(0, 49);
      case 60:
         jjmatchedKind = 55;
         return jjMoveStringLiteralDfa1_0(0x2000000000000000L, 0x0L);
      case 61:
         jjmatchedKind = 53;
         return jjMoveStringLiteralDfa1_0(0x1000000000000000L, 0x0L);
      case 62:
         jjmatchedKind = 54;
         return jjMoveStringLiteralDfa1_0(0x4000000000000000L, 0x0L);
      case 63:
         return jjStopAtPos(0, 58);
      case 91:
         return jjStopAtPos(0, 47);
      case 93:
         return jjStopAtPos(0, 48);
      case 94:
         return jjStopAtPos(0, 73);
      case 97:
         return jjMoveStringLiteralDfa1_0(0x200L, 0x0L);
      case 98:
         return jjMoveStringLiteralDfa1_0(0x200000000L, 0x0L);
      case 99:
         return jjMoveStringLiteralDfa1_0(0x4000000L, 0x0L);
      case 100:
         return jjMoveStringLiteralDfa1_0(0x40000L, 0x0L);
      case 101:
         return jjMoveStringLiteralDfa1_0(0x20800000L, 0x0L);
      case 102:
         return jjMoveStringLiteralDfa1_0(0x4000L, 0x0L);
      case 105:
         return jjMoveStringLiteralDfa1_0(0x140200000L, 0x0L);
      case 108:
         return jjMoveStringLiteralDfa1_0(0x1000L, 0x0L);
      case 109:
         return jjMoveStringLiteralDfa1_0(0x80000000L, 0x0L);
      case 110:
         return jjMoveStringLiteralDfa1_0(0x9000800L, 0x0L);
      case 111:
         return jjMoveStringLiteralDfa1_0(0x400L, 0x0L);
      case 112:
         return jjMoveStringLiteralDfa1_0(0x10000000L, 0x0L);
      case 114:
         return jjMoveStringLiteralDfa1_0(0x80000L, 0x0L);
      case 115:
         return jjMoveStringLiteralDfa1_0(0x400010000L, 0x0L);
      case 116:
         return jjMoveStringLiteralDfa1_0(0x2402000L, 0x0L);
      case 118:
         return jjMoveStringLiteralDfa1_0(0x8000L, 0x0L);
      case 119:
         return jjMoveStringLiteralDfa1_0(0x120000L, 0x0L);
      case 123:
         return jjStopAtPos(0, 45);
      case 124:
         jjmatchedKind = 72;
         return jjMoveStringLiteralDfa1_0(0x0L, 0x1L);
      case 125:
         return jjStopAtPos(0, 46);
      case 126:
         return jjStopAtPos(0, 57);
      default :
         return jjMoveNfa_0(0, 0);
   }
}
private final int jjMoveStringLiteralDfa1_0(long active0, long active1)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(0, active0, active1);
      return 1;
   }
   switch(curChar)
   {
      case 38:
         if ((active1 & 0x2L) != 0L)
            return jjStopAtPos(1, 65);
         break;
      case 43:
         if ((active1 & 0x4L) != 0L)
            return jjStopAtPos(1, 66);
         break;
      case 61:
         if ((active0 & 0x10000000000000L) != 0L)
            return jjStopAtPos(1, 52);
         else if ((active0 & 0x1000000000000000L) != 0L)
            return jjStopAtPos(1, 60);
         else if ((active0 & 0x2000000000000000L) != 0L)
            return jjStopAtPos(1, 61);
         else if ((active0 & 0x4000000000000000L) != 0L)
            return jjStopAtPos(1, 62);
         else if ((active0 & 0x8000000000000000L) != 0L)
            return jjStopAtPos(1, 63);
         break;
      case 97:
         return jjMoveStringLiteralDfa2_0(active0, 0xc000L, active1, 0L);
      case 101:
         return jjMoveStringLiteralDfa2_0(active0, 0x1081000L, active1, 0L);
      case 102:
         if ((active0 & 0x200000L) != 0L)
            return jjStartNfaWithStates_0(1, 21, 13);
         break;
      case 104:
         return jjMoveStringLiteralDfa2_0(active0, 0x2420000L, active1, 0L);
      case 107:
         return jjMoveStringLiteralDfa2_0(active0, 0x10000L, active1, 0L);
      case 108:
         return jjMoveStringLiteralDfa2_0(active0, 0x4800000L, active1, 0L);
      case 110:
         return jjMoveStringLiteralDfa2_0(active0, 0x140000200L, active1, 0L);
      case 111:
         if ((active0 & 0x40000L) != 0L)
            return jjStartNfaWithStates_0(1, 18, 13);
         return jjMoveStringLiteralDfa2_0(active0, 0x280000800L, active1, 0L);
      case 114:
         if ((active0 & 0x400L) != 0L)
            return jjStartNfaWithStates_0(1, 10, 13);
         return jjMoveStringLiteralDfa2_0(active0, 0x10102000L, active1, 0L);
      case 116:
         return jjMoveStringLiteralDfa2_0(active0, 0x400000000L, active1, 0L);
      case 117:
         return jjMoveStringLiteralDfa2_0(active0, 0x8000000L, active1, 0L);
      case 120:
         return jjMoveStringLiteralDfa2_0(active0, 0x20000000L, active1, 0L);
      case 124:
         if ((active1 & 0x1L) != 0L)
            return jjStopAtPos(1, 64);
         break;
      default :
         break;
   }
   return jjStartNfa_0(0, active0, active1);
}
private final int jjMoveStringLiteralDfa2_0(long old0, long active0, long old1, long active1)
{
   if (((active0 &= old0) | (active1 &= old1)) == 0L)
      return jjStartNfa_0(0, old0, old1); 
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(1, active0, 0L);
      return 2;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa3_0(active0, 0x4080000L);
      case 99:
         return jjMoveStringLiteralDfa3_0(active0, 0x40000000L);
      case 100:
         if ((active0 & 0x200L) != 0L)
            return jjStartNfaWithStates_0(2, 9, 13);
         return jjMoveStringLiteralDfa3_0(active0, 0x80000000L);
      case 101:
         return jjMoveStringLiteralDfa3_0(active0, 0x400000L);
      case 105:
         return jjMoveStringLiteralDfa3_0(active0, 0x2130000L);
      case 108:
         return jjMoveStringLiteralDfa3_0(active0, 0x8004000L);
      case 110:
         return jjMoveStringLiteralDfa3_0(active0, 0x1000L);
      case 111:
         return jjMoveStringLiteralDfa3_0(active0, 0x210000000L);
      case 114:
         if ((active0 & 0x8000L) != 0L)
            return jjStartNfaWithStates_0(2, 15, 13);
         return jjMoveStringLiteralDfa3_0(active0, 0x400000000L);
      case 115:
         return jjMoveStringLiteralDfa3_0(active0, 0x800000L);
      case 116:
         if ((active0 & 0x800L) != 0L)
            return jjStartNfaWithStates_0(2, 11, 13);
         else if ((active0 & 0x100000000L) != 0L)
            return jjStartNfaWithStates_0(2, 32, 13);
         return jjMoveStringLiteralDfa3_0(active0, 0x20000000L);
      case 117:
         return jjMoveStringLiteralDfa3_0(active0, 0x2000L);
      case 119:
         if ((active0 & 0x1000000L) != 0L)
            return jjStartNfaWithStates_0(2, 24, 13);
         break;
      default :
         break;
   }
   return jjStartNfa_0(1, active0, 0L);
}
private final int jjMoveStringLiteralDfa3_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(1, old0, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(2, active0, 0L);
      return 3;
   }
   switch(curChar)
   {
      case 99:
         if ((active0 & 0x10000000L) != 0L)
            return jjStartNfaWithStates_0(3, 28, 13);
         break;
      case 100:
         if ((active0 & 0x80000L) != 0L)
            return jjStartNfaWithStates_0(3, 19, 13);
         break;
      case 101:
         if ((active0 & 0x2000L) != 0L)
            return jjStartNfaWithStates_0(3, 13, 13);
         else if ((active0 & 0x800000L) != 0L)
            return jjStartNfaWithStates_0(3, 23, 13);
         return jjMoveStringLiteralDfa4_0(active0, 0x20000000L);
      case 103:
         return jjMoveStringLiteralDfa4_0(active0, 0x1000L);
      case 105:
         return jjMoveStringLiteralDfa4_0(active0, 0x400000000L);
      case 108:
         if ((active0 & 0x8000000L) != 0L)
            return jjStartNfaWithStates_0(3, 27, 13);
         return jjMoveStringLiteralDfa4_0(active0, 0x240020000L);
      case 110:
         if ((active0 & 0x400000L) != 0L)
            return jjStartNfaWithStates_0(3, 22, 13);
         break;
      case 112:
         if ((active0 & 0x10000L) != 0L)
            return jjStartNfaWithStates_0(3, 16, 13);
         break;
      case 115:
         if ((active0 & 0x2000000L) != 0L)
            return jjStartNfaWithStates_0(3, 25, 13);
         return jjMoveStringLiteralDfa4_0(active0, 0x4004000L);
      case 116:
         return jjMoveStringLiteralDfa4_0(active0, 0x100000L);
      case 117:
         return jjMoveStringLiteralDfa4_0(active0, 0x80000000L);
      default :
         break;
   }
   return jjStartNfa_0(2, active0, 0L);
}
private final int jjMoveStringLiteralDfa4_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(2, old0, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(3, active0, 0L);
      return 4;
   }
   switch(curChar)
   {
      case 101:
         if ((active0 & 0x4000L) != 0L)
            return jjStartNfaWithStates_0(4, 14, 13);
         else if ((active0 & 0x20000L) != 0L)
            return jjStartNfaWithStates_0(4, 17, 13);
         else if ((active0 & 0x100000L) != 0L)
            return jjStartNfaWithStates_0(4, 20, 13);
         return jjMoveStringLiteralDfa5_0(active0, 0x200000000L);
      case 108:
         return jjMoveStringLiteralDfa5_0(active0, 0x80000000L);
      case 110:
         return jjMoveStringLiteralDfa5_0(active0, 0x420000000L);
      case 115:
         return jjMoveStringLiteralDfa5_0(active0, 0x4000000L);
      case 116:
         return jjMoveStringLiteralDfa5_0(active0, 0x1000L);
      case 117:
         return jjMoveStringLiteralDfa5_0(active0, 0x40000000L);
      default :
         break;
   }
   return jjStartNfa_0(3, active0, 0L);
}
private final int jjMoveStringLiteralDfa5_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(3, old0, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(4, active0, 0L);
      return 5;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa6_0(active0, 0x200000000L);
      case 100:
         return jjMoveStringLiteralDfa6_0(active0, 0x60000000L);
      case 101:
         if ((active0 & 0x4000000L) != 0L)
            return jjStartNfaWithStates_0(5, 26, 13);
         else if ((active0 & 0x80000000L) != 0L)
            return jjStartNfaWithStates_0(5, 31, 13);
         break;
      case 103:
         if ((active0 & 0x400000000L) != 0L)
            return jjStartNfaWithStates_0(5, 34, 13);
         break;
      case 104:
         if ((active0 & 0x1000L) != 0L)
            return jjStartNfaWithStates_0(5, 12, 13);
         break;
      default :
         break;
   }
   return jjStartNfa_0(4, active0, 0L);
}
private final int jjMoveStringLiteralDfa6_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(4, old0, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(5, active0, 0L);
      return 6;
   }
   switch(curChar)
   {
      case 101:
         if ((active0 & 0x40000000L) != 0L)
            return jjStartNfaWithStates_0(6, 30, 13);
         break;
      case 110:
         if ((active0 & 0x200000000L) != 0L)
            return jjStartNfaWithStates_0(6, 33, 13);
         break;
      case 115:
         if ((active0 & 0x20000000L) != 0L)
            return jjStartNfaWithStates_0(6, 29, 13);
         break;
      default :
         break;
   }
   return jjStartNfa_0(5, active0, 0L);
}
private final void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
private final void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
private final void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}
private final void jjCheckNAddStates(int start, int end)
{
   do {
      jjCheckNAdd(jjnextStates[start]);
   } while (start++ != end);
}
private final void jjCheckNAddStates(int start)
{
   jjCheckNAdd(jjnextStates[start]);
   jjCheckNAdd(jjnextStates[start + 1]);
}
static final long[] jjbitVec0 = {
   0xfffffffffffffffeL, 0xffffffffffffffffL, 0xffffffffffffffffL, 0xffffffffffffffffL
};
static final long[] jjbitVec2 = {
   0x0L, 0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL
};
static final long[] jjbitVec3 = {
   0x1ff00000fffffffeL, 0xffffffffffffc000L, 0xffffffffL, 0x600000000000000L
};
static final long[] jjbitVec4 = {
   0x0L, 0x0L, 0x0L, 0xff7fffffff7fffffL
};
static final long[] jjbitVec5 = {
   0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL, 0xffffffffffffffffL
};
static final long[] jjbitVec6 = {
   0xffffffffffffffffL, 0xffffffffffffffffL, 0xffffL, 0x0L
};
static final long[] jjbitVec7 = {
   0xffffffffffffffffL, 0xffffffffffffffffL, 0x0L, 0x0L
};
static final long[] jjbitVec8 = {
   0x3fffffffffffL, 0x0L, 0x0L, 0x0L
};
private final int jjMoveNfa_0(int startState, int curPos)
{
   int[] nextStates;
   int startsAt = 0;
   jjnewStateCnt = 37;
   int i = 1;
   jjstateSet[0] = startState;
   int j, kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         MatchLoop: do
         {
            switch(jjstateSet[--i])
            {
               case 19:
                  if (curChar == 42)
                     jjCheckNAddTwoStates(32, 33);
                  else if (curChar == 47)
                     jjCheckNAddStates(0, 2);
                  if (curChar == 42)
                     jjstateSet[jjnewStateCnt++] = 24;
                  break;
               case 0:
                  if ((0x3fe000000000000L & l) != 0L)
                  {
                     if (kind > 35)
                        kind = 35;
                     jjCheckNAddTwoStates(1, 2);
                  }
                  else if (curChar == 47)
                     jjAddStates(3, 5);
                  else if (curChar == 48)
                  {
                     if (kind > 35)
                        kind = 35;
                     jjCheckNAddStates(6, 8);
                  }
                  else if (curChar == 36)
                  {
                     if (kind > 40)
                        kind = 40;
                     jjCheckNAdd(13);
                  }
                  else if (curChar == 34)
                     jjCheckNAddStates(9, 11);
                  break;
               case 1:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 35)
                     kind = 35;
                  jjCheckNAddTwoStates(1, 2);
                  break;
               case 3:
                  if (curChar == 34)
                     jjCheckNAddStates(9, 11);
                  break;
               case 4:
                  if ((0xfffffffbffffdbffL & l) != 0L)
                     jjCheckNAddStates(9, 11);
                  break;
               case 6:
                  if ((0x8400000000L & l) != 0L)
                     jjCheckNAddStates(9, 11);
                  break;
               case 7:
                  if (curChar == 34 && kind > 39)
                     kind = 39;
                  break;
               case 8:
                  if ((0xff000000000000L & l) != 0L)
                     jjCheckNAddStates(12, 15);
                  break;
               case 9:
                  if ((0xff000000000000L & l) != 0L)
                     jjCheckNAddStates(9, 11);
                  break;
               case 10:
                  if ((0xf000000000000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 11;
                  break;
               case 11:
                  if ((0xff000000000000L & l) != 0L)
                     jjCheckNAdd(9);
                  break;
               case 12:
                  if (curChar != 36)
                     break;
                  if (kind > 40)
                     kind = 40;
                  jjCheckNAdd(13);
                  break;
               case 13:
                  if ((0x3ff001000000000L & l) == 0L)
                     break;
                  if (kind > 40)
                     kind = 40;
                  jjCheckNAdd(13);
                  break;
               case 14:
                  if (curChar != 48)
                     break;
                  if (kind > 35)
                     kind = 35;
                  jjCheckNAddStates(6, 8);
                  break;
               case 16:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 35)
                     kind = 35;
                  jjCheckNAddTwoStates(16, 2);
                  break;
               case 17:
                  if ((0xff000000000000L & l) == 0L)
                     break;
                  if (kind > 35)
                     kind = 35;
                  jjCheckNAddTwoStates(17, 2);
                  break;
               case 18:
                  if (curChar == 47)
                     jjAddStates(3, 5);
                  break;
               case 20:
                  if ((0xffffffffffffdbffL & l) != 0L)
                     jjCheckNAddStates(0, 2);
                  break;
               case 21:
                  if ((0x2400L & l) != 0L && kind > 6)
                     kind = 6;
                  break;
               case 22:
                  if (curChar == 10 && kind > 6)
                     kind = 6;
                  break;
               case 23:
                  if (curChar == 13)
                     jjstateSet[jjnewStateCnt++] = 22;
                  break;
               case 24:
                  if (curChar == 42)
                     jjCheckNAddTwoStates(25, 26);
                  break;
               case 25:
                  if ((0xfffffbffffffffffL & l) != 0L)
                     jjCheckNAddTwoStates(25, 26);
                  break;
               case 26:
                  if (curChar == 42)
                     jjCheckNAddStates(16, 18);
                  break;
               case 27:
                  if ((0xffff7bffffffffffL & l) != 0L)
                     jjCheckNAddTwoStates(28, 26);
                  break;
               case 28:
                  if ((0xfffffbffffffffffL & l) != 0L)
                     jjCheckNAddTwoStates(28, 26);
                  break;
               case 29:
                  if (curChar == 47 && kind > 7)
                     kind = 7;
                  break;
               case 30:
                  if (curChar == 42)
                     jjstateSet[jjnewStateCnt++] = 24;
                  break;
               case 31:
                  if (curChar == 42)
                     jjCheckNAddTwoStates(32, 33);
                  break;
               case 32:
                  if ((0xfffffbffffffffffL & l) != 0L)
                     jjCheckNAddTwoStates(32, 33);
                  break;
               case 33:
                  if (curChar == 42)
                     jjCheckNAddStates(19, 21);
                  break;
               case 34:
                  if ((0xffff7bffffffffffL & l) != 0L)
                     jjCheckNAddTwoStates(35, 33);
                  break;
               case 35:
                  if ((0xfffffbffffffffffL & l) != 0L)
                     jjCheckNAddTwoStates(35, 33);
                  break;
               case 36:
                  if (curChar == 47 && kind > 8)
                     kind = 8;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         MatchLoop: do
         {
            switch(jjstateSet[--i])
            {
               case 0:
               case 13:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 40)
                     kind = 40;
                  jjCheckNAdd(13);
                  break;
               case 2:
                  if ((0x100000001000L & l) != 0L && kind > 35)
                     kind = 35;
                  break;
               case 4:
                  if ((0xffffffffefffffffL & l) != 0L)
                     jjCheckNAddStates(9, 11);
                  break;
               case 5:
                  if (curChar == 92)
                     jjAddStates(22, 24);
                  break;
               case 6:
                  if ((0x14404410000000L & l) != 0L)
                     jjCheckNAddStates(9, 11);
                  break;
               case 15:
                  if ((0x100000001000000L & l) != 0L)
                     jjCheckNAdd(16);
                  break;
               case 16:
                  if ((0x7e0000007eL & l) == 0L)
                     break;
                  if (kind > 35)
                     kind = 35;
                  jjCheckNAddTwoStates(16, 2);
                  break;
               case 20:
                  jjAddStates(0, 2);
                  break;
               case 25:
                  jjCheckNAddTwoStates(25, 26);
                  break;
               case 27:
               case 28:
                  jjCheckNAddTwoStates(28, 26);
                  break;
               case 32:
                  jjCheckNAddTwoStates(32, 33);
                  break;
               case 34:
               case 35:
                  jjCheckNAddTwoStates(35, 33);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int hiByte = (int)(curChar >> 8);
         int i1 = hiByte >> 6;
         long l1 = 1L << (hiByte & 077);
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         MatchLoop: do
         {
            switch(jjstateSet[--i])
            {
               case 0:
               case 13:
                  if (!jjCanMove_1(hiByte, i1, i2, l1, l2))
                     break;
                  if (kind > 40)
                     kind = 40;
                  jjCheckNAdd(13);
                  break;
               case 4:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjAddStates(9, 11);
                  break;
               case 20:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjAddStates(0, 2);
                  break;
               case 25:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjCheckNAddTwoStates(25, 26);
                  break;
               case 27:
               case 28:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjCheckNAddTwoStates(28, 26);
                  break;
               case 32:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjCheckNAddTwoStates(32, 33);
                  break;
               case 34:
               case 35:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjCheckNAddTwoStates(35, 33);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 37 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
static final int[] jjnextStates = {
   20, 21, 23, 19, 30, 31, 15, 17, 2, 4, 5, 7, 4, 5, 9, 7, 
   26, 27, 29, 33, 34, 36, 6, 8, 10, 
};
private static final boolean jjCanMove_0(int hiByte, int i1, int i2, long l1, long l2)
{
   switch(hiByte)
   {
      case 0:
         return ((jjbitVec2[i2] & l2) != 0L);
      default : 
         if ((jjbitVec0[i1] & l1) != 0L)
            return true;
         return false;
   }
}
private static final boolean jjCanMove_1(int hiByte, int i1, int i2, long l1, long l2)
{
   switch(hiByte)
   {
      case 0:
         return ((jjbitVec4[i2] & l2) != 0L);
      case 48:
         return ((jjbitVec5[i2] & l2) != 0L);
      case 49:
         return ((jjbitVec6[i2] & l2) != 0L);
      case 51:
         return ((jjbitVec7[i2] & l2) != 0L);
      case 61:
         return ((jjbitVec8[i2] & l2) != 0L);
      default : 
         if ((jjbitVec3[i1] & l1) != 0L)
            return true;
         return false;
   }
}
public static final String[] jjstrLiteralImages = {
"", null, null, null, null, null, null, null, null, "\141\156\144", 
"\157\162", "\156\157\164", "\154\145\156\147\164\150", "\164\162\165\145", 
"\146\141\154\163\145", "\166\141\162", "\163\153\151\160", "\167\150\151\154\145", "\144\157", 
"\162\145\141\144", "\167\162\151\164\145", "\151\146", "\164\150\145\156", "\145\154\163\145", 
"\156\145\167", "\164\150\151\163", "\143\154\141\163\163\145", "\156\165\154\154", 
"\160\162\157\143", "\145\170\164\145\156\144\163", "\151\156\143\154\165\144\145", 
"\155\157\144\165\154\145", "\151\156\164", "\142\157\157\154\145\141\156", "\163\164\162\151\156\147", 
null, null, null, null, null, null, null, null, "\50", "\51", "\173", "\175", 
"\133", "\135", "\73", "\54", "\56", "\72\75", "\75", "\76", "\74", "\41", "\176", 
"\77", "\72", "\75\75", "\74\75", "\76\75", "\41\75", "\174\174", "\46\46", "\53\53", 
"\53", "\55", "\52", "\57", "\46", "\174", "\136", "\45", };
public static final String[] lexStateNames = {
   "DEFAULT", 
};
static final long[] jjtoToken = {
   0xfffff98ffffffe01L, 0x7ffL, 
};
static final long[] jjtoSkip = {
   0x1feL, 0x0L, 
};
static final long[] jjtoSpecial = {
   0x1c0L, 0x0L, 
};
protected JavaCharStream input_stream;
private final int[] jjrounds = new int[37];
private final int[] jjstateSet = new int[74];
protected char curChar;
public OO3ParserTokenManager(JavaCharStream stream){
   if (JavaCharStream.staticFlag)
      throw new Error("ERROR: Cannot use a static CharStream class with a non-static lexical analyzer.");
   input_stream = stream;
}
public OO3ParserTokenManager(JavaCharStream stream, int lexState){
   this(stream);
   SwitchTo(lexState);
}
public void ReInit(JavaCharStream stream)
{
   jjmatchedPos = jjnewStateCnt = 0;
   curLexState = defaultLexState;
   input_stream = stream;
   ReInitRounds();
}
private final void ReInitRounds()
{
   int i;
   jjround = 0x80000001;
   for (i = 37; i-- > 0;)
      jjrounds[i] = 0x80000000;
}
public void ReInit(JavaCharStream stream, int lexState)
{
   ReInit(stream);
   SwitchTo(lexState);
}
public void SwitchTo(int lexState)
{
   if (lexState >= 1 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
   else
      curLexState = lexState;
}

protected Token jjFillToken()
{
   Token t = Token.newToken(jjmatchedKind);
   t.kind = jjmatchedKind;
   String im = jjstrLiteralImages[jjmatchedKind];
   t.image = (im == null) ? input_stream.GetImage() : im;
   t.beginLine = input_stream.getBeginLine();
   t.beginColumn = input_stream.getBeginColumn();
   t.endLine = input_stream.getEndLine();
   t.endColumn = input_stream.getEndColumn();
   return t;
}

int curLexState = 0;
int defaultLexState = 0;
int jjnewStateCnt;
int jjround;
int jjmatchedPos;
int jjmatchedKind;

public Token getNextToken() 
{
  int kind;
  Token specialToken = null;
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {   
   try   
   {     
      curChar = input_stream.BeginToken();
   }     
   catch(java.io.IOException e)
   {        
      jjmatchedKind = 0;
      matchedToken = jjFillToken();
      matchedToken.specialToken = specialToken;
      return matchedToken;
   }

   try { input_stream.backup(0);
      while (curChar <= 32 && (0x100003600L & (1L << curChar)) != 0L)
         curChar = input_stream.BeginToken();
   }
   catch (java.io.IOException e1) { continue EOFLoop; }
   jjmatchedKind = 0x7fffffff;
   jjmatchedPos = 0;
   curPos = jjMoveStringLiteralDfa0_0();
   if (jjmatchedKind != 0x7fffffff)
   {
      if (jjmatchedPos + 1 < curPos)
         input_stream.backup(curPos - jjmatchedPos - 1);
      if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
      {
         matchedToken = jjFillToken();
         matchedToken.specialToken = specialToken;
         return matchedToken;
      }
      else
      {
         if ((jjtoSpecial[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
         {
            matchedToken = jjFillToken();
            if (specialToken == null)
               specialToken = matchedToken;
            else
            {
               matchedToken.specialToken = specialToken;
               specialToken = (specialToken.next = matchedToken);
            }
         }
         continue EOFLoop;
      }
   }
   int error_line = input_stream.getEndLine();
   int error_column = input_stream.getEndColumn();
   String error_after = null;
   boolean EOFSeen = false;
   try { input_stream.readChar(); input_stream.backup(1); }
   catch (java.io.IOException e1) {
      EOFSeen = true;
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
      if (curChar == '\n' || curChar == '\r') {
         error_line++;
         error_column = 0;
      }
      else
         error_column++;
   }
   if (!EOFSeen) {
      input_stream.backup(1);
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
   }
   throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
  }
}

}

/* Generated By:JavaCC: Do not edit this line. Func3ParserTokenManager.java */
package plp.functional3.parser;
import java.util.ArrayList;
import java.util.List;
//Imports da Funcional3
import plp.functional3.*;
import plp.functional3.expression.*;
//Imports da Funcional2
import plp.functional2.declaration.DecFuncao;
import plp.functional2.expression.ValorFuncao;
import plp.functional2.expression.ExpDeclaracao;
import plp.functional2.expression.Aplicacao;
//Imports da Funcional1
import plp.functional1.declaration.DeclaracaoFuncional;
import plp.functional1.declaration.DecVariavel;
import plp.functional1.expression.IfThenElse;
//Imports da Express�o2
import plp.expressions2.expression.Expressao;
import plp.expressions2.expression.Valor;
import plp.expressions2.expression.ValorInteiro;
import plp.expressions2.expression.ValorString;
import plp.expressions2.expression.ValorBooleano;
import plp.expressions2.expression.Id;
import plp.expressions2.expression.ExpMenos;
import plp.expressions2.expression.ExpNot;
import plp.expressions2.expression.ExpLength;
import plp.expressions2.expression.ExpSoma;
import plp.expressions2.expression.ExpSub;
import plp.expressions2.expression.ExpAnd;
import plp.expressions2.expression.ExpOr;
import plp.expressions2.expression.ExpEquals;
import plp.expressions2.expression.ExpConcat;

public class Func3ParserTokenManager implements Func3ParserConstants
{
  public static  java.io.PrintStream debugStream = System.out;
  public static  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private static final int jjStopStringLiteralDfa_0(int pos, long active0, long active1)
{
   switch (pos)
   {
      case 0:
         if ((active0 & 0x4000000000000000L) != 0L)
            return 19;
         if ((active0 & 0x3fffe00L) != 0L)
         {
            jjmatchedKind = 31;
            return 13;
         }
         return -1;
      case 1:
         if ((active0 & 0x3b9fa00L) != 0L)
         {
            jjmatchedKind = 31;
            jjmatchedPos = 1;
            return 13;
         }
         if ((active0 & 0x460400L) != 0L)
            return 13;
         return -1;
      case 2:
         if ((active0 & 0x1987000L) != 0L)
         {
            jjmatchedKind = 31;
            jjmatchedPos = 2;
            return 13;
         }
         if ((active0 & 0x2218a00L) != 0L)
            return 13;
         return -1;
      case 3:
         if ((active0 & 0x1982000L) != 0L)
            return 13;
         if ((active0 & 0x5000L) != 0L)
         {
            jjmatchedKind = 31;
            jjmatchedPos = 3;
            return 13;
         }
         return -1;
      case 4:
         if ((active0 & 0x1000L) != 0L)
         {
            jjmatchedKind = 31;
            jjmatchedPos = 4;
            return 13;
         }
         if ((active0 & 0x4000L) != 0L)
            return 13;
         return -1;
      default :
         return -1;
   }
}
private static final int jjStartNfa_0(int pos, long active0, long active1)
{
   return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0, active1), pos + 1);
}
static private final int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
static private final int jjStartNfaWithStates_0(int pos, int kind, int state)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) { return pos + 1; }
   return jjMoveNfa_0(state, pos + 1);
}
static private final int jjMoveStringLiteralDfa0_0()
{
   switch(curChar)
   {
      case 33:
         jjmatchedKind = 46;
         return jjMoveStringLiteralDfa1_0(0x10000000000000L);
      case 37:
         return jjStopAtPos(0, 66);
      case 38:
         jjmatchedKind = 63;
         return jjMoveStringLiteralDfa1_0(0x40000000000000L);
      case 40:
         return jjStopAtPos(0, 34);
      case 41:
         return jjStopAtPos(0, 35);
      case 42:
         return jjStopAtPos(0, 61);
      case 43:
         jjmatchedKind = 59;
         return jjMoveStringLiteralDfa1_0(0x80000000000000L);
      case 44:
         return jjStopAtPos(0, 41);
      case 45:
         return jjStopAtPos(0, 60);
      case 46:
         jjmatchedKind = 42;
         return jjMoveStringLiteralDfa1_0(0x400000000000000L);
      case 47:
         return jjStartNfaWithStates_0(0, 62, 19);
      case 58:
         return jjStopAtPos(0, 56);
      case 59:
         return jjStopAtPos(0, 40);
      case 60:
         jjmatchedKind = 45;
         return jjMoveStringLiteralDfa1_0(0x4000000000000L);
      case 61:
         jjmatchedKind = 43;
         return jjMoveStringLiteralDfa1_0(0x2000000000000L);
      case 62:
         jjmatchedKind = 44;
         return jjMoveStringLiteralDfa1_0(0x8000000000000L);
      case 63:
         return jjStopAtPos(0, 48);
      case 91:
         return jjStopAtPos(0, 38);
      case 93:
         return jjStopAtPos(0, 39);
      case 94:
         jjmatchedKind = 65;
         return jjMoveStringLiteralDfa1_0(0x200000000000000L);
      case 97:
         return jjMoveStringLiteralDfa1_0(0x200L);
      case 101:
         return jjMoveStringLiteralDfa1_0(0x100000L);
      case 102:
         return jjMoveStringLiteralDfa1_0(0x2604000L);
      case 104:
         return jjMoveStringLiteralDfa1_0(0x800000L);
      case 105:
         return jjMoveStringLiteralDfa1_0(0x60000L);
      case 108:
         return jjMoveStringLiteralDfa1_0(0x9000L);
      case 110:
         return jjMoveStringLiteralDfa1_0(0x800L);
      case 111:
         return jjMoveStringLiteralDfa1_0(0x400L);
      case 116:
         return jjMoveStringLiteralDfa1_0(0x1082000L);
      case 118:
         return jjMoveStringLiteralDfa1_0(0x10000L);
      case 123:
         return jjStopAtPos(0, 36);
      case 124:
         jjmatchedKind = 64;
         return jjMoveStringLiteralDfa1_0(0x20000000000000L);
      case 125:
         return jjStopAtPos(0, 37);
      case 126:
         return jjStopAtPos(0, 47);
      default :
         return jjMoveNfa_0(0, 0);
   }
}
static private final int jjMoveStringLiteralDfa1_0(long active0)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(0, active0, 0L);
      return 1;
   }
   switch(curChar)
   {
      case 38:
         if ((active0 & 0x40000000000000L) != 0L)
            return jjStopAtPos(1, 54);
         break;
      case 43:
         if ((active0 & 0x80000000000000L) != 0L)
            return jjStopAtPos(1, 55);
         break;
      case 46:
         if ((active0 & 0x400000000000000L) != 0L)
            return jjStopAtPos(1, 58);
         break;
      case 61:
         if ((active0 & 0x2000000000000L) != 0L)
            return jjStopAtPos(1, 49);
         else if ((active0 & 0x4000000000000L) != 0L)
            return jjStopAtPos(1, 50);
         else if ((active0 & 0x8000000000000L) != 0L)
            return jjStopAtPos(1, 51);
         else if ((active0 & 0x10000000000000L) != 0L)
            return jjStopAtPos(1, 52);
         break;
      case 94:
         if ((active0 & 0x200000000000000L) != 0L)
            return jjStopAtPos(1, 57);
         break;
      case 97:
         return jjMoveStringLiteralDfa2_0(active0, 0x1014000L);
      case 101:
         return jjMoveStringLiteralDfa2_0(active0, 0x809000L);
      case 102:
         if ((active0 & 0x40000L) != 0L)
            return jjStartNfaWithStates_0(1, 18, 13);
         break;
      case 104:
         return jjMoveStringLiteralDfa2_0(active0, 0x80000L);
      case 108:
         return jjMoveStringLiteralDfa2_0(active0, 0x100000L);
      case 110:
         if ((active0 & 0x20000L) != 0L)
            return jjStartNfaWithStates_0(1, 17, 13);
         else if ((active0 & 0x400000L) != 0L)
            return jjStartNfaWithStates_0(1, 22, 13);
         return jjMoveStringLiteralDfa2_0(active0, 0x200L);
      case 111:
         return jjMoveStringLiteralDfa2_0(active0, 0x2000800L);
      case 114:
         if ((active0 & 0x400L) != 0L)
            return jjStartNfaWithStates_0(1, 10, 13);
         return jjMoveStringLiteralDfa2_0(active0, 0x2000L);
      case 117:
         return jjMoveStringLiteralDfa2_0(active0, 0x200000L);
      case 124:
         if ((active0 & 0x20000000000000L) != 0L)
            return jjStopAtPos(1, 53);
         break;
      default :
         break;
   }
   return jjStartNfa_0(0, active0, 0L);
}
static private final int jjMoveStringLiteralDfa2_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(0, old0, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(1, active0, 0L);
      return 2;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa3_0(active0, 0x800000L);
      case 100:
         if ((active0 & 0x200L) != 0L)
            return jjStartNfaWithStates_0(2, 9, 13);
         break;
      case 101:
         return jjMoveStringLiteralDfa3_0(active0, 0x80000L);
      case 105:
         return jjMoveStringLiteralDfa3_0(active0, 0x1000000L);
      case 108:
         return jjMoveStringLiteralDfa3_0(active0, 0x4000L);
      case 110:
         if ((active0 & 0x200000L) != 0L)
            return jjStartNfaWithStates_0(2, 21, 13);
         return jjMoveStringLiteralDfa3_0(active0, 0x1000L);
      case 114:
         if ((active0 & 0x10000L) != 0L)
            return jjStartNfaWithStates_0(2, 16, 13);
         else if ((active0 & 0x2000000L) != 0L)
            return jjStartNfaWithStates_0(2, 25, 13);
         break;
      case 115:
         return jjMoveStringLiteralDfa3_0(active0, 0x100000L);
      case 116:
         if ((active0 & 0x800L) != 0L)
            return jjStartNfaWithStates_0(2, 11, 13);
         else if ((active0 & 0x8000L) != 0L)
            return jjStartNfaWithStates_0(2, 15, 13);
         break;
      case 117:
         return jjMoveStringLiteralDfa3_0(active0, 0x2000L);
      default :
         break;
   }
   return jjStartNfa_0(1, active0, 0L);
}
static private final int jjMoveStringLiteralDfa3_0(long old0, long active0)
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
      case 100:
         if ((active0 & 0x800000L) != 0L)
            return jjStartNfaWithStates_0(3, 23, 13);
         break;
      case 101:
         if ((active0 & 0x2000L) != 0L)
            return jjStartNfaWithStates_0(3, 13, 13);
         else if ((active0 & 0x100000L) != 0L)
            return jjStartNfaWithStates_0(3, 20, 13);
         break;
      case 103:
         return jjMoveStringLiteralDfa4_0(active0, 0x1000L);
      case 108:
         if ((active0 & 0x1000000L) != 0L)
            return jjStartNfaWithStates_0(3, 24, 13);
         break;
      case 110:
         if ((active0 & 0x80000L) != 0L)
            return jjStartNfaWithStates_0(3, 19, 13);
         break;
      case 115:
         return jjMoveStringLiteralDfa4_0(active0, 0x4000L);
      default :
         break;
   }
   return jjStartNfa_0(2, active0, 0L);
}
static private final int jjMoveStringLiteralDfa4_0(long old0, long active0)
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
         break;
      case 116:
         return jjMoveStringLiteralDfa5_0(active0, 0x1000L);
      default :
         break;
   }
   return jjStartNfa_0(3, active0, 0L);
}
static private final int jjMoveStringLiteralDfa5_0(long old0, long active0)
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
      case 104:
         if ((active0 & 0x1000L) != 0L)
            return jjStartNfaWithStates_0(5, 12, 13);
         break;
      default :
         break;
   }
   return jjStartNfa_0(4, active0, 0L);
}
static private final void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
static private final void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
static private final void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}
static private final void jjCheckNAddStates(int start, int end)
{
   do {
      jjCheckNAdd(jjnextStates[start]);
   } while (start++ != end);
}
static private final void jjCheckNAddStates(int start)
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
static private final int jjMoveNfa_0(int startState, int curPos)
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
                     if (kind > 26)
                        kind = 26;
                     jjCheckNAddTwoStates(1, 2);
                  }
                  else if (curChar == 47)
                     jjAddStates(3, 5);
                  else if (curChar == 48)
                  {
                     if (kind > 26)
                        kind = 26;
                     jjCheckNAddStates(6, 8);
                  }
                  else if (curChar == 36)
                  {
                     if (kind > 31)
                        kind = 31;
                     jjCheckNAdd(13);
                  }
                  else if (curChar == 34)
                     jjCheckNAddStates(9, 11);
                  break;
               case 1:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 26)
                     kind = 26;
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
                  if (curChar == 34 && kind > 30)
                     kind = 30;
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
                  if (kind > 31)
                     kind = 31;
                  jjCheckNAdd(13);
                  break;
               case 13:
                  if ((0x3ff001000000000L & l) == 0L)
                     break;
                  if (kind > 31)
                     kind = 31;
                  jjCheckNAdd(13);
                  break;
               case 14:
                  if (curChar != 48)
                     break;
                  if (kind > 26)
                     kind = 26;
                  jjCheckNAddStates(6, 8);
                  break;
               case 16:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 26)
                     kind = 26;
                  jjCheckNAddTwoStates(16, 2);
                  break;
               case 17:
                  if ((0xff000000000000L & l) == 0L)
                     break;
                  if (kind > 26)
                     kind = 26;
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
                  if (kind > 31)
                     kind = 31;
                  jjCheckNAdd(13);
                  break;
               case 2:
                  if ((0x100000001000L & l) != 0L && kind > 26)
                     kind = 26;
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
                  if (kind > 26)
                     kind = 26;
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
                  if (kind > 31)
                     kind = 31;
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
"\146\141\154\163\145", "\154\145\164", "\166\141\162", "\151\156", "\151\146", "\164\150\145\156", 
"\145\154\163\145", "\146\165\156", "\146\156", "\150\145\141\144", "\164\141\151\154", 
"\146\157\162", null, null, null, null, null, null, null, null, "\50", "\51", "\173", "\175", 
"\133", "\135", "\73", "\54", "\56", "\75", "\76", "\74", "\41", "\176", "\77", 
"\75\75", "\74\75", "\76\75", "\41\75", "\174\174", "\46\46", "\53\53", "\72", 
"\136\136", "\56\56", "\53", "\55", "\52", "\57", "\46", "\174", "\136", "\45", };
public static final String[] lexStateNames = {
   "DEFAULT", 
};
static final long[] jjtoToken = {
   0xfffffffcc7fffe01L, 0x7L, 
};
static final long[] jjtoSkip = {
   0x1feL, 0x0L, 
};
static final long[] jjtoSpecial = {
   0x1c0L, 0x0L, 
};
static protected JavaCharStream input_stream;
static private final int[] jjrounds = new int[37];
static private final int[] jjstateSet = new int[74];
static protected char curChar;
public Func3ParserTokenManager(JavaCharStream stream){
   if (input_stream != null)
      throw new TokenMgrError("ERROR: Second call to constructor of static lexer. You must use ReInit() to initialize the static variables.", TokenMgrError.STATIC_LEXER_ERROR);
   input_stream = stream;
}
public Func3ParserTokenManager(JavaCharStream stream, int lexState){
   this(stream);
   SwitchTo(lexState);
}
static public void ReInit(JavaCharStream stream)
{
   jjmatchedPos = jjnewStateCnt = 0;
   curLexState = defaultLexState;
   input_stream = stream;
   ReInitRounds();
}
static private final void ReInitRounds()
{
   int i;
   jjround = 0x80000001;
   for (i = 37; i-- > 0;)
      jjrounds[i] = 0x80000000;
}
static public void ReInit(JavaCharStream stream, int lexState)
{
   ReInit(stream);
   SwitchTo(lexState);
}
static public void SwitchTo(int lexState)
{
   if (lexState >= 1 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
   else
      curLexState = lexState;
}

static protected Token jjFillToken()
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

static int curLexState = 0;
static int defaultLexState = 0;
static int jjnewStateCnt;
static int jjround;
static int jjmatchedPos;
static int jjmatchedKind;

public static Token getNextToken() 
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

/**
 * Classe Library - biblioteca de métodos
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Library {
   
   public static String getFile(String file) throws IOException {
      return readFile(file);
   }
   
   public static String getFileReplace(String keyWord,String newWord,String file) throws IOException {
      String texto;
      texto = readFile(file);
      texto = replaceWord(keyWord,newWord,texto);
      return texto;
   }

   public static String replaceWord(String keyword,String newWord, String texto) {
      String newText;
      int indice;
      newText=new String();
      indice=texto.indexOf(keyword);
      while(indice!=-1){
         newText+=texto.substring(0,indice)+newWord;
         texto=texto.substring(indice + keyword.length());
         indice=texto.indexOf(keyword);
      }
      return newText+texto;
   }
   
   public static String getFileListReplace(String[] keywords,String[] newWords,String file) throws IOException {
      String texto;   
      texto = readFile(file);
      return getWordListReplace(keywords,newWords,texto);  
   }
   
   public static String getWordListReplace(String[] keywords,String[] newWords,String text) throws IOException {
      int menorTamanho=0;
      menorTamanho=keywords.length;
      
      if(menorTamanho > newWords.length) menorTamanho = newWords.length;

      /*caso o sistema fique muito lento faremos uma nova funcao que substitui de uma vez só*/
      for(int i =0;i<menorTamanho;i++)
      text = replaceWord(keywords[i],newWords[i],text);
      
      return text;   
   }   
   
   public static String readFile(String file) throws IOException {
      String context = "";
      String aux = null;
      FileReader fr = new FileReader(file);
      BufferedReader bf = new BufferedReader(fr);;

      aux=bf.readLine();
      while(aux!=null){
         aux+="\n";
         context+=aux;
         aux=bf.readLine();
      }
      fr.close();
      bf.close();

      return context;
   }

}  
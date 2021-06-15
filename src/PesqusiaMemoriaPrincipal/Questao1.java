//Implemente uma versão recursiva para a pesquisa Binária.

package PesqusiaMemoriaPrincipal;
import java.util.Scanner;

public class Questao1 {
	

	
	public static void main(String[]args){
	   	Scanner input = new Scanner (System.in); 
	   	Colecao colecao = new Colecao ();  
	   	
		int valores [] = {11, 12, 23, 27, 33, 43, 56, 76, 87, 96};
        int valor = 0;

		do {
        	System.out.println("Digite o valor a ser pesquisado: (para parar digite -1)");
        	valor = input.nextInt();
        	if (valor != -1) {
 
        		if (colecao.pesquisaBinariaRecursiva (valores, 0, valores.length, valor) == -1) {
        			System.out.println("Valor não encontrado");
        		}
        		else {
        			System.out.println("Valor encontrado na posição: " + colecao.pesquisaBinariaRecursiva (valores, 0, valores.length, valor));
        		}
        	}
        	
        }
        while (valor != -1);
		System.out.println("Fim do programa");
	}
}

// Insira os números abaixo na ordem que são apresentados numa árvore binária de busca. Mostre todos os passos.
//50; 20; 10; 40; 60; 30; 45; 25; 35; 55

package QuestãoArvore;

public class Questao4 {

	public static void main (String args [] ) {
		Arvore arvore = new Arvore (new Elemento (50)); 
		arvore.inserir(new Elemento (20));
		arvore.inserir(new Elemento (10));
		arvore.inserir(new Elemento (40));
		arvore.inserir(new Elemento (60));
		arvore.inserir(new Elemento (30));
		arvore.inserir(new Elemento (45));
		arvore.inserir(new Elemento (25));
		arvore.inserir(new Elemento (35));
		arvore.inserir(new Elemento (55));
		
		
		
	}
}

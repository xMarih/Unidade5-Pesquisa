//A partir da árvore obtida no exercício anterior, remova os números abaixo na ordem que são apresentados. Mostre todos os passos.
//50; 20; 10; 40; 60; 30; 45; 25; 35; 55
package QuestãoArvore;

public class Questao5 {

	public static void main(String[] args) {
		
		Elemento elem = new Elemento (0); 
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
		
		
		System.out.println("Arvore Completa");
		arvore.imprimirInOrdem();
		System.out.println();
		
		
		elem.setValor(50); 
		arvore.remover(elem);
		System.out.println("Remove: " + elem.getValor());
		arvore.imprimirInOrdem();
		System.out.println();
		
		elem.setValor(20); 
		arvore.remover(elem);
		System.out.println("Remove: " + elem.getValor());
		arvore.imprimirInOrdem();
		System.out.println();
		
		elem.setValor(10); 
		arvore.remover(elem);
		System.out.println("Remove: " + elem.getValor());
		arvore.imprimirInOrdem();
		System.out.println();
		
		elem.setValor(40); 
		arvore.remover(elem);
		System.out.println("Remove: " + elem.getValor());
		arvore.imprimirInOrdem();
		System.out.println();
		
		elem.setValor(60); 
		arvore.remover(elem);
		System.out.println("Remove: " + elem.getValor());
		arvore.imprimirInOrdem();
		System.out.println();
		
		elem.setValor(30); 
		arvore.remover(elem);
		System.out.println("Remove: " + elem.getValor());
		arvore.imprimirInOrdem();
		System.out.println();
		
		elem.setValor(45); 
		arvore.remover(elem);
		System.out.println("Remove: " + elem.getValor());
		arvore.imprimirInOrdem();
		System.out.println();
		
		elem.setValor(25); 
		arvore.remover(elem);
		System.out.println("Remove: " + elem.getValor());
		arvore.imprimirInOrdem();
		System.out.println();
		
		

	}

}

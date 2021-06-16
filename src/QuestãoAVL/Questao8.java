package QuestãoAVL;

import java.util.Scanner;

import QuestãoArvore.Arvore;
import QuestãoArvore.Elemento;

public class Questao8 {

	    public static void main(String args[]){
	        
	    	ArvoreAVL arvore = new ArvoreAVL(5);
			
			arvore.inserir(new Elemento (10));
			arvore.inserir(new Elemento (15));
			arvore.inserir(new Elemento (30));
			arvore.inserir(new Elemento (40));
			arvore.inserir(new Elemento (20));
			arvore.inserir(new Elemento (25));
			arvore.inserir(new Elemento (35));
			arvore.inserir(new Elemento (45));
			arvore.inserir(new Elemento (50));
	        
	    	
	    	arvore.calcularBalanceamento();
	        arvore = arvore.verificaBalanceamento();
	        
	        System.out.println(arvore.printArvore(0));
	        while(true){

	        	
	            arvore.calcularBalanceamento();
	            arvore = arvore.verificaBalanceamento();
	            System.out.println(arvore.printArvore(0));
	        
	    }
	}
}

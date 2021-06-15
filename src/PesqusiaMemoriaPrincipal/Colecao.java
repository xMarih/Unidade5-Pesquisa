package PesqusiaMemoriaPrincipal;

public class Colecao {

	public int pesquisaBinariaRecursiva (int vet[], int inicio, int fim, int procura) {
		int meio;
		if (inicio > fim) {
			return -1;
		}
		
		else {
			meio = (inicio + fim)/2; 
			
			if (procura == vet[meio]) {
				return meio;
			}
				
			else
				if (procura > vet[meio])
					return pesquisaBinariaRecursiva(vet, meio + 1, fim, procura);
				else
					return pesquisaBinariaRecursiva(vet, inicio, meio-1, procura);
			}
		}

	 public int buscaSequencial (int vet[], int procura){
	     int interacoes = 0;  
		 for (int i = 0; i < vet.length; i++){
			 if (procura == vet [i]){
				 return i; 
	         }
			 interacoes ++; 
		 }
		 System.out.println("Interações: " + interacoes);
		 
		 return -1; 	
	 }
	 
	 public int buscaBinaria (int vet[], int procura) {
		
		 int interacoes = 0; 
		 int meio;
		 int inicio = 0;
		 int fim = vet.length-1;
		 
		 while (inicio < fim){
			  meio = (inicio + fim)/2;
			  if (procura == vet[meio]) {
				  System.out.println("Interações: " + interacoes);
				  return meio ;
			  }
			  else {
				  if (procura > vet[meio]) {
					  interacoes++; 
					  inicio = meio + 1; 
				  }
				  else {
					  fim = meio -1;
				  }
			  }

		 }
		  System.out.println("Interações: " + interacoes);
		 return -1;
		 
		 
	 }
	    
}

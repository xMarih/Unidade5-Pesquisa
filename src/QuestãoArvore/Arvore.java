package QuestãoArvore;

public class Arvore {
	
	private Elemento ele;
	private Arvore dir;
	private Arvore esq;
	
    public Arvore(){
        this.ele = null;
        this.esq = null;
        this.dir = null;
    }
    
    public Arvore(Elemento elem){
        this.ele = elem;
        this.dir = null;
        this.esq = null;
        System.out.println("Criei a arvore com o elemento "+elem.getValor());
    }
	
	public boolean isEmpty() {
		return (this.ele == null);
	}
	
	public void inserir (Elemento novo) {
		if(isEmpty()) {
			this.ele = novo;
		}
		else {
			Arvore novaArvore = new Arvore (novo);
			if (novo.getValor () < this.ele.getValor()) {
				if (this.esq == null){
					this.esq = novaArvore; 
					System.out.println("Elemento " + novo.getValor() + "inserido a esquerda de " + this.ele.getValor());
				}
				else {
					this.esq.inserir(novo);
				}
			}
			else if (novo.getValor () > this.ele.getValor()) {
				if (this.dir == null) {
					this.dir = novaArvore; 
					System.out.println("Elemento " + novo.getValor() + "inserido a direita de " + this.ele.getValor());
				}
				else {
					this.dir.inserir(novo);
				}
			}
		}
	}
	
	public boolean busca (int valor) {
		if (isEmpty()) {
			return false;
		}
		if(this.ele.getValor() == valor) {
			return true;
		}
		else {
			if (valor < this.ele.getValor()) {
				if (this.esq == null) {
					return false;
				}
				else {
					return this.esq.busca(valor); 
				}
			}
			else if (valor > this.ele.getValor()) {
				if (this.dir == null) {
					return false;
				}
				else {
					return this.dir.busca(valor);
				}
			}
			return false; 
				
			
			
		}
	}

	 public Arvore remover(Elemento elem){
	      
	        if (this.ele.getValor() == elem.getValor()){
	  
	            if (this.dir == null && this.esq == null){
	                return null;
	            }
	            else{
	               
	                if (this.esq != null && this.dir == null){
	                    return this.esq;    
	                }
	             
	                else if (this.dir != null && this.esq == null){
	                    return this.dir;
	                }
	              
	                else{
	                  
	                    Arvore aux = this.esq;
	                    while (aux.dir != null){ 
	                        aux = aux.dir;
	                    }
	         
	                    this.ele = aux.getElemento(); 
	                    aux.setElemento(elem);         
	                    this.esq = esq.remover(elem);
	                }
	            }
	        }
	        else if (elem.getValor() < this.ele.getValor()){
	            this.esq = this.esq.remover(elem);
	        }
	        else if (elem.getValor() > this.ele.getValor()){
	            this.dir = this.dir.remover(elem);
	        }
	        return this;
	    }

	  public void imprimirInOrdem(){
	        if (!isEmpty()){
	            if (this.esq != null){
	                this.esq.imprimirInOrdem();
	            }
	            System.out.print(this.ele.getValor() + "  ");
	            if (this.dir != null){
	                this.dir.imprimirInOrdem();
	            }
	        }
	    }
	
	  public void setElemento(Elemento ele){
	        this.ele = ele;
	    }
	    public void setDir(Arvore dir){
	        this.dir = dir;
	    }
	    public void setEsq(Arvore esq){
	        this.esq = esq;
	    }
	    public Arvore getDireita(){
	        return this.dir;
	    }
	    public Arvore getEsquerda(){
	        return this.esq;
	    }
	    public Elemento getElemento(){
	        return this.ele;
	    }

}


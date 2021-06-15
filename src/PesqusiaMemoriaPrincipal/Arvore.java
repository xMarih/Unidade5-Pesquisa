package PesqusiaMemoriaPrincipal;

public class Arvore {
	
	private Elemento ele;
	private Arvore dir;
	private Arvore esq;
	private Valor val;
	
	public Arvore () {
		this.ele = null;
		this.dir = null;
		this.esq = null;
		
	}
	
	public Arvore (Elemento elem) {
		this.ele = elem;
		this.dir = null;
		this.esq = null;
		
	}
	
	public void setElemento (Elemento ele) {
		this.ele = ele;
	}
	public void setDir (Arvore dir) {
		this.dir = dir;
	}
	public void setEsq (Arvore esq) {
		this.esq = esq;
	}
	public Arvore getElemento() {
		return this.getElemento(); 
	}
	public Arvore getDireita() {
		return this.getDireita(); 
	}
	public Arvore getEsquerda() {
		return this.getEsquerda(); 
	}

}


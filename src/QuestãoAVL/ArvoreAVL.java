package QuestãoAVL;

public class ArvoreAVL{
    private Elemento ele;
    private ArvoreAVL dir;
    private ArvoreAVL esq;
    private int bal;
    

    public ArvoreAVL(Elemento elemento){
        this.ele = elemento;
        this.dir = null;
        this.esq = null;
        this.bal = 0;
        System.out.println("Criei a arvore com o elemento "+elemento.getValor());
    }
    

    public int calcularAltura(){
        if (this.esq == null && this.dir == null) {
            return 1;
        }
        else if (this.esq != null && this.dir == null){
            return 1 + this.esq.calcularAltura();
        }
        else if (this.esq == null && this.dir != null){
            return 1 + this.dir.calcularAltura();
        }
        else{
            return 1 + Math.max(this.esq.calcularAltura(), this.dir.calcularAltura());
        }
    }
    

    public void calcularBalanceamento(){
        if (this.dir == null && this.esq == null){
            this.bal = 0;
        }
        else if (this.esq == null && this.dir != null){
            this.bal = this.dir.calcularAltura() - 0;
        }
        else if (this.esq != null && this.dir == null){
            this.bal = 0 - this.esq.calcularAltura();
        }
        else{
            this.bal = this.dir.calcularAltura() - this.esq.calcularAltura();
        }
        if (this.dir != null) this.dir.calcularBalanceamento();
        if (this.esq != null) this.esq.calcularBalanceamento();
    }
   
    
    public ArvoreAVL verificaBalanceamento(){
        if (this.bal >=2 || this.bal <= -2){
            if (this.bal >= 2){
                if (this.bal * this.dir.getBalanceamento() > 0){
                    System.out.println("Rotacao Simples Direita");
                    return rotacaoSimplesDireita();
                }
                else{
                    System.out.println("Rotacao Dupla Direita");
                    return rotacaoDuplaDireita();
                }
            }
            else{  // bal <= -2
                if (this.bal * this.esq.getBalanceamento() > 0){
                    System.out.println("Rotacao Simples Esquerda");
                    return rotacaoSimplesEsquerda();
                }
                else{
                    System.out.println("Rotacao Dupla Esquerda");
                    return rotacaoDuplaEsquerda();
                }
            }
        }
        this.calcularBalanceamento();
        if (this.esq != null) this.esq = this.esq.verificaBalanceamento();
        if (this.dir != null) this.dir = this.dir.verificaBalanceamento();
        return this;
    }
    
    
    public ArvoreAVL rotacaoSimplesDireita(){
        ArvoreAVL filhoDir;
        ArvoreAVL filhoDoFilho = null;
        filhoDir = this.getDireita();
        if (this.dir != null){
            if (this.dir.getEsquerda()!= null){
                filhoDoFilho = filhoDir.getEsquerda();
            }
        }
        filhoDir.setEsquerda(this);
        this.setDireita(filhoDoFilho);
        return filhoDir;
    }
    public ArvoreAVL rotacaoSimplesEsquerda(){
        ArvoreAVL filhoEsq;
        ArvoreAVL filhoDoFilho = null;
        filhoEsq = this.getEsquerda();
        if (this.esq != null){
            if (this.esq.getDireita()!= null){
                filhoDoFilho = filhoEsq.getDireita();
            }
        }
        filhoEsq.setDireita(this);
        this.setEsquerda(filhoDoFilho);
        return filhoEsq;
    }
    public ArvoreAVL rotacaoDuplaDireita(){
        ArvoreAVL arvore       = this;
        ArvoreAVL filhoDir     = this.getDireita();
        ArvoreAVL filhoDoFilho = filhoDir.getEsquerda();
        ArvoreAVL noInserido   = filhoDoFilho.getDireita();
     
        filhoDir.setEsquerda(noInserido);
        filhoDoFilho.setDireita(filhoDir);
        this.setDireita(filhoDoFilho);
        ArvoreAVL novoFilhoDireita = this.getDireita();
        arvore.setDireita(null);
        novoFilhoDireita.setEsquerda(arvore);
        return novoFilhoDireita;
    }
    public ArvoreAVL rotacaoDuplaEsquerda(){
        ArvoreAVL arvore       = this;
        ArvoreAVL filhoEsq     = this.getEsquerda();
        ArvoreAVL filhoDoFilho = filhoEsq.getDireita();
        ArvoreAVL noInserido   = filhoDoFilho.getEsquerda();
        filhoEsq.setDireita(noInserido);
        filhoDoFilho.setEsquerda(filhoEsq);
        this.setEsquerda(filhoDoFilho);

        ArvoreAVL novoFilhoEsquerda = this.getEsquerda();
        arvore.setEsquerda(null);
        novoFilhoEsquerda.setDireita(arvore);
        return novoFilhoEsquerda;
    }
    


    public boolean isEmpty(){

        return (this.ele == null);
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

    
    public ArvoreAVL inserir(Elemento novo){
        if (isEmpty()){
            this.ele = novo;
        }
        else{
            ArvoreAVL novaArvore = new ArvoreAVL(novo);
            if (novo.getValor() < this.ele.getValor()){ 
                if (this.esq == null){ 
                    this.esq = novaArvore;
                    System.out.println("Inseri o elemento "+ novo.getValor()+ " à esquerda de "+this.ele.getValor());
                }
                else{
                    this.esq = this.esq.inserir(novo); 
                }
            }
            else if (novo.getValor() > this.ele.getValor()){ 
                if (this.dir == null){
                    this.dir = novaArvore;
                    System.out.println("Inseri o elemento "+ novo.getValor()+ " à direita de "+this.ele.getValor());
                }
                else{
                    this.dir = this.dir.inserir(novo);
                }
            }
        }
        return this;
    }
    public ArvoreAVL remover(int elemento){
    
        if (this.ele.getValor() == elemento){

        	if (this.esq == null && this.dir == null){
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
                    ArvoreAVL aux = this.dir;
                    while (aux.esq != null){
                        aux = aux.esq;
                    }
                    this.setElemento(aux.getElemento()); 
                    aux.getElemento().setValor(elemento);

                    this.dir = dir.remover(elemento);
                }
            }
        }
        else{

            if (elemento < this.ele.getValor() ){
                if (this.esq != null){
                    this.esq = this.esq.remover(elemento);
                }
            }

            else if (elemento > this.ele.getValor()){
                if (this.dir != null){
                    this.dir = this.dir.remover(elemento);
                }
            }
        }
        return this;
            
    }
    public boolean busca(int valor){
        if (isEmpty()){
            return false;
        }
        if (this.ele.getValor() == valor){
            return true;
        }
        else{
            if (valor < this.ele.getValor() ){
                if (this.esq == null){
                    return false;
                }
                else{
                    return this.esq.busca(valor); 
                }
            }
            else if (valor > this.ele.getValor()){
                if (this.dir == null){
                    return false;
                }
                else{
                    return this.dir.busca(valor);
                }
            }
            return false;
        }
    }

    public void setElemento(Elemento ele){
        this.ele = ele;
    }
    public void setDireita(ArvoreAVL dir){
        this.dir = dir;
    }
    public void setEsquerda(ArvoreAVL esq){
        this.esq = esq;
    }
    public int getBalanceamento(){
        return this.bal;
    }
    public void setBalanceamento(int bal){
        this.bal = bal;
    }
    public ArvoreAVL getDireita(){
        return this.dir;
    }
    public ArvoreAVL getEsquerda(){
        return this.esq;
    }
    public Elemento getElemento(){
        return this.ele;
    }

    public String printArvore(int level){
        String str = this.toString()+"\n";
        for (int i=0; i<level; i++){
                str += "\t";
        }
        if (this.esq != null){
            str += "+-ESQ: "+this.esq.printArvore(level + 1);
        }
        else{
            str += "+-ESQ: NULL";
        }
        str += "\n";
        for (int i=0; i<level; i++){
                 str += "\t";
        }
        if (this.dir != null){
            
            str += "+-DIR: "+this.dir.printArvore(level + 1); 
        }
        else{
            str += "+-DIR: NULL";
        }
        str += "\n";
        return str;
    }
    public String toString(){
        return "["+this.ele.getValor()+"] ("+this.bal+")";
    }
}
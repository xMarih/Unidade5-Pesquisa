package TabelaHash;

public class MapaHash{
	private Registro valores[];

	public MapaHash(){
		valores = new Registro[100];
	}

	public void put(Registro registro){
		int posicao = registro.hashCode();
		if (valores[posicao] == null){
			valores[posicao] = registro;
			System.out.println("=====Posicao vazia!! Novo Registro");
		}
		else{
			System.out.print("Ops... colisao! >>>");
			Registro reg = valores[posicao];


			if (reg.getKey() == registro.getKey()){
				   reg.setValue(registro.getValue());  
				   System.out.println("É o primeiro Registro Existente - atualizando...");
				   return;
			}
	
		    while (reg.getProximo() != null){
		        if (reg.getKey() == registro.getKey()){ 
			       reg.setValue(registro.getValue());  
			       System.out.println("Tá no meio da lista - Registro Existente - atualizando...");
			       return;
			    }
			    reg = reg.getProximo(); 

				if (reg.getKey() == registro.getKey()){
					reg.setValue(registro.getValue());
					System.out.println("É o ultimo! Registro Existente - atualizando...");
					return;
				}

			reg.setProximo(registro); 
			System.out.println("Novo Registro!");
			
			
		}
	}

	}
	public Registro get(int key){
		Registro r = new Registro();
		r.setKey(key);
		int posicao = r.hashCode();
		Registro resultado = valores[posicao]; 
		if (resultado != null && resultado.getKey() == key){ 
			return resultado;
		}
		else{
			while (resultado != null){ 
				resultado = resultado.getProximo();  
				if (resultado != null && resultado.getKey() == key){
					return resultado;
				}
			}
		}
		return null;
	}
}
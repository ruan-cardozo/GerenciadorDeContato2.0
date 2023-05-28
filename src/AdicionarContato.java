import java.io.Serializable;
import java.util.HashMap;

class AdicionarContato implements Serializable {
	public void adicionarContato(HashMap<String, String> contatos, String nome, String numeroTelefone){
		contatos.put(nome, numeroTelefone);
		System.out.println("Contato adicionado com sucesso!");
	}
}

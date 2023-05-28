import java.util.HashMap;
import java.io.Serializable;
public class ListarContato implements Serializable {
	public void listarContato(HashMap<String, String> contatos){
		for (HashMap.Entry<String, String> entry : contatos.entrySet()) {
			System.out.println("Contato: " + entry.getKey() + " - " + entry.getValue());
		}
	}
}

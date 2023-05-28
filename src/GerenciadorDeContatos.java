import java.time.LocalDateTime;
import java.util.HashMap;
import java.io.Serializable;
import java.io.*;

public class GerenciadorDeContatos implements Serializable {
	private HashMap<String, String> contatos;
	private AdicionarContato adicionarContato;

	private RemoverContato removerContato;

	private ListarContato listarContato;

	private BuscarContato buscarContato;

	public GerenciadorDeContatos() throws ContatoInexistenteException {
		contatos = new HashMap<>();
		adicionarContato = new AdicionarContato();
		removerContato = new RemoverContato();
		listarContato = new ListarContato();
		buscarContato = new BuscarContato();
	}

	public HashMap<String, String> getContatos() {
		return contatos;
	}

	public void setContatos(HashMap<String, String> contatos) {
		this.contatos = contatos;
	}

	public AdicionarContato getAdicionarContato() {
		return adicionarContato;
	}

	public void setAdicionarContato(AdicionarContato adicionarContato) {
		this.adicionarContato = adicionarContato;
	}

	public RemoverContato getRemoverContato() {
		return removerContato;
	}

	public void setRemoverContato(RemoverContato removerContato) {
		this.removerContato = removerContato;
	}

	public ListarContato getListarContato() {
		return listarContato;
	}

	public void setListarContato(ListarContato listarContato) {
		this.listarContato = listarContato;
	}

	public BuscarContato getBuscarContato() {
		return buscarContato;
	}

	public void setBuscarContato(BuscarContato buscarContato) {
		this.buscarContato = buscarContato;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof GerenciadorDeContatos that)) return false;

		if (getContatos() != null ? !getContatos().equals(that.getContatos()) : that.getContatos() != null)
			return false;
		if (getAdicionarContato() != null ? !getAdicionarContato().equals(that.getAdicionarContato()) : that.getAdicionarContato() != null)
			return false;
		if (getRemoverContato() != null ? !getRemoverContato().equals(that.getRemoverContato()) : that.getRemoverContato() != null)
			return false;
		if (getListarContato() != null ? !getListarContato().equals(that.getListarContato()) : that.getListarContato() != null)
			return false;
		return getBuscarContato() != null ? getBuscarContato().equals(that.getBuscarContato()) : that.getBuscarContato() == null;
	}

	@Override
	public int hashCode() {
		int result = getContatos() != null ? getContatos().hashCode() : 0;
		result = 31 * result + (getAdicionarContato() != null ? getAdicionarContato().hashCode() : 0);
		result = 31 * result + (getRemoverContato() != null ? getRemoverContato().hashCode() : 0);
		result = 31 * result + (getListarContato() != null ? getListarContato().hashCode() : 0);
		result = 31 * result + (getBuscarContato() != null ? getBuscarContato().hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "GerenciadorDeContatos{" +
				"contatos=" + contatos +
				", adicionarContato=" + adicionarContato +
				", removerContato=" + removerContato +
				", listarContato=" + listarContato +
				", buscarContato=" + buscarContato +
				'}';
	}
}

import java.io.*;
import java.util.logging.Logger;
import java.util.Scanner;

public class Main implements Serializable {
	public static void main(String[] args) throws ContatoInexistenteException {
		Logger log = Logger.getAnonymousLogger();
		GerenciadorDeContatos gerenciador = new GerenciadorDeContatos();

		//verifica se o arquivo existe e carrega os contatos salvo
		try {
			FileInputStream fileIn = new FileInputStream("contatos.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			gerenciador = (GerenciadorDeContatos) in.readObject();
			in.close();
			fileIn.close();
		}  catch (IOException | ClassNotFoundException e) {
			gerenciador = new GerenciadorDeContatos();
		}
		while (true) {
			System.out.println("Selecione uma opção: ");
			System.out.println("1. Adicionar contato");
			System.out.println("2. Remover contato");
			System.out.println("3. Listar contatos");
			System.out.println("4. Buscar contato");
			System.out.println("5. Gravar contato");
			System.out.println("6. Ler contatos");
			System.out.println("0. Sair");

			Scanner scanner = new Scanner(System.in);
			int opcao = scanner.nextInt();
			scanner.nextLine();

			switch (opcao) {
				case 1:
					System.out.println("Digite o nome do contato: ");
					String nome = scanner.nextLine();
					System.out.println("Digite o telefone do contato: ");
					String telefone = scanner.nextLine();
					gerenciador.getAdicionarContato().adicionarContato(gerenciador.getContatos(), nome, telefone);
					break;
				case 2:
					System.out.println("Digite o nome do contato: ");
					String nomeRemover = scanner.nextLine();
					gerenciador.getRemoverContato().removerContato(gerenciador.getContatos(), nomeRemover);
					break;
				case 3:
					gerenciador.getListarContato().listarContato(gerenciador.getContatos());
					break;
				case 4:
					System.out.println("Digite o nome do contato: ");
					String nomeBuscar = scanner.nextLine();
					gerenciador.getBuscarContato().buscarContato(gerenciador.getContatos(), nomeBuscar);
					break;
				case 5:
					try {
						FileOutputStream fileOut = new FileOutputStream("contatos.ser");
						ObjectOutputStream out = new ObjectOutputStream(fileOut);
						out.writeObject(gerenciador);
						out.close();
						fileOut.close();
						System.out.println("Contatos salvos em contatos.ser");
					} catch (IOException e) {
						System.out.println("Erro ao salvar contatos" + e.getMessage());
					}
					break;
				case 6:
					try {
						FileInputStream fileIn = new FileInputStream("contatos.ser");
						ObjectInputStream in = new ObjectInputStream(fileIn);
						gerenciador = (GerenciadorDeContatos) in.readObject();
						in.close();
						fileIn.close();
					}  catch (IOException | ClassNotFoundException e) {
						System.out.println("Erro ao ler contatos" + e.getMessage());
					}
					break;
				case 0:
					try {
						FileOutputStream fileOut = new FileOutputStream("contatos.ser");
						ObjectOutputStream out = new ObjectOutputStream(fileOut);
						out.writeObject(gerenciador);
						out.close();
						fileOut.close();
						System.out.println("Contatos gravados com sucesso!");
					} catch (IOException e) {
						System.out.println("Erro ao salvar contatos" + e.getMessage());
					}
					System.exit(0);
					break;
				default:
					System.out.println("Opção inválida!");
					break;
			}
		}
	}
}

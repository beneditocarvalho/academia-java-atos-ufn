package view;

import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import controller.ClienteCRUD;
import controller.FornecedorCRUD;
import model.Cliente;
import model.Fornecedor;

public class App {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		ClienteCRUD clienteCRUD = new ClienteCRUD();
		clienteCRUD.setup();
		Cliente cliente = new Cliente();

		FornecedorCRUD fornecedorCRUD = new FornecedorCRUD();
		fornecedorCRUD.setup();
		Fornecedor fornecedor = new Fornecedor();

		int id;
		boolean sair = false;

		while (!sair) {

			String menuGeral = "Selecione a opção desejada\n" + "[1] Clientes\n" + "[2] Fornecedores\n";

			int op = Integer.parseInt(JOptionPane.showInputDialog(null, menuGeral, "Bem-Vindo!", -1));

			if (op == 1) {

				String menuCliente = "Menu de Opções\n" + "[1] Cadastrar\n" + "[2] Consultar\n" + "[3]Alterar\n"
						+ "[4]Deletar\n" + "[5]Sair\n";

				int op1 = Integer.parseInt(JOptionPane.showInputDialog(null, menuCliente, "Clientes", -1));

				switch (op1) {

				case 1:

					cliente.setNome(JOptionPane.showInputDialog("Digite o nome: "));

					cliente.setEmail(JOptionPane.showInputDialog("Digite o email: "));

					clienteCRUD.create(cliente);

					break;

				case 2:

					String menuConsulta = "Menu de Opções\n" + "[1] Consultar por ID\n" + "[2] Consultar Todos\n";

					int opcao = Integer.parseInt(JOptionPane.showInputDialog(menuConsulta));

					if (opcao == 1) {

						String buscarId = JOptionPane.showInputDialog("Digite o ID que deseja pesquisar: ");
						id = Integer.parseInt(buscarId);
						System.out.println(clienteCRUD.queryWhere(id));

						break;
					}

					if (opcao == 2) {

						List<Cliente> clienteLista = clienteCRUD.listAll();

						clienteLista.stream().forEach(System.out::println);

						break;
					}

				case 3:

					String idCliente = JOptionPane.showInputDialog("Digite o ID que deseja Alterar: ");
					id = Integer.parseInt(idCliente);

					Cliente teste = clienteCRUD.read(id);

					teste.setNome(JOptionPane.showInputDialog("Digite o nome: "));

					teste.setEmail(JOptionPane.showInputDialog("Digite o email: "));

					clienteCRUD.update(teste);

					break;

				case 4:

					String clienteDelete = JOptionPane.showInputDialog("Digite o ID que deseja Deletar: ");
					id = Integer.parseInt(clienteDelete);

					clienteCRUD.delete(id);

					break;

				case 5:

					break;

				default:
					break;
				}

			}

			if (op == 2) {

				String menuFornecedor = "Menu de Opções\n" + "[1] Cadastrar\n" + "[2] Consultar\n" + "[3]Alterar\n"
						+ "[4]Deletar\n" + "[5]Sair\n";

				int op2 = Integer.parseInt(JOptionPane.showInputDialog(null, menuFornecedor, "Fornecedor", -1));

				switch (op2) {

				case 1:

					fornecedor.setNome(JOptionPane.showInputDialog("Digite o nome: "));

					fornecedor.setEmail(JOptionPane.showInputDialog("Digite o email: "));

					fornecedorCRUD.create(fornecedor);

					break;

				case 2:

					String menuConsulta = "Menu de Opções\n" + "[1] Consultar por ID\n" + "[2] Consultar Todos\n";

					int opcao = Integer.parseInt(JOptionPane.showInputDialog(menuConsulta));

					if (opcao == 1) {

						String buscarId = JOptionPane.showInputDialog("Digite o ID que deseja pesquisar: ");
						id = Integer.parseInt(buscarId);
						System.out.println(fornecedorCRUD.queryWhere(id));

						break;
					}

					if (opcao == 2) {

						List<Fornecedor> fornecedorLista = fornecedorCRUD.listAll();

						fornecedorLista.stream().forEach(System.out::println);

						break;
					}

				case 3:

					String idFornecedor = JOptionPane.showInputDialog("Digite o ID que deseja Alterar: ");
					id = Integer.parseInt(idFornecedor);

					Fornecedor teste = fornecedorCRUD.read(id);

					teste.setNome(JOptionPane.showInputDialog("Digite o nome: "));

					teste.setEmail(JOptionPane.showInputDialog("Digite o email: "));

					fornecedorCRUD.update(teste);

					break;

				case 4:

					String fornecedorDelete = JOptionPane.showInputDialog("Digite o ID que deseja Deletar: ");
					id = Integer.parseInt(fornecedorDelete);

					fornecedorCRUD.delete(id);

					break;

				case 5:

					break;

				default:
					break;
				}

			}

			scan.close();

		}
	}
}
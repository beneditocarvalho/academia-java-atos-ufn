import java.util.Scanner;

import javax.swing.JOptionPane;

import controller.Controller;
import model.Veiculo;

public class App {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Controller template = new Controller();
		Veiculo veiculo = new Veiculo();
		int id;
		boolean sair = true;

		while (sair) {

			try {
				template.conectar();

				String menu = "Menu de Opções\n" + "[1] Cadastrar\n" + "[2] Consultar\n" + "[3]Alterar\n"
						+ "[4]Deletar\n" + "[|5]Sair\n";

				int op = Integer.parseInt(JOptionPane.showInputDialog(menu));

				switch (op) {

				case 1:

					veiculo.setMarca(JOptionPane.showInputDialog("Digite a marca: "));

					veiculo.setModelo(JOptionPane.showInputDialog("Digite o modelo: "));

					veiculo.setAno(Integer.parseInt(JOptionPane.showInputDialog("Digite o ano: ")));

					template.inserir(veiculo);

					break;

				case 2:

					template.consultar();

					break;

				case 3:

					
					String teste = JOptionPane.showInputDialog("Digite o ID que deseja Alterar: ");
					id = Integer.parseInt(teste);

					veiculo.setMarca(JOptionPane.showInputDialog("Digite a marca: "));

					veiculo.setModelo(JOptionPane.showInputDialog("Digite o modelo: "));

					veiculo.setAno(Integer.parseInt(JOptionPane.showInputDialog("Digite o ano: ")));

					template.alterar(veiculo, id);

					break;

				case 4:

					String teste2 = JOptionPane.showInputDialog("Digite o ID que deseja Deletar: ");
					id = Integer.parseInt(teste2);

					template.excluir(id);
					
					break;
					
				case 5: 
					
					sair = false;
					break;

				default:
					break;
				}

				scan.close();
				template.fecharConexao();
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}

	}

}
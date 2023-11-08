package aplicacao;

import java.util.Scanner;

import dao.ClienteDAO;
import dao.DestinoDAO;
import dao.ViagemDAO;
import modelo.Cliente;
import modelo.Destino;
import modelo.Viagem;

public class MainViagem {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		ClienteDAO clienteDAO = new ClienteDAO();
		DestinoDAO destinoDAO = new DestinoDAO();
		ViagemDAO viagemDAO = new ViagemDAO();
		
		int opcao , id,id_cliente,id_destino,numPassageiros ; 
		float valor;
		String dataIda,dataVolta;
		
		
		do {
			
			System.out.println("\n============================== VIAGEM =================================\n");
			System.out.println("1-CRIAR   2-CONSULTAR   3-ATUALIZAR   4-DELETAR   5-CONSULTAR POR ID  0-SAIR");
			opcao = s.nextInt();
			s.nextLine();
			
			switch (opcao) {
			case 1:
				System.out.println("Digite o id_cliente:");
				id_cliente = s.nextInt();
				s.nextLine();
				System.out.println("Digite o id_destino:");
				id_destino = s.nextInt();
				s.nextLine();
				System.out.println("Digite o dataIda:");
				dataIda = s.nextLine();
				System.out.println("Digite a dataVolta:");
				dataVolta = s.nextLine();
				System.out.println("Digite o numPassageiros:");
				numPassageiros = s.nextInt();
				s.nextLine();
				System.out.println("Digite o valor:");
				valor = s.nextFloat();
				s.nextLine();
			Cliente cliente = clienteDAO.readById(id_cliente);
			Destino destino = destinoDAO.readById(id_destino);	
				
				viagemDAO.create(new Viagem(numPassageiros,dataIda,dataVolta,valor,cliente,destino));
				break;
			case 2:
				
				for (Viagem v : viagemDAO.read()) {
				v.mostrar();
				}
				
				break;
			case 3:
				
				System.out.println("Digite o id:");
				id = s.nextInt();
				s.nextLine();
				System.out.println("Digite o id_cliente:");
				id_cliente = s.nextInt();
				s.nextLine();
				System.out.println("Digite o id_destino:");
				id_destino = s.nextInt();
				s.nextLine();
				System.out.println("Digite o dataIda:");
				dataIda = s.nextLine();
				System.out.println("Digite a dataVolta:");
				dataVolta = s.nextLine();
				System.out.println("Digite o numPassageiros:");
				numPassageiros = s.nextInt();
				s.nextLine();
				System.out.println("Digite o valor:");
				valor = s.nextFloat();
				s.nextLine();
			Cliente cliente1 = clienteDAO.readById(id_cliente);
			Destino destino1 = destinoDAO.readById(id_destino);	
				
				viagemDAO.update(new Viagem(id,numPassageiros,dataIda,dataVolta,valor,cliente1,destino1));
				break;
			case 4:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();
				
				viagemDAO.delete(id);
				break;
			case 5:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();
				
			Viagem viagem= viagemDAO.readById(id);
			viagem.mostrar();	
			
				break;
			default:
				
				break;
			}
			
		} while (opcao != 0);
		
		System.out.println("Até mais!");
		s.close();
	}

}

package aplicacao;

import java.util.Scanner;

import dao.DestinoDAO;

import modelo.Destino;

public class MainDestino {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		DestinoDAO destinoDAO = new DestinoDAO();
		
		int opcao , id ; 
		
		String nome , data, estado;
		
		
		do {
			
			System.out.println("\n============================== DESTINO =================================\n");
			System.out.println("1-CRIAR   2-CONSULTAR   3-ATUALIZAR   4-DELETAR   5-CONSULTAR POR ID  0-SAIR");
			opcao = s.nextInt();
			s.nextLine();
			
			switch (opcao) {
			case 1:
				System.out.println("Digite o nome:");
				nome = s.nextLine();
				System.out.println("Digite a data:");
				data = s.nextLine();
				System.out.println("Digite o estado:");
				estado = s.nextLine();
				
				
				
				destinoDAO.create(new Destino(nome,data,estado));
				break;
			case 2:
				
				for (Destino d : destinoDAO.read()) {
				d.mostrar();
				}
				
				break;
			case 3:
				
				System.out.println("Digite o id:");
				id = s.nextInt();
				s.nextLine();
				System.out.println("Digite o nome:");
				nome = s.nextLine();
				System.out.println("Digite a data:");
				data = s.nextLine();
				System.out.println("Digite o estado:");
				estado = s.nextLine();
				
				
				
				destinoDAO.update(new Destino(id,nome,data,estado));
				break;
			case 4:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();
				
				destinoDAO.delete(id);
				break;
			case 5:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();
				
			Destino destino= destinoDAO.readById(id);
			destino.mostrar();	
			
				break;
			default:
				
				break;
			}
			
		} while (opcao != 0);
		
		System.out.println("Até mais!");
		s.close();

	}

}

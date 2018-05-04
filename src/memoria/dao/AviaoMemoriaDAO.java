package memoria.dao;

import java.util.Scanner;

public class AviaoMemoriaDAO {

	private Aviao[] frotaAvioes = new Aviao[100];
	private int indiceAviao;
	private Aviao a;

	public Aviao getA() {
		return a;
	}

	public void setA(Aviao a) {
		this.a = a;
	}

	public AviaoMemoriaDAO() {
		this.indiceAviao = 0;
	}

	public void incluirFrota(Aviao a) {
		frotaAvioes[indiceAviao] = a;
		indiceAviao++;
	}

	public Aviao consultaAviao(Aviao a) {
		for (Aviao aviao : frotaAvioes) {
			if (aviao!=null && aviao.getNome().equalsIgnoreCase(a.getNome()))
				return a;
		}
		return null;
	}

	public void deletaAviao(Aviao a) {
		for (int i = 0; i < frotaAvioes.length; i++) {
			if (frotaAvioes[i]!=null && frotaAvioes[i].getNome().equalsIgnoreCase(a.getNome())) {
				frotaAvioes[i] = frotaAvioes[i + 1];
			}
		}

	}

	public Aviao[] consultaTodos() {
		return frotaAvioes;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		AviaoMemoriaDAO dao = new AviaoMemoriaDAO();
		menu();
		while(sc.hasNext()) {
			dao.escolheOperacao(sc.nextInt(), sc, dao);
		}
	}

	private static void menu() {
		Print.print("\t\n\n Escolha uma das operações abaixo:\t\n\n"
				+ "\t\n\n 1-Incluir"
				+ "\t\n\n 2-Consultar um único avião"
				+ "\t\n\n 3-Consultar todos"
				+ "\t\n\n 4-Deletar o último avião inserido");
	}

	public void escolheOperacao(int op, Scanner sc, AviaoMemoriaDAO dao ) {
		switch (op) {
		case 1:
			this.setA(incluir(sc, dao));
			menu();
			break;
		case 2:
			consultar(dao, this.getA(), sc);
			menu();
			break;
		case 3:
			consultarTodos(dao);
			menu();
			break;
		case 4:
			deletar(dao, this.getA(), sc);
			menu();
			break;

		default:
			Print.print("Escolha somente de 1 a 4");
			menu();
			break;
		}
	}

	private void deletar(AviaoMemoriaDAO dao, Aviao a, Scanner sc) {
		Print.print("Deletar o último avião");
		Print.print("Digite o nome do avião");
		a.setNome(sc.next());
		dao.deletaAviao(a);

	}

	private static void consultarTodos(AviaoMemoriaDAO dao) {
		Print.print("Consultar Todos!");
		Aviao[] consultaTodos = dao.consultaTodos();
		for (Aviao aviao : consultaTodos) {
			if(aviao!=null)
				Print.print(aviao);
		}
	}

	private static void consultar(AviaoMemoriaDAO dao, Aviao a, Scanner sc) {
		Print.print("Consultar único avião");
		Print.print("Digite o nome do aviao a consultar:");
		a.setNome(sc.next());
		Aviao aviao = dao.consultaAviao(a);
		Print.print(aviao);
	}

	private static Aviao incluir(Scanner sc, AviaoMemoriaDAO dao) {
		communication();
		String nome = sc.next();
		int rodas = sc.nextInt();
		double motor = sc.nextDouble();
		int asas = sc.nextInt();
		boolean isJato = sc.nextBoolean();
		int poltronas = sc.nextInt();
		String computadorInterno = sc.next();
		Aviao a = new Aviao(nome, rodas, motor, asas, isJato, poltronas, computadorInterno);
		dao.incluirFrota(a);
		return a;
	}

	private static void communication() {
		Print.print("\t Digite o nome do avião:\t");
		Print.print("\t Digite o nº de rodas do avião:\t");
		Print.print("\t Digite quantas cilindradas tem o motor:\t");
		Print.print("\t Digite quantas asas tem o avião:\t");
		Print.print("\t O avião é Jato?\t");
		Print.print("\t Quantas poltronas tem o avião:\t");
		Print.print("\t Qual o nome do computador do avião? É o Jarvis? \t");
	}

}

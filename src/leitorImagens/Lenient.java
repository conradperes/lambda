package leitorImagens;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Lenient {

	public static void main(String[] args) {
		System.out.println(retornaDataValida());
	}

	private static Date retornaDataValida() {
		try {
			Calendar data = Calendar.getInstance();
			data.setLenient(false);
			System.out.println(data.isLenient());
			Scanner sc = new  Scanner(System.in);
			System.out.println("Digite o ano:");
			System.out.println("Digite o mês:");
			System.out.println("Digite o dia:");
			System.out.println("Digite a hora:");
			System.out.println("Digite o minuto:");
			System.out.println("Digite o segundo:");
			data.set(sc.nextInt(), sc.nextInt()-1, sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
			return data.getTime();
		} catch (Exception e) {
			System.out.println("Data Inválida");
		}
		return null;
	}

}

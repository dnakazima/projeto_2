package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Funcionario;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Funcionario> list = new ArrayList<>();

		System.out.print("Quantos funcionários serão registrados: ");
		int N = sc.nextInt();

		for (int i = 1; i <= N; i++) {
			System.out.println();
			System.out.print("Digite o id do Funcionario " + i + ": ");

			// System.out.print(" Id: ");

			int id = sc.nextInt();
			while (hasId(list, id)) {
				System.out.print("Este id ja existe. Tente outro: ");
				id = sc.nextInt();
			}

			System.out.print("Nome: ");
			sc.nextLine();// antes de sc.nextLine
			String nome = sc.nextLine();

			System.out.print("Salário: ");
			Double salario = sc.nextDouble();

			Funcionario func = new Funcionario(id, nome, salario);

			list.add(func);

		}

		System.out.println();
		System.out.print("Qual funcionário terá aumento: ");

		
		int id = sc.nextInt();

		Funcionario emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		if (emp == null) {
			System.out.println("Funcionario não existe!");
		} else {
			System.out.println();
			System.out.print("Entre com o aumento: ");
			double percentage = sc.nextDouble();
			emp.aumentoSalario(percentage);
		}

		System.out.println();
		System.out.println("Funcionarios: ");
		for (Funcionario obj : list) {
			System.out.println(obj);
		}

		sc.close();

	}

	public static boolean hasId(List<Funcionario> list, int id) {
		Funcionario emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
	}

}

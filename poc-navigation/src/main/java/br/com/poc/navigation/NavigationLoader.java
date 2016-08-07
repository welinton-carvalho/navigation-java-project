/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.poc.navigation;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.com.poc.navigation.component.NavigationComponent;
import br.com.poc.navigation.configuration.ApplicationContextNavigation;
import br.com.poc.navigation.exception.InvalidCommandException;
import br.com.poc.navigation.exception.ParseInputCommandException;
import br.com.poc.navigation.exception.util.ExceptionMessageCollector;

/**
 *
 * @author wpadua
 */
public class NavigationLoader {

	private NavigationComponent navigationComponent;

	public NavigationLoader() {

	}

	public static void main(String[] args) {

		final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				ApplicationContextNavigation.class);

		NavigationLoader navigationLoader = new NavigationLoader();

		navigationLoader.setNavigationComponent(applicationContext
				.getBean(NavigationComponent.class));

		navigationLoader.startNavigation();

		applicationContext.close();

	}

	private void startNavigation() {

		Scanner scanner = new Scanner(System.in);

		this.printLogo();

		boolean continueExecution = true;

		do {

			this.printMenu();

			final String option = scanner.next();

			switch (option) {

			case "1":

				try {

					this.printCommandList();

					String commands = scanner.next();

					System.out.println("\n > Aguarde o processamento....");

					System.out.println("\n > Comandos inputados: " + commands);

					final String distinateCoordinate = navigationComponent
							.traceRoute(commands).toString();

					System.out.println("\n > A rota final será: "
							+ distinateCoordinate);

				} catch (ParseInputCommandException | InvalidCommandException exception) {

					System.out
							.println("\n > Ocorreram alguns erros ao processar a sequência de comandos:\n");

					final List<String> messages = ExceptionMessageCollector
							.getStackMessages(exception);

					messages.stream().forEach((message) -> {
						System.out.println(message);
					});

				}

				break;

			case "2":

				System.out.println("\n > Obrigado por navegar conosco! \n");

				scanner.close();

				continueExecution = false;

				break;

			default:

				System.out.println("\n > Opção de menu inválida.");

				break;

			}

		} while (continueExecution);

	}

	public void printCommandList() {

		System.out.println("\n____________________________");
		System.out.println("|  COMANDOS DISPONÍVEIS     |");
		System.out.println("____________________________");
		System.out.println("|  L - Girar a esquerda     |");
		System.out.println("|  R - Girar a direita      |");
		System.out.println("|  M - Mover                |");
		System.out.println("|  U - Emergir / Subir      |");
		System.out.println("|  D - Submergir / Descer   |");
		System.out.println("____________________________");
		System.out.print(" > Digite a sequência de comandos de navegação: ");

	}

	public void printMenu() {

		System.out.println("\n____________________________");
		System.out.println("|  MENU                    |");
		System.out.println("____________________________");
		System.out.println("|  1 - Traçar rota.        |");
		System.out.println("|  2 - Sair.               |");
		System.out.println("____________________________");
		System.out.print(" > Digite a opção desejada: ");

	}

	public void printLogo() {

		System.out.println(",.-~*´¨¯¨`*·~-.¸,.-~*´¨¯¨`*·~-~*´¨¯ \n");
		System.out.println("    Bem-vindo ao Navigation 1.0     \n");
		System.out.println(",.-~*´¨¯¨`*·~-.¸,.-~*´¨¯¨`*·~-~*´¨¯ ");
		System.out.println(",.-~*´¨¯¨`*·~ |0000.¸,.-~*´¨¯¨`*·~- ");
		System.out.println(",.-~*´¨ ______| |_____________ ~*´¨ ");
		System.out.println(",.-~*´oo\\____________________/,.-~* ");
		System.out.println(",.-~*´¨¯¨`*·~-.¸,.-~*´¨¯¨`*·~-~*´¨¯ ");
		System.out.println(".¸,.-~*´¨¯¨`*·~-.¸,.-~*´¨¯¨`*·~-~*´ ");

	}

	public void setNavigationComponent(NavigationComponent navigationComponent) {
		this.navigationComponent = navigationComponent;
	}

}

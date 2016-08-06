/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.poc.navigation;

import java.util.Scanner;

import br.com.poc.navigation.component.NavigationComponent;
import br.com.poc.navigation.component.impl.NavigationComponentImpl;

/**
 *
 * @author desenv
 */
public class NavigationLoader {

    public static void main(String[] args) {

        NavigationComponent navigationComponent = new NavigationComponentImpl();

        Scanner scanner = new Scanner(System.in);

        printLogo();

        boolean continueExecution = true;

        do {

            printMenu();

            final String option = scanner.next();

            switch (option) {

                case "1":

                    System.out.print("\n > Digite os comandos de navegação: ");

                    String commands = scanner.next();

                    System.out.println("\n > Aguarde o processamento....");

                    System.out.println("\n > Comandos inputados: " + commands);

                    final String distinateCoordinate = " 3 , -2 , -4 , NORTE";
                    //navigationComponent.processar(commands);

                    System.out.println("\n > A rota final será: " + distinateCoordinate);

                    break;

                case "2":

                    System.out.println("\n > Obrigado por navegar conosco! \n");

                    continueExecution = false;

                    break;

                default:

                    System.out.println("\n > Opção de menu inválida.");

                    break;

            }

        } while (continueExecution);

    }

    public static void printMenu() {

        System.out.println("\n____________________________");
        System.out.println("|  MENU                    |");
        System.out.println("____________________________");
        System.out.println("|  1 - Traçar rota.        |");
        System.out.println("|  2 - Sair.               |");
        System.out.println("____________________________");
        System.out.print(" > Digite a opção desejada: ");

    }

    public static void printLogo() {

        System.out.println(",.-~*´¨¯¨`*·~-.¸,.-~*´¨¯¨`*·~-~*´¨¯ \n");
        System.out.println("    Bem-vindo ao Navigation 1.0     \n");
        System.out.println(",.-~*´¨¯¨`*·~-.¸,.-~*´¨¯¨`*·~-~*´¨¯ ");
        System.out.println(",.-~*´¨¯¨`*·~ |0000.¸,.-~*´¨¯¨`*·~- ");
        System.out.println(",.-~*´¨ ______| |_____________ ~*´¨ ");
        System.out.println(",.-~*´oo\\____________________/,.-~* ");
        System.out.println(",.-~*´¨¯¨`*·~-.¸,.-~*´¨¯¨`*·~-~*´¨¯ ");
        System.out.println(".¸,.-~*´¨¯¨`*·~-.¸,.-~*´¨¯¨`*·~-~*´ ");

    }

}

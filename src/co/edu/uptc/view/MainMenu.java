package co.edu.uptc.view;

import co.edu.uptc.util.Utilities;

import java.util.Scanner;

/**
 *
 * @author Yulian Alexis Tobar Rios
 * @author Maryory Patricia Orozco
 */
public class MainMenu {

    private final Scanner scanner;

    public MainMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    public String showOption() {
        System.out.println(Utilities.AZUL);
        System.out.println("==========================================");
        System.out.println("||      ADMINISTRADOR DE PRODUCTOS      ||");
        System.out.println("==========================================");
        System.out.println("|| 1. Agregar producto                  ||");
        System.out.println("|| 2. Listar productos                  ||");
        System.out.println("|| 3. Listar ordenados por nombre       ||");
        System.out.println("|| 4. Borrar producto                   ||");
        System.out.println("|| 0. Salir                             ||");
        System.out.println("==========================================");
        System.out.print("Seleccione una opcion: ");
        System.out.print(Utilities.RESET);
        return scanner.nextLine();
    }
}

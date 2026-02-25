/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.uptc.view;

import co.edu.uptc.interfaces.PresenterInterface;
import co.edu.uptc.interfaces.ViewInterface;
import co.edu.uptc.model.Product;
import co.edu.uptc.util.Utilities;

import java.util.Scanner;

/**
 *
 * @author Yulian Alexis Tobar Rios
 * @author Maryory Patricia Orozco
 */
public class ConsoleView implements ViewInterface {

    private PresenterInterface presenter;
    private Scanner scanner = new Scanner(System.in);
    private boolean isRunning = true;

    @Override
    public void setPresenter(PresenterInterface presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showMessage(String message) {
        System.out.println(Utilities.VERDE + "\n" + message + Utilities.RESET);
    }

    @Override
    public void start() {

        while (isRunning) {

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
            System.out.print(" Seleccione una opción: ");
            System.out.print(Utilities.RESET);

            String option = scanner.nextLine();

            switch (option) {

                case "1":
                    readInfo();
                    break;
                case "2":
                    presenter.showProducts();
                    break;
                case "3":
                    presenter.sortByName();
                    break;
                case "4":
                    System.out.print(Utilities.AZUL + "Ingrese nombre del producto: " + Utilities.RESET);
                    String name = scanner.nextLine();
                    presenter.deleteByName(name);
                    break;
                case "0":
                    isRunning = false;
                    System.out.println(Utilities.AZUL + "\nSaliendo..." + Utilities.RESET);
                    break;
                default:
                    System.out.println(Utilities.ROJO + "\nOpción inválida." + Utilities.RESET);
            }
        }
    }

    private void readInfo() {

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Precio: ");
        double precio = Double.parseDouble(scanner.nextLine());

        System.out.print("Unidad de medida: ");
        String unidad = scanner.nextLine();

        Product p = new Product(nombre, precio, unidad);
        presenter.addEnd(p);
    }
}

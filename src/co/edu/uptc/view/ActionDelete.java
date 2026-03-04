package co.edu.uptc.view;

import co.edu.uptc.interfaces.PresenterInterface;
import co.edu.uptc.util.Utilities;

import java.util.Scanner;

/**
 *
 * @author Yulian Alexis Tobar Rios
 * @author Maryory Patricia Orozco
 */
public class ActionDelete {

    private final Scanner scanner;

    public ActionDelete(Scanner scanner) {
        this.scanner = scanner;
    }

    public void delete(PresenterInterface presenter) {
        System.out.print(Utilities.AZUL + "Ingrese nombre del producto a borrar: " + Utilities.RESET);
        String name = scanner.nextLine();
        presenter.deleteByName(name);
    }
}

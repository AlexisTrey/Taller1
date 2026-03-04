package co.edu.uptc.view;

import co.edu.uptc.pojo.Product;
import co.edu.uptc.util.Utilities;

import java.util.Scanner;

/**
 *
 * @author Yulian Alexis Tobar Rios
 * @author Maryory Patricia Orozco
 */
public class ProductReader {

    private final Scanner scanner;
    private final UnitsMenu unitsMenu;

    public ProductReader(Scanner scanner) {
        this.scanner = scanner;
        this.unitsMenu = new UnitsMenu(scanner);
    }

    public Product readProduct() {
        String name = readName();
        if (name == null) {
            return null;
        }

        Double price = readPrice();
        if (price == null) {
            return null;
        }

        String unit = unitsMenu.selectUnit();
        return new Product(name, price, unit);
    }

    private String readName() {
        System.out.print("Nombre: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println(Utilities.ROJO + "Nombre no puede estar vacio" + Utilities.RESET);
            return null;
        }
        return name;
    }

    private Double readPrice() {
        try {
            System.out.print("Precio: ");
            double price = Double.parseDouble(scanner.nextLine());
            if (price < 0) {
                System.out.println(Utilities.ROJO + "Precio no puede ser negativo" + Utilities.RESET);
                return null;
            }
            return price;
        } catch (NumberFormatException e) {
            System.out.println(Utilities.ROJO + "Precio invalido" + Utilities.RESET);
            return null;
        }
    }
}

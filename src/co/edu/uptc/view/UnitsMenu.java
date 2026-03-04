package co.edu.uptc.view;

import co.edu.uptc.util.Utilities;

import java.util.Scanner;

/**
 *
 * @author Yulian Alexis Tobar Rios
 * @author Maryory Patricia Orozco
 */
public class UnitsMenu {

    private final Scanner scanner;

    private static final String[] UNITS = {
        "Kilogramos (Kg)",
        "Libras (Lb)",
        "Unidad (Und)",
        "Litros (Lt)",
        "Gramos (g)"
    };

    public UnitsMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    public String selectUnit() {
        showMenu();
        return getUnitByOption(scanner.nextLine().trim());
    }

    private void showMenu() {
        System.out.println(Utilities.AZUL + "--- Unidad de Medida ---");
        for (int i = 0; i < UNITS.length; i++) {
            System.out.println((i + 1) + ". " + UNITS[i]);
        }
        System.out.print("Seleccione número: " + Utilities.RESET);
    }

    private String getUnitByOption(String option) {
        try {
            int index = Integer.parseInt(option) - 1;
            if (index >= 0 && index < UNITS.length) {
                return UNITS[index];
            }
        } catch (NumberFormatException ignored) {
        }
        return "Unidad (Und)";
    }
}

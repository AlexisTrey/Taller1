package co.edu.uptc.model;

import co.edu.uptc.interfaces.ModelInterface;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 *
 * @author Yulian Alexis Tobar Rios
 * @author Maryory Patricia Orozco
 */
public class ManagerLinkedList implements ModelInterface {

    private LinkedList<Product> products = new LinkedList<>();

    @Override
    public void addEnd(Product product) {
        products.add(product);
    }

    @Override
    public String showProducts() {
        if (products.isEmpty()) {
            return "Lista vacía.";
        }

        String result = "";
        for (Product p : products) {
            result += p + "\n";
        }
        return result;
    }

    @Override
    public String sortByName() {
        if (products.isEmpty()) {
            return "Lista vacía.";
        }

        LinkedList<Product> copyList = new LinkedList<>(products);

        Collections.sort(copyList, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return p1.getDescription()
                        .compareToIgnoreCase(p2.getDescription());
            }
        });

        String result = "";
        for (Product p : copyList) {
            result += p + "\n";
        }

        return result;
    }

    @Override
    public String deleteByName(String name) {

        if (products.isEmpty()) {
            return "Lista vacía.";
        }

        int sizeBefore = products.size();

        products.removeIf(p
                -> p.getDescription()
                        .toLowerCase()
                        .contains(name.toLowerCase()));

        if (products.size() == sizeBefore) {
            return "No se encontró un producto con ese nombre.";
        }

        return "Producto eliminado correctamente.";
    }

}

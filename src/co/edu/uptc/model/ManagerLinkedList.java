package co.edu.uptc.model;

import co.edu.uptc.interfaces.ModelInterface;
import co.edu.uptc.pojo.Product;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

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
        if (products.isEmpty()) return "Lista vacía.";
        return buildString(products);
    }

    private String buildString(List<Product> list) {
        StringBuilder sb = new StringBuilder();
        for (Product p : list) sb.append(p).append("\n");
        return sb.toString();
    }

    @Override
    public String sortByName() {
        if (products.isEmpty()) return "Lista vacía.";
        LinkedList<Product> copy = new LinkedList<>(products);
        sortList(copy);
        return buildString(copy);
    }

    private void sortList(List<Product> list) {
        Collections.sort(list,
                (p1, p2) -> p1.getDescription()
                        .compareToIgnoreCase(p2.getDescription()));
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

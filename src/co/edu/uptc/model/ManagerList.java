/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.uptc.model;

import co.edu.uptc.interfaces.ModelInterface;
import co.edu.uptc.util.SimpleList;

/**
 *
 * @author Yulian Alexis Tobar Rios
 * @author Maryory Patricia Orozco
 */
public class ManagerList implements ModelInterface {

    private Node<Product> header = null;

    private Node<Product> createNode(Product product) {
        return new Node<>(product);
    }

    @Override
    public void addEnd(Product product) {

        Node nuevo = createNode(product);

        if (header == null) {
            header = nuevo;
        } else {
            Node aux = header;
            while (aux.getNode() != null) {
                aux = aux.getNode();
            }
            aux.setNode(nuevo);
        }
    }

    @Override
    public String showProducts() {

        if (header == null) {
            return "Lista vacía.";
        }

        StringBuilder sb = new StringBuilder();
        Node<Product> aux = header;

        while (aux != null) {
            sb.append(aux.getProduct()).append("\n------------------------\n");
            aux = aux.getNode();
        }

        return sb.toString();
    }

    @Override
    public String sortByName() {

        if (header == null) {
            return "Lista vacía.";
        }

        SimpleList<Product> copyList = new SimpleList<>();

        Node<Product> aux = header;

        while (aux != null) {
            copyList.add(aux.getProduct());
            aux = aux.getNode();
        }

        copyList.sort((p1, p2)
                -> p1.getDescription()
                        .compareToIgnoreCase(p2.getDescription())
        );

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < copyList.size(); i++) {
            sb.append(copyList.get(i))
                    .append("\n------------------------\n");
        }

        return sb.toString();
    }

    @Override
    public String deleteByName(String name) {

        if (header == null) {
            return "Lista vacía.";
        }

        boolean found = false;

        while (header != null
                && header.getProduct().getDescription()
                        .toLowerCase()
                        .contains(name.toLowerCase())) {

            header = header.getNode();
            found = true;
        }

        Node<Product> current = header;

        while (current != null && current.getNode() != null) {

            if (current.getNode().getProduct()
                    .getDescription()
                    .toLowerCase()
                    .contains(name.toLowerCase())) {

                current.setNode(current.getNode().getNode());
                found = true;
            } else {
                current = current.getNode();
            }
        }

        if (!found) {
            return "No se encontró un producto con ese nombre.";
        }

        return "Producto eliminado correctamente.";
    }
}

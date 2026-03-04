/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.uptc.model;

import co.edu.uptc.interfaces.ModelInterface;
import co.edu.uptc.model.util.Node;
import co.edu.uptc.pojo.Product;
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

        Node addition = createNode(product);

        if (header == null) {
            header = addition;
        } else {
            Node aux = header;
            while (aux.getNext() != null) {
                aux = aux.getNext();
            }
            aux.setNext(addition);
        }
    }

    @Override
    public String showProducts() {
        if (header == null) {
            return "Lista vacia.";
        }
        return buildString(header);
    }

    @Override
    public String sortByName() {
        if (header == null) {
            return "Lista vacia.";
        }
        SimpleList<Product> copy = copyToList();
        copy.sort((p1, p2)
                -> p1.getDescription().compareToIgnoreCase(p2.getDescription())
        );
        return buildStringFromList(copy);
    }

    @Override
    public String deleteByName(String name) {
        if (header == null) {
            return "Lista vacia.";
        }
        SimpleList<Product> deleted = collectDeleted(name);
        removeMatching(name);
        if (deleted.isEmpty()) {
            return "No se encontro un producto con ese nombre.";
        }
        return "Productos eliminados:\n" + buildStringFromList(deleted);
    }

    private SimpleList<Product> copyToList() {
        SimpleList<Product> list = new SimpleList<>();
        Node<Product> aux = header;
        while (aux != null) {
            list.add(aux.getProduct());
            aux = aux.getNext();
        }
        return list;
    }

    private SimpleList<Product> collectDeleted(String name) {
        SimpleList<Product> deleted = new SimpleList<>();
        Node<Product> aux = header;
        while (aux != null) {
            if (matches(aux.getProduct(), name)) {
                deleted.add(aux.getProduct());
            }
            aux = aux.getNext();
        }
        return deleted;
    }

    private void removeMatching(String name) {
        while (header != null && matches(header.getProduct(), name)) {
            header = header.getNext();
        }
        Node<Product> current = header;
        while (current != null && current.getNext() != null) {
            if (matches(current.getNext().getProduct(), name)) {
                current.setNext(current.getNext().getNext());
            } else {
                current = current.getNext();
            }
        }
    }

    private boolean matches(Product product, String name) {
        return product.getDescription()
                .toLowerCase()
                .contains(name.toLowerCase());
    }

    private String buildString(Node<Product> start) {
        StringBuilder sb = new StringBuilder();
        Node<Product> aux = start;
        while (aux != null) {
            sb.append(aux.getProduct()).append("\n------------------------\n");
            aux = aux.getNext();
        }
        return sb.toString();
    }

    private String buildStringFromList(SimpleList<Product> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append("\n------------------------\n");
        }
        return sb.toString();
    }
}

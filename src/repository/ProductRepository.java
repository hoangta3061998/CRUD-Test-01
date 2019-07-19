package repository;

import model.Product;

public class ProductRepository implements GeneralRepository<Product> {
    private Product[] listProduct = new Product[20];
    private int size = 0;

    public int getSize() {
        return size;
    }

    @Override
    public Product[] findAll() {
        return listProduct;
    }

    @Override
    public int add(Product product) {
        if (size != 0) {
            for (int i = 0; i < listProduct.length - 1; i++) {
                if (listProduct[i] != null) {
                    if (listProduct[i].getId() == (product.getId())) {
                        return -2;
                    }
                }
            }
        }
        if (size >= listProduct.length) {
            return -1;
        }
        listProduct[size] = product;
        size++;
        return 1;
    }

    @Override
    public boolean editById(int id, Product product) {
        boolean isEditted = false;
        int index = getIndexById(id);
        if (index != -1) {
            listProduct[index].setName(product.getName());
            listProduct[index].setPrice(product.getPrice());
            listProduct[index].setDescription(product.getDescription());
            isEditted = true;
        }
        return isEditted;

    }

    @Override
    public boolean deleteById(int id) {
        boolean isDeleted = false;
        int index = getIndexById(id);
        if (index != -1) {
            for (int i = index; i < listProduct.length - 1; i++) {
                listProduct[i] = listProduct[i + 1];
            }
            listProduct[listProduct.length - 1] = null;
            isDeleted = true;
            size--;
        }
        return isDeleted;
    }

    @Override
    public Product findByName(String name) {
        int index = -1;
        for (int i = 0; i < listProduct.length - 1; i++) {
            if (listProduct[i] != null) {
                if (listProduct[i].getName().equals(name)) {
                    index = i;
                }
            }
        }
        if (index != -1) {
            Product product = listProduct[index];
            return product;
        }
        return null;
    }

    @Override
    public void sortByPrice() {
        Product temp = null;
        for (int i = 0; i < listProduct.length - 1; i++) {
            for (int j = i + 1; j < listProduct.length; j++) {
                if (listProduct[i] != null && listProduct[j] != null) {
                    if (listProduct[i].getPrice() < listProduct[j].getPrice()) {
                        temp = listProduct[i];
                        listProduct[i] = listProduct[j];
                        listProduct[j] = temp;
                    }
                }
            }
        }
    }

    private int getIndexById(int id) {
        int index = -1;
        for (int i = 0; i < listProduct.length; i++) {
            if (listProduct[i] != null) {
                if (listProduct[i].getId() == id) {
                    index = i;
                }
            }
        }
        return index;
    }
}

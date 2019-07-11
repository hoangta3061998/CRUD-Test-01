package controller;

import model.Product;
import service.ProductService;

public class ProductController {
    ProductService productService = new ProductService();

    public Product[] findAll() {
        return productService.findAll();
    }

    public int add(Product product) {
        return productService.add(product);
    }

    public boolean editById(int id, Product product) {
        return productService.editById(id, product);
    }

    public boolean deleteById(int id) {
        return productService.deleteById(id);
    }

    public Product findByName(String name) {
        return productService.findByName(name);
    }

    public void sortByPrice() {
        productService.sortByPrice();
    }
}

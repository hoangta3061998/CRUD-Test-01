package service;

import model.Product;
import repository.ProductRepository;

public class ProductService implements GeneralService<Product> {
    private ProductRepository productRepository = new ProductRepository();

    @Override
    public Product[] findAll() {
        return productRepository.findAll();
    }

    @Override
    public int add(Product product) {
        return productRepository.add(product);
    }

    @Override
    public boolean editById(int id, Product product) {
        return productRepository.editById(id, product);
    }

    @Override
    public boolean deleteById(int id) {
        return productRepository.deleteById(id);
    }

    @Override
    public Product findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public void sortByPrice() {
        productRepository.sortByPrice();
    }
    public int getSize(){
        return productRepository.getSize();
    }
}

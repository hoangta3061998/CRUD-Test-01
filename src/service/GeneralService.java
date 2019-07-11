package service;

public interface GeneralService<T> {
    T[] findAll();

    int add(T t);

    boolean editById(int id, T t);

    boolean deleteById(int id);

    T findByName(String name);

    void sortByPrice();

}

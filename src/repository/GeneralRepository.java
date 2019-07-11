package repository;

public interface GeneralRepository<T> {
    T[] findAll();
    int add( T t);
    boolean editById(int id,T t);
    boolean deleteById(int id);
    T findByName(String name);
    void sortByPrice();
}

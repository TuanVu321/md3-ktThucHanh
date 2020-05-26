package service;

import model.Product;

import java.util.List;

public interface IProductService {
    List<Product> showList();
public void save(Product product);
Product findByid(int id);
void remove(int id);
List <Product> findByName(String name);
}

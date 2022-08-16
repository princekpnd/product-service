package customer.service.com.Dao;

import java.util.List;

import customer.service.com.Entity.Product;

public interface IProductDao {
List<Product> getAllProductDetailsBySupplierName(String supplier);

public void indexProduct();

public List<Product> searchProduct(String keyword);

public boolean exitsByName(String name);

void addProduct(Product product);


}

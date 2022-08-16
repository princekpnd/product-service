package customer.service.com.Service;

import java.util.List;

import customer.service.com.Entity.Product;

public interface IProductService {

List<Product> getAllProductDetailsBySupplierName(String supplier);

public boolean exitsByName(String name);

public boolean createProduct(Product product);


}

package customer.service.com.ServiceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import customer.service.com.Dao.IProductDao;
import customer.service.com.Entity.Product;
import customer.service.com.Service.IProductService;

@Transactional
@Repository
public class ProductServiceImpl  implements IProductService{

	@Autowired
	IProductDao productDao;
	
	@Override
	public List<Product> getAllProductDetailsBySupplierName(String supplier) {
		return productDao.getAllProductDetailsBySupplierName(supplier);
	}

	@Override
	public boolean exitsByName(String name) {
		return productDao.exitsByName(name);
	}

	@Override
	public boolean createProduct(Product product) {
		if(exitsByName(product.getName())) {
			return false;
		}else {
			productDao.addProduct(product);
			return true;
		}
		
	}

	

}

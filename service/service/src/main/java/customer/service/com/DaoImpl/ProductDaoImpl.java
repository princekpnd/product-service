package customer.service.com.DaoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import customer.service.com.Dao.IProductDao;
import customer.service.com.Entity.Product;

@Transactional
@Repository
public class ProductDaoImpl implements IProductDao {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<Product> getAllProductDetailsBySupplierName(String supplier) {
		List<Product> productList = entityManager.createNamedQuery("Product.getBySupplierName", Product.class)
				.setParameter("supplier", supplier).getResultList();
		return productList;
	}

	@Override
	public void indexProduct() {
		try {
//		      FullTextEntityManager fullTextEntityManager =
//		        Search.getFullTextEntityManager(entityManager);
//		      fullTextEntityManager.createIndexer().startAndWait();
			FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
			fullTextEntityManager.createIndexer().startAndWait();
		} catch (InterruptedException e) {
			System.out.println("An error occurred trying to build the serach index: " + e.toString());
		}

	}

	@Override
	public List<Product> searchProduct(String keyword) {
		// get the full text entity manager
		FullTextEntityManager fullTextEntityManager = org.hibernate.search.jpa.Search
				.getFullTextEntityManager(entityManager);

		// create the query using Hibernate Search query DSL
		QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory().buildQueryBuilder()
				.forEntity(Product.class).get();

		// a very basic query by keywords
		org.apache.lucene.search.Query query = queryBuilder.keyword().onFields("name", "name").matching(keyword)
				.createQuery();

		// wrap Lucene query in an Hibernate Query object
		org.hibernate.search.jpa.FullTextQuery jpaQuery = fullTextEntityManager.createFullTextQuery(query,
				Product.class);

		// execute search and return results (sorted by relevance as default)
		@SuppressWarnings("unchecked")
		List<Product> results = (List<Product>) jpaQuery.getResultList();

		return results;
	}

	@Override
	public boolean exitsByName(String name) {
		Product product = entityManager.createNamedQuery("Product.findExit", Product.class).setParameter("name", name)
				.getResultList().stream().findFirst().orElse(null);
		return null != product ? Boolean.TRUE : Boolean.FALSE;
	}

	@Override
	public void addProduct(Product product) {
		entityManager.persist(product);

	}

}

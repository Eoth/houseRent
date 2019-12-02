package Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import estateProduct.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
	
	@Query("SELECT p FROM Product p WHERE p.productId=?1")
	public Product findById(int id);

	@Query("DELETE FROM Product p WHERE p.productId=:id")
	public void deleteById(@Param("id") int id);
	
   
}

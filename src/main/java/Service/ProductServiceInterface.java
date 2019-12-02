package Service;

import java.util.List;

import estateProduct.Product;

public interface ProductServiceInterface {
	
	public List<Product> findAllProduct();
	public Product findByProductId(int id);
	public void deleteByProductId(int id);
	public void saveProduct(Product product);

}

package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Repository.ProductRepository;
import estateProduct.Product;

@Service
public class ProductService implements ProductServiceInterface {
	
@Autowired  private ProductRepository productRepository;
	
	
	public List<Product> findAllProduct() {
        List<Product> produits = (List<Product>) productRepository.findAll();
        return produits;
    }
	
	public Product findByProductId(int id) {
		Product product = productRepository.findById(id);
		return product;
	}
	
	public void deleteByProductId(int id) {
		 productRepository.deleteById(id);
	}

	public void saveProduct(Product product) {
		productRepository.save(product);
	}

}

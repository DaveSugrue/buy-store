package ie.sogeti.buy.repo;

import java.util.ArrayList;

import ie.sogeti.buy.domain.Product;

public interface ProductRepo {

	public void createProduct(Product p);

	public void createAllProducts(ArrayList<Product> products);

	public ArrayList<Product> getAllProducts();

	public Product getProduct(int id);

	// Returns the id code of the product updated. If zero, there was an error.
	public boolean updateProduct(int id, Product product);

}

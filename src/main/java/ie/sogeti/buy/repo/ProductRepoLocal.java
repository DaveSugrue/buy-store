package ie.sogeti.buy.repo;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import ie.sogeti.buy.domain.Product;

@Repository("productRepo")
@Scope("singleton")
public class ProductRepoLocal implements ProductRepo {

	private final Logger	log				= LoggerFactory.getLogger(this.getClass());

	ArrayList<Product>		storedProducts	= new ArrayList<Product>();

	@Override
	public void createProduct(Product p) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createAllProducts(ArrayList<Product> products) {

		System.out.println("creating");
		try {

			storedProducts = products;

		} catch (Exception e) {
			System.out.println("in the repo");
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Product> getAllProducts() {
		System.out.println("getting the products" + storedProducts.toString());

		return storedProducts;
	}

	@Override
	public Product getProduct(int id) {
		System.out.println("getting product " + id + " - " + storedProducts.toString());

		Product result = new Product();

		try {
			result = storedProducts.get(id);
		} catch (IndexOutOfBoundsException ioobe) {
			System.out.println("Product Not Found");
		} catch (Exception e) {
			System.out.println("Generic Error");
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public boolean updateProduct(int id, Product product) {

		boolean result = false;

		Product productToUpdate = getProduct(id);

		if (null != productToUpdate) {

			System.out.println("Updating product " + productToUpdate.toString());
			System.out.println("To " + product.toString());
			System.out.println("id currently = " + id);
			storedProducts.set(id, product);
			System.out.println("In the Arraylist, it is now " + storedProducts.get(id).toString());
			result = true;
		}

		System.out.println("NOW UPDATED:: getting the products" + storedProducts.toString());

		return result;
	}

}

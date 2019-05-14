package ie.sogeti.buy.service.product;

import java.util.ArrayList;

import ie.sogeti.buy.domain.Product;

public interface GetProductService {

	public ArrayList<Product> getAllProducts();

	public Product getProduct(int id);

}

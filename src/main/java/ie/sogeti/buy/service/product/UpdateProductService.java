package ie.sogeti.buy.service.product;

import ie.sogeti.buy.domain.Product;

public interface UpdateProductService {

	public boolean updateProduct(int id, Product product);

	public boolean validateProductDetails(int id, Product product);
}

package ie.sogeti.buy.service.product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.sogeti.buy.domain.Product;
import ie.sogeti.buy.repo.ProductRepo;

@Service("updateProductService")
public class UpdateProductServiceImpl implements UpdateProductService {

	private final Logger	log	= LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ProductRepo		productRepo;

	@Override
	public boolean updateProduct(int id, Product product) {

		boolean result = false;

		if (validateProductDetails(id, product)) {
			result = productRepo.updateProduct(id, product);
		}

		return result;

	}

	/**
	 * Provides basic validation, ensuring that the correct product detail is being submitted for the intended product
	 */
	@Override
	public boolean validateProductDetails(int id, Product product) {
		boolean result = false;

		if (id == product.getId()) {
			result = true;
		}
		return result;
	}

}

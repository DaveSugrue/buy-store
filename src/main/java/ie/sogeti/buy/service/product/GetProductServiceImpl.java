package ie.sogeti.buy.service.product;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.sogeti.buy.domain.Product;
import ie.sogeti.buy.repo.ProductRepo;

@Service("getProductService")
public class GetProductServiceImpl implements GetProductService {

	private final Logger	log	= LoggerFactory.getLogger(this.getClass());

	@Autowired
	ProductRepo				productRepo;

	@Override
	public ArrayList<Product> getAllProducts() {

		ArrayList<Product> products = productRepo.getAllProducts();

		return products;

	}

	@Override
	public Product getProduct(int id) {

		Product product = productRepo.getProduct(id);

		return product;

	}

}

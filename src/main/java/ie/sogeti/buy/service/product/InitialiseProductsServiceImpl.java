package ie.sogeti.buy.service.product;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.sogeti.buy.domain.Product;
import ie.sogeti.buy.repo.ProductRepo;
import ie.sogeti.buy.repo.ProductRepoLocal;

@Service
public class InitialiseProductsServiceImpl implements InitialiseProductsService {

	private final Logger	log	= LoggerFactory.getLogger(this.getClass());

	@Autowired
	ProductRepo				productRepo;

	@Override
	public void init() {

		ArrayList<Product> products = new ArrayList<Product>();

		products.add(new Product(0, "SamZung A5 phone", 250, "phone"));
		products.add(new Product(1, "Pear myPhoneX", 900, "phone"));
		products.add(new Product(2, "pear myPhone7", 300, "phone"));
		products.add(new Product(3, "SIM Card", 20, "sim"));
		products.add(new Product(4, "Insurance per product", 120, "insurance"));
		products.add(new Product(5, "40\" SamZung TV SZX40", 700, "tv"));
		products.add(new Product(6, "50\" SamZung TV SZX50", 900, "tv"));
		products.add(new Product(7, "32\" XG TV XGX32", 350, "tv"));
		products.add(new Product(8, "Phone Case", 0, "case"));

		try {
			ProductRepoLocal pr = new ProductRepoLocal();
			if (null == productRepo) {
				System.out.println("wtf");
			}
			productRepo.createAllProducts(products);
			System.out.println("Products Created");
			System.out.println("Created " + productRepo.getAllProducts().size() + " products");
		} catch (Exception e) {
			System.out.println("What's going on");
			e.printStackTrace();
		}
	}

}

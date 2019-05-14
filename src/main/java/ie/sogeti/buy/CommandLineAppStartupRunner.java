package ie.sogeti.buy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ie.sogeti.buy.service.product.InitialiseProductsService;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

	@Autowired
	InitialiseProductsService initProduct;

	@Override
	public void run(String... args) throws Exception {

		System.out.println("------Starting Up--------");

		try {
			initProduct.init();
		} catch (Exception e) {
			System.out.println("Problems");
			e.printStackTrace();
		}
	}
}

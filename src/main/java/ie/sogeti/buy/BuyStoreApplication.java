package ie.sogeti.buy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import ie.sogeti.buy.service.product.InitialiseProductsService;

@ComponentScan
@SpringBootApplication
public class BuyStoreApplication {

	@Autowired
	InitialiseProductsService initProduct;

	public static void main(String[] args) {
		SpringApplication.run(BuyStoreApplication.class, args);
	}

}

package ie.sogeti.buy.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ie.sogeti.buy.domain.Product;
import ie.sogeti.buy.service.product.GetProductService;
import ie.sogeti.buy.service.product.UpdateProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	private final Logger	log	= LoggerFactory.getLogger(this.getClass());

	@Autowired
	GetProductService		getProductService;
	@Autowired
	UpdateProductService	updateProductService;

	// Get Product List
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ArrayList<Product> getProductList() {
		System.out.println("Getting...");
		return getProductService.getAllProducts();
	}

	// Update Product
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void updateProduct(@PathVariable int id, @RequestBody Product product) {
		System.out.println("Updating...");
		updateProductService.updateProduct(id, product);
	}
}

package ie.sogeti.buy.service.basket;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.sogeti.buy.domain.Item;
import ie.sogeti.buy.domain.Product;
import ie.sogeti.buy.domain.Receipt;
import ie.sogeti.buy.service.product.GetProductService;

@Service
public class GetBasketServiceImpl implements GetBasketService {

	@Autowired
	GetProductService getProductService;

	@Override
	public int getInitialTotal(ArrayList<Item> basket) {

		int total = 0;

		for (Item item : basket) {
			total += (item.getPrice() * item.getQuantity());
		}

		return total;
	}

	public ArrayList<Item> populateBasketCase(ArrayList<Item> basket) {
		ArrayList<Item> populatedBasket = new ArrayList<Item>();
		Product product = new Product();
		Item temp = new Item();

		for (Item item : basket) {
			product = getProductService.getProduct(item.getId());

			item.setName(product.getName());
			item.setPrice(product.getPrice());
			item.setType(product.getType());

			populatedBasket.add(item);

		}
		return populatedBasket;
	}

	public Receipt collateBasket(ArrayList<Item> basket) {
		ArrayList<Item> populatedBasket = populateBasketCase(basket);

		int total = 0;

		total = getInitialTotal(basket);

		Receipt receipt = new Receipt(populatedBasket, total);

		return receipt;
	}
}

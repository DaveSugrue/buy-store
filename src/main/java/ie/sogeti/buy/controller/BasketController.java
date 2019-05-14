package ie.sogeti.buy.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ie.sogeti.buy.domain.Item;
import ie.sogeti.buy.domain.Receipt;
import ie.sogeti.buy.service.basket.GetBasketService;

@RestController
@RequestMapping("/basket")
public class BasketController {

	@Autowired
	GetBasketService getBasketService;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public Receipt calculateReceipt(@RequestBody ArrayList<Item> basket) {
		System.out.println("Creating basket");
		return getBasketService.collateBasket(basket);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ArrayList<Item> getBasket() {
		System.out.println("Getting basket");
		ArrayList<Item> basket = new ArrayList<Item>();

		Item item1 = new Item(0, 5, "", 0, "");
		Item item2 = new Item(1, 2, "", 0, "");
		Item item3 = new Item(3, 1, "", 0, "");
		Item item4 = new Item();

		basket.add(item1);
		basket.add(item2);
		basket.add(item3);

		return basket;
	}
}

package ie.sogeti.buy.service.basket;

import java.util.ArrayList;

import ie.sogeti.buy.domain.Item;
import ie.sogeti.buy.domain.Receipt;

public interface GetBasketService {

	public int getInitialTotal(ArrayList<Item> basket);

	public ArrayList<Item> populateBasketCase(ArrayList<Item> basket);

	public Receipt collateBasket(ArrayList<Item> basket);

}

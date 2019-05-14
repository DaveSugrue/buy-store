package ie.sogeti.buy.service.basket;

import java.util.ArrayList;

import ie.sogeti.buy.domain.Item;

public interface DiscountService {

	public int freeSimCard(int total, ArrayList<Item> basket);

	public int extraSimCard(int total, ArrayList<Item> basket);

}

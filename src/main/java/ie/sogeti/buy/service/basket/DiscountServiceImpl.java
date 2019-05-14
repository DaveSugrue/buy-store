package ie.sogeti.buy.service.basket;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import ie.sogeti.buy.domain.Item;

@Service("discountService")
public class DiscountServiceImpl implements DiscountService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	/**
	 * 1 Free SIM card per phone
	 */
	@Override
	public int freeSimCard(int total, ArrayList<Item> basket) {

		int phoneCount = 0;
		int simCount = 0;
		int simPrice = 0;

		for (Item item : basket) {
			if (item.getType().equals("phone")) {
				phoneCount += item.getQuantity();
			} else if (item.getType().equals("sim")) {
				simCount += item.getQuantity();
				simPrice = item.getPrice();
			}
		}

		for (int i = 0; i < phoneCount; i++) {
			if (simCount > 0) {
				total -= simPrice;
				simCount--;
			}
		}

		System.out.println("total returned = " + total);
		return total;
	}

	@Override
	public int extraSimCard(int total, ArrayList<Item> basket) {
		// TODO Auto-generated method stub
		return 0;
	}

}

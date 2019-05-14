package ie.sogeti.buy.service.basket;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import ie.sogeti.buy.domain.Item;

@RunWith(SpringRunner.class)
public class DiscountServiceImplTest {

	@InjectMocks
	private DiscountServiceImpl	discountService;

	private ArrayList<Item>		basket1;
	private ArrayList<Item>		basket2;
	private ArrayList<Item>		basket3;

	@Before
	public void setUp() throws Exception {

		basket1 = new ArrayList<Item>();

		basket1.add(new Item(0, 5, "", 100, "phone"));
		basket1.add(new Item(1, 2, "", 400, "tv"));
		basket1.add(new Item(2, 1, "", 30, "sim"));
		System.out.println("IN SETUP :: Basket = " + basket1.toString());

		basket2 = new ArrayList<Item>();

		basket2.add(new Item(0, 5, "", 100, "phone"));
		basket2.add(new Item(1, 2, "", 400, "tv"));
		basket2.add(new Item(2, 4, "", 30, "sim"));
		basket2.add(new Item(6, 3, "", 200, "phone"));

		basket3 = new ArrayList<Item>();

		basket3.add(new Item(0, 5, "", 100, "phone"));
		basket3.add(new Item(1, 2, "", 400, "tv"));
		basket3.add(new Item(2, 7, "", 30, "sim"));
		basket3.add(new Item(6, 3, "", 200, "case"));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFreeSimCard() {

		System.out.println("Basket = " + basket1.toString());
		assertTrue(discountService.freeSimCard(1330, basket1) == 1300);
		assertTrue(discountService.freeSimCard(2020, basket2) == 1900);
		assertTrue(discountService.freeSimCard(2110, basket3) == 1960);
	}

}

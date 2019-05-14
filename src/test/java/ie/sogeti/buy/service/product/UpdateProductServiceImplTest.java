package ie.sogeti.buy.service.product;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import ie.sogeti.buy.domain.Product;
import ie.sogeti.buy.repo.ProductRepo;

@RunWith(SpringRunner.class)
public class UpdateProductServiceImplTest {

	@Mock
	ProductRepo					productRepo;

	@InjectMocks
	UpdateProductServiceImpl	updateProductService;

	Product						prod1;
	Product						prod2;

	@Before
	public void setUp() throws Exception {
		prod1 = new Product(1, "Pear myPhoneX", 900, "phone");
		prod2 = new Product(2, "Pear myPhone7", 400, "phone");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testValidateProductDetails() {
		assertTrue("Product IDs the same", updateProductService.validateProductDetails(1, prod1));
		assertFalse("Different Product Ids", updateProductService.validateProductDetails(2, prod1));
	}

	@Test
	public final void testUpdateProductValidAndSuccesful() {
		when(productRepo.updateProduct(1, prod1)).thenReturn(true);
		assertTrue(updateProductService.updateProduct(1, prod1));
	}

	@Test
	public final void testUpdateProductValidAndUnsuccesful() {
		when(productRepo.updateProduct(2, prod2)).thenReturn(false);
		assertFalse(updateProductService.updateProduct(2, prod2));
	}

	@Test
	public final void testUpdateProductInvalid() {
		assertFalse(updateProductService.updateProduct(1, prod2));
	}

}

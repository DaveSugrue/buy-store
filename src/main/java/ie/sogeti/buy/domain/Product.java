package ie.sogeti.buy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public @Data class Product {

	private int		id;
	private String	name;
	private int		price;
	private String	type;

}

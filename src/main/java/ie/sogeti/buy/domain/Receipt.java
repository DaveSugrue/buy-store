package ie.sogeti.buy.domain;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public @Data class Receipt {

	ArrayList<Item>	basket;
	int				total;
}

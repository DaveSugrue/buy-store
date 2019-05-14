package ie.sogeti.buy.domain;

public class ItemOld {

	private int	id;
	private int	quantity;

	public ItemOld() {

	}

	public ItemOld(int id, int quantity) {
		super();
		this.id = id;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "BasketItem [id=" + id + ", quantity=" + quantity + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + quantity;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		ItemOld other = (ItemOld) obj;
		if (id != other.id) {
			return false;
		}
		if (quantity != other.quantity) {
			return false;
		}
		return true;
	}

}

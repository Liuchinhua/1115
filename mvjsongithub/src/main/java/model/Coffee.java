package model;

public class Coffee implements java.io.Serializable {
	private String cofName;
	private Supplier suppliers;
	private double price;
	private int sales;
	private int total;
	public Coffee() {
	}
	public Coffee(String cofName, Supplier suppliers, double price, int sales, int total) {
		this.cofName = cofName;
		this.suppliers = suppliers;
		this.price = price;
		this.sales = sales;
		this.total = total;
	}
	public String getCofName() {
		return this.cofName;
	}
	public void setCofName(String cofName) {
		this.cofName = cofName;
	}
	public Supplier getSuppliers() {
		return this.suppliers;
	}

	public void setSuppliers(Supplier suppliers) {
		this.suppliers = suppliers;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getSales() {
		return this.sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}

	public int getTotal() {
		return this.total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

}
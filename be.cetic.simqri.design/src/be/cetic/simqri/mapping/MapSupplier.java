package be.cetic.simqri.mapping;

public class MapSupplier{
	
	private String name;
	private Object supplierDelay;
	private double deliveredPercentage;
	
	public MapSupplier(String name, Object supplierDelay, double deliveredPercentage) {
		super();
		this.name = name;
		this.supplierDelay = supplierDelay;
		this.deliveredPercentage = deliveredPercentage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object getSupplierDelay() {
		return supplierDelay;
	}

	public void setSupplierDelay(Object supplierDelay) {
		this.supplierDelay = supplierDelay;
	}

	public double getDeliveredPercentage() {
		return deliveredPercentage;
	}

	public void setDeliveredPercentage(double deliveredPercentage) {
		this.deliveredPercentage = deliveredPercentage;
	}
	
}

// -----------------------------------------------------
// Assignment 2
// Geoffrey Jeu
// Written by: Geoffrey Jeu 2210758
// -----------------------------------------------------

// This is the definition of class Computer, with its attributes, constructors, setters and getters,
// methods: toString(), findNumberOfCreatedComputers(), equals().

public class Computer 
{	
	private String brand; 
	private String model; 
	private long SN;
	private double price;
	private static int counter = 0;
	
	public Computer() 
	{
		brand = "Dell";
		model = "Alienware M15 R6";
		SN = 100100100;
		price = 1590;
		counter++;
	}
	
	public Computer(String br, String mod, long sn, double pr) 
	{
		brand = br;
		model = mod;
		SN = sn;
		price = pr;
		counter++;
	}
	
	public Computer(Computer c) 
	{ 
		this.brand = c.brand;
		this.model = c.model; 
		this.SN = c.SN;
		this.price = c.price;
		counter++;
	}

	public String getBrand() 
	{
		return brand;
	}

	public void setBrand(String brand) 
	{
		this.brand = brand;
	}

	public String getModel() 
	{
		return model;
	}

	public void setModel(String model) 
	{
		this.model = model;
	}

	public long getSN() 
	{
		return SN;
	}

	public void setSN(long sN) 
	{
		this.SN = sN;
	}

	public double getPrice() 
	{
		return price;
	}

	public void setPrice(double price) 
	{
		if(price<1) 
		{
			System.out.println("Error! Price should be greater than 0.");
		} 
		else 
		{
			this.price = price;
		}		
	}

	public String toString() 
	{
		return "Brand of computer: " + brand + "\nModel: " + model + "\nSerial number: " + SN 
				+ "\nPrice: $" + price;
	}
		
	public static void findNumberOfCreatedComputers() 
	{
		System.out.println("This computer class has " + counter + " objects.");
	}

//	@Override
//	public boolean equals(Object obj) {
//		if (obj == null || this == null || !(obj instanceof Computer)) {
//			return false;
//		} else {
//			Computer c = (Computer)obj;
//			return this.brand == c.brand && this.model == c.model && this.price == c.price;
//		}
//	}					

}

package testNG.Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
	@Test(dataProvider = "Phones")
	public void addProductToCartTest(String name,String model,int price,int qty)
	{
	System.out.println("Phonename: "+name+" model: "+model+" price: "+price+" qty: "+qty);
	}
	
	@DataProvider(name="Phones")
	public Object[][]getData()
	{
		Object[][] obj=new Object[3][4];
		
		obj[0][0]="Samsung";
		obj[0][1]="A18";
		obj[0][2]=25000;
		obj[0][3]=10;
		
		obj[1][0]="Iphone";
		obj[1][1]="11pro";
		obj[1][2]=5000;
		obj[1][3]=5;
		
		obj[2][0]="Vivo";
		obj[2][1]="s20";
		obj[2][2]=10000;
		obj[2][3]=10;
		return obj;
		
		
	}
	
	

}

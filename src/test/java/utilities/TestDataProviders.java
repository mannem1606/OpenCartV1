package utilities;
import java.io.IOException;

import org.testng.annotations.DataProvider;

public class TestDataProviders 
{
	//DataProvider1
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path=".\\testData\\OpencartData.xlsx"; //taking xl file from testdata
		ExcelUtility xlutil=new ExcelUtility(path); //crating an object for XLUtility
		int totalrows=xlutil.getRowCount("Sheet1");
		int totalcols=xlutil.getCellCount("Sheet1",1);
		
		String logindata[][]=new String[totalrows][totalcols]; // created 2 deminsion array which we can store
		for(int i=1;i<totalrows;i++) //read the data from xl storing in deminsional array
		{
			for(int j=0;j<totalcols;j++) // 0  i is row , j is col
			{
				logindata[i-1][j]=xlutil.getCellData("Sheet1",i,j);
				
			}
		}
		return logindata;// Return two dimension array
		
		
	}

}
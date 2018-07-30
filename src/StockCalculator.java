import java.util.Iterator;
import java.util.List;

public class StockCalculator {
	
	public static Double calculate(List<Leg> transactions, Double currentPrice) {
		Double toReturn = 0.0;
		
		for (Leg transaction : transactions) {
			toReturn = toReturn + (currentPrice - 0.0);//transaction.getStockPrice()
		}
		
		return toReturn;
	}
}

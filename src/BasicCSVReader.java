import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class BasicCSVReader {
	private static final String SAMPLE_CSV_FILE_PATH = "./transactions_real_short.csv";

	public static void main(String[] args) throws IOException {
		try (Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
				CSVParser csvRecords = new CSVParser(reader,
						CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

			ArrayList<Leg> stocks = new ArrayList<>();

			Order currentOrder = null;
			
			for (CSVRecord csvRecord : csvRecords) {

//				private String time;
//				private String spread;
//				private String side;
//				private int quantity;
//				private String posEffect;
//				private String symbol;
//				private String expiration;
//				private String strike;
//				private String type;
//				private Double price;
//				private String status;
//				private String fillType;

//				Notes,Time Placed,Spread,Side,Qty,Pos Effect,Symbol,Exp,Strike,Type,PRICE,Fill Type,TIF,Status
				// Accessing Values by Column Index

				
				String time = csvRecord.get("Time Placed");
				if (!time.equals("")) {
					
					if(currentOrder != null) {
						System.out.println(currentOrder + "\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");
					}
					
					currentOrder = new Order();
					currentOrder.setTime(time);
					currentOrder.setSpread(csvRecord.get("Spread"));
					currentOrder.setStatus(csvRecord.get("Status"));
					currentOrder.setFillType(csvRecord.get("Fill Type"));
					currentOrder.setSymbol(csvRecord.get("Symbol"));


//				Side,Qty,Pos Effect,Symbol,Exp,Strike,Type,PRICE
//					Leg leg = new Leg();
//
//					leg.setSide(csvRecord.get("Side"));
//					leg.setQuantity(Integer.parseInt(csvRecord.get("Qty")));
//					leg.setPosEffect(csvRecord.get("Pos Effect"));
//					leg.setSymbol(csvRecord.get("Symbol"));
//					leg.setExpiration(csvRecord.get("Exp"));
//					leg.setStrike(csvRecord.get("Strike"));
//					leg.setType(csvRecord.get("Type"));
//
//					String price = csvRecord.get("PRICE");
//					if (price.equals("<empty>")) {
//						price = "0";
//					}
//					leg.setPrice(Double.parseDouble(price));
//					currentOrder.setLeg1(leg);

//					System.out.println("Record No - " + csvRecord.getRecordNumber());
//					System.out.println("---------------");
//					System.out.println(currentOrder);
//					System.out.println("---------------\n");
//
//					stocks.add(leg);
				}
				
				Leg leg = new Leg();

				leg.setSide(csvRecord.get("Side"));
				leg.setQuantity(Integer.parseInt(csvRecord.get("Qty")));
				leg.setPosEffect(csvRecord.get("Pos Effect"));
				leg.setSymbol(csvRecord.get("Symbol"));
				leg.setExpiration(csvRecord.get("Exp"));
				leg.setStrike(csvRecord.get("Strike"));
				leg.setType(csvRecord.get("Type"));

				String price = csvRecord.get("PRICE");
				if (price.equals("<empty>")) {
					price = "0";
				}
				leg.setPrice(Double.parseDouble(price));
				
				try {
					currentOrder.addLeg(leg);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(currentOrder != null) {
				System.out.println(currentOrder + "\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");
			}

//			Double sum = StockCalculator.calculate(stocks, 300.0);

//			System.out.println("Sum:" + sum);
		}
	}
}
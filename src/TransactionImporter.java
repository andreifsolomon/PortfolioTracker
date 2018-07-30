import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class TransactionImporter {
	
	private static final String SAMPLE_CSV_FILE_PATH = "./transactions_real_short.csv";
	
	public static List<Leg> importTransactionsFromCSV() throws IOException{
		try (Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
				CSVParser csvRecords = new CSVParser(reader, CSVFormat.DEFAULT
						.withFirstRecordAsHeader()
	                    .withIgnoreHeaderCase()
	                    .withTrim());) {
			
			ArrayList<Leg> stocks = new ArrayList<>();
			
			for (CSVRecord csvRecord : csvRecords) {
				// Accessing Values by Column Index
				int quantity = Integer.parseInt(csvRecord.get("quantity"));
				String symbol = csvRecord.get("stockName");
				Double price = Double.parseDouble(csvRecord.get("stockPrice"));
				Leg t = new Leg();
				t.setSymbol(symbol);
				t.setPrice(price);

				System.out.println("Record No - " + csvRecord.getRecordNumber());
				System.out.println("---------------");
				System.out.println("quantity : " + quantity);
				System.out.println("stockName : " + symbol);
				System.out.println("stockPrice : " + price);
				System.out.println("---------------\n\n");
				
				stocks.add(t);
			}
			
			return stocks;
		}
	}
}

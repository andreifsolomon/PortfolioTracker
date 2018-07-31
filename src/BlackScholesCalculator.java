import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.Date;

public class BlackScholesCalculator {

	public static double timeToExpiration(String expiration) {
		double toReturn = 0.0;
		
		String pattern = "dd MMM yy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		Date expirationDate = null;
		
		try {
			 expirationDate = simpleDateFormat.parse(expiration);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		if(expirationDate != null) {
			Date now = new Date();
			long difference = now.getTime() - expirationDate.getTime(); //(diff / (1000 * 60 * 60 * 24)) 
			double differenceInDays = difference / (1000 * 60 * 60 * 24);
			
			Year currentYear = Year.now();
			int yearLenght = currentYear.length();
			
			toReturn = differenceInDays / yearLenght;
		}
		
		return toReturn;
	}
	
	public static void main(String[] args) {
		timeToExpiration("17 MAR 18");
	}
}

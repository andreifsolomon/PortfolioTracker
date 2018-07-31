import java.util.ArrayList;
import java.util.List;

public class Order {
	
	private List<Leg> legs;
	private String time;
	private String spread;
	private String symbol;
	private String expiration;
	private String strike;
	private Double price;
	private String status;
	private String fillType;

	private Leg leg1;
	private Leg leg2;
	private Leg leg3;
	private Leg leg4;

	
	public Order() {
		legs = new ArrayList<>();
	}

	public Order(String time, String spread, String symbol, String expiration, String strike, Double price,
			String status, String fillType, Leg leg1, Leg leg2, Leg leg3, Leg leg4) {
		super();
		
		legs = new ArrayList<>();
		
		this.time = time;
		this.spread = spread;
		this.symbol = symbol;
		this.expiration = expiration;
		this.strike = strike;
		this.price = price;
		this.status = status;
		this.fillType = fillType;
		this.leg1 = leg1;
		this.leg2 = leg2;
		this.leg3 = leg3;
		this.leg4 = leg4;
		legs.add(leg1);
		legs.add(leg2);
		legs.add(leg3);
		legs.add(leg4);
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getSpread() {
		return spread;
	}

	public void setSpread(String spread) {
		this.spread = spread;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getExpiration() {
		return expiration;
	}

	public void setExpiration(String expiration) {
		this.expiration = expiration;
	}

	public String getStrike() {
		return strike;
	}

	public void setStrike(String strike) {
		this.strike = strike;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFillType() {
		return fillType;
	}

	public void setFillType(String fillType) {
		this.fillType = fillType;
	}

	public Leg getLeg1() {
		return leg1;
	}

	public void setLeg1(Leg leg1) {
		if(legs.contains(this.leg1)) {
			legs.remove(this.leg1);
		}
		this.leg1 = leg1;
		legs.add(this.leg1);
	}

	public Leg getLeg2() {
		return leg2;
	}

	public void setLeg2(Leg leg2) {
		if(legs.contains(this.leg2)) {
			legs.remove(this.leg2);
		}
		this.leg2 = leg2;
		legs.add(this.leg2);
	}

	public Leg getLeg3() {
		return leg3;
	}

	public void setLeg3(Leg leg3) {
		if(legs.contains(this.leg3)) {
			legs.remove(this.leg3);
		}
		this.leg3 = leg3;
		legs.add(this.leg3);
	}

	public Leg getLeg4() {
		return leg4;
	}

	public void setLeg4(Leg leg4) {
		if(legs.contains(this.leg4)) {
			legs.remove(this.leg4);
		}
		this.leg4 = leg4;
		legs.add(this.leg4);
	}

	public void addLeg(Leg leg) throws Exception {
		if (leg1 == null) {
			setLeg1(leg);
		} else if (leg2 == null) {
			setLeg2(leg);
		} else if (leg3 == null) {
			setLeg3(leg);
		} else if (leg4 == null) {
			setLeg4(leg);
		} else {
			throw new Exception("Too Many Legs!");
		}
	}
	
	public Double getMatketValueAt() {
		return 0.0;
	}
	
	public String toString() {
//		Notes,Time Placed,Spread,Side,Qty,Pos Effect,Symbol,Exp,Strike,Type,PRICE,Fill Type,TIF,Status
		String legs = "";
		for (Leg leg : this.legs) {
			legs = legs + leg.toString() + "\n";
		}
		
		return "time: " + time + " symbol: " + symbol + " spread: " + spread + 
				"\n" + legs + " " +
				" expiration: " + expiration + 
				" strike: " + strike + " price: " + price + " fillType: " + fillType + " status: " + status;
		
	}

}

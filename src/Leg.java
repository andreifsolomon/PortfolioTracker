public class Leg {
	
	private String time;
	private String spread;
	private String side;
	private int quantity;
	private String posEffect;
	private String symbol;
	private String expiration;
	private String strike;
	private String type;
	private Double price;
	private String status;
	private String fillType;
	private char sign;
	
	public Leg() {
	}

	public Leg(String time, String spread, String side, int quantity, String posEffect, String symbol,
			String expiration, String strike, String type, Double price, String status, String fillType, char sign) {
		super();
		this.time = time;
		this.spread = spread;
		this.side = side;
		this.quantity = quantity;
		this.posEffect = posEffect;
		this.symbol = symbol;
		this.expiration = expiration;
		this.strike = strike;
		this.type = type;
		this.price = price;
		this.status = status;
		this.fillType = fillType;
		this.sign = sign;
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

	public String getSide() {
		return side;
	}

	public void setSide(String side) {
		this.side = side;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getPosEffect() {
		return posEffect;
	}

	public void setPosEffect(String posEffect) {
		this.posEffect = posEffect;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public char getSign() {
		return sign;
	}

	public void setSign(char sign) {
		this.sign = sign;
	}

	public String toString() {
//		Notes,Time Placed,Spread,Side,Qty,Pos Effect,Symbol,Exp,Strike,Type,PRICE,Fill Type,TIF,Status
//		Side,Qty,Pos Effect,Symbol,Exp,Strike,Type,PRICE
		
//		return "time: " + time + " symbol: " + symbol + " spread: " + spread + " side: " + side + " quantity: " + quantity + " posEffect: " + 
//		posEffect + " expiration: " + expiration + " strike: " + strike + " type: " +
//		type + " price: " + price + " fillType: " + fillType + " status: " + status;
		
		return " side: " + side + " quantity: " + quantity + " posEffect: " + 
			posEffect + " expiration: " + expiration + " strike: " + strike + " type: " +
			type + " price: " + price;
	}
}
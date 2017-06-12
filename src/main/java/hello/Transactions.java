package hello;

public class Transactions {
	
	String fromName,toName;
	String amount;
	
	public Transactions(){
		
	}
	public String getFrom_name() {
		return fromName;
	}
	public void setFrom_name(String from_name) {
		this.fromName = from_name;
	}
	public String getTo_name() {
		return toName;
	}
	public void setTo_name(String to_name) {
		this.toName = to_name;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public Transactions(String from_name, String to_name, String amount){
		this.fromName=from_name;
		this.toName=to_name;
		this.amount=amount;
	}
	

}

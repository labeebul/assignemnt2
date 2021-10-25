package mavi1;


@SuppressWarnings("serial")
public class PaymentFail extends RuntimeException{
	public PaymentFail(String msg) {
		super(msg);
	}
}

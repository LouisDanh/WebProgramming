package models;

public class CashPayment implements PaymentMethodStrategy {
	private PaymentMethod method;
	
	@Override
	public String getName() {
		return null;
	}

	@Override
	public double pay() {
		return 0;
	}

}

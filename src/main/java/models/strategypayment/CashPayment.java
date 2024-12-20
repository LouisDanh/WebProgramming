package models.strategypayment;

public class CashPayment implements PaymentMethodStrategy {

	@Override
	public double pay() {
		return 0;
	}

}

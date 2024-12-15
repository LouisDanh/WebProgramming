package models;

public interface PaymentMethodStrategy {
	String getName();

	double pay();
}

package models.strategypayment;

import java.lang.reflect.InvocationTargetException;

import models.PaymentMethod;

public class PaymentMethodFactory {
	public PaymentMethodStrategy createMethod(PaymentMethod type) {
		PaymentMethodStrategy payment = null;
		try {
			payment = (PaymentMethodStrategy) Class.forName(type.getStrategyClass())
					.getDeclaredConstructor(PaymentMethodStrategy.class).newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return payment;
	}
}

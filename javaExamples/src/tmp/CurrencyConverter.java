package tmp;

import net.webservicex.Currency;
import net.webservicex.CurrencyConvertor;
import net.webservicex.CurrencyConvertorSoap;

public class CurrencyConverter {

	public static void main(String[] args) {
		CurrencyConvertor currencyConvertorService = new CurrencyConvertor();
		CurrencyConvertorSoap convertorSoap = currencyConvertorService.getCurrencyConvertorSoap();
		System.out.println(convertorSoap.conversionRate(Currency.INR, Currency.GBP));
	}
}

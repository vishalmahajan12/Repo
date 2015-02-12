package net.webservicex;


public class CurrencyConverterMain {

	public static void main(String[] args) {
		CurrencyConvertor currencyConvertorService = new CurrencyConvertor();
		CurrencyConvertorSoap convertorSoap = currencyConvertorService.getCurrencyConvertorSoap();
		System.out.println(convertorSoap.conversionRate(Currency.INR, Currency.GBP));
	}
}

package TestTask.TestTask1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class GetQueryParameters {
	/*
	 * "http://www.lb.lt/webservices/fxrates/FxRates.asmx/getFxRatesForCurrency?tp=EU&ccy=USD&dtFrom=2018-05-01&dtTo=2018-05-10"
	 */

	String tp = "EU";
	String ccy;
	String dtFrom;
	String dtTo;

	public String getParameters() {

		StringBuilder sb = new StringBuilder();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter currency code (three letters):");
		String ccy = scanner.nextLine().toUpperCase();
		System.out.println("Enter start date (YYYY-MM-DD)");
		String dtFrom = scanner.nextLine();
		System.out.println("Enter end date:");
		String dtTo = scanner.nextLine();

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date dateFrom = null;
		Date dateTo = null;
		try {
			dateFrom = formatter.parse(dtFrom);
			dateTo = formatter.parse(dtTo);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		if (dateFrom.after(dateTo)) {
			String temp = dtFrom;
			dtFrom = dtTo;
			dtTo = temp;
		}

		sb.append("http://www.lb.lt/webservices/fxrates/FxRates.asmx/getFxRatesForCurrency?tp=");
		sb.append(tp + "&ccy=" + ccy + "&dtFrom=" + dtFrom + "&dtTo=" + dtTo);

		return sb.toString();
	}
}

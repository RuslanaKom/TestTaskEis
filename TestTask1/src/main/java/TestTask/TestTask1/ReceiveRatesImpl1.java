package TestTask.TestTask1;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import TestTask.TestTask1.Models.CcyAmt;
import TestTask.TestTask1.Models.Rate;

public class ReceiveRatesImpl1 implements ReceiveRates {

	// String address =
	// "http://www.lb.lt/webservices/fxrates/FxRates.asmx/getFxRatesForCurrency?tp=EU&ccy=USD&dtFrom=2018-05-01&dtTo=2018-05-10";

	public List getRatesFromURL(String address) throws MalformedURLException, JDOMException, IOException {

		SAXBuilder saxBuilder = new SAXBuilder();
		Document document = saxBuilder.build(new URL(address).openStream());

		// System.out.println("Root element :" + document.getRootElement().getName());
		Element classElement = document.getRootElement();

		List<Element> fxRateList = classElement.getChildren();
		List<Rate> rateList = new ArrayList<Rate>();
		;

		for (int i = 0; i < fxRateList.size(); i++) {
			Rate myRate = new Rate();
			Element rate = fxRateList.get(i);
			List<Element> fxInnerElements = rate.getChildren();
			List<CcyAmt> myCcyAmtList = new ArrayList();
			for (int j = 0; j < fxInnerElements.size(); j++) {
				Element fxInner = fxInnerElements.get(j);
				if (j == 0) {
					myRate.setTp(fxInner.getText());
				}
				if (j == 1) {
					myRate.setDt(fxInner.getText());
				}
				if (j == 2 || j == 3) {
					List<Element> ccyAmtList = fxInner.getChildren();

					CcyAmt myCcyAmt = new CcyAmt();
					for (int k = 0; k < ccyAmtList.size(); k++) {
						Element ccyAmt = ccyAmtList.get(k);
						if (k == 0) {
							myCcyAmt.setCcy(ccyAmt.getText());
						}
						if (k == 1) {
							myCcyAmt.setAmt(ccyAmt.getText());
						}
					}
					myCcyAmtList.add(myCcyAmt);
				}
			}
			myRate.setCcyAmts(myCcyAmtList);
			rateList.add(myRate);
		}
		return rateList;
	}
}

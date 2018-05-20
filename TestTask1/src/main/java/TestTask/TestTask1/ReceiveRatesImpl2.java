package TestTask.TestTask1;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.JDOMException;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import TestTask.TestTask1.Models.CcyAmt;
import TestTask.TestTask1.Models.Rate;

public class ReceiveRatesImpl2 implements ReceiveRates {
	//String address = "http://www.lb.lt/webservices/fxrates/FxRates.asmx/getFxRatesForCurrency?tp=EU&ccy=USD&dtFrom=2018-05-01&dtTo=2018-05-10";

	public List getRatesFromURL(String address) throws MalformedURLException, JDOMException, IOException, ClassNotFoundException {
		XStream xstream = new XStream(new DomDriver());

		XStream.setupDefaultSecurity(xstream);
		Class<?>[] classes = new Class[] { Rate.class, CcyAmt.class };
		xstream.allowTypes(classes);
		ObjectInputStream objectInputStream = xstream.createObjectInputStream(new URL(address).openStream());

		xstream.processAnnotations(Rate.class);
		xstream.processAnnotations(CcyAmt.class);

		List<Rate> rateList = new ArrayList();
		while (true) {
			try {
				rateList.add((Rate) objectInputStream.readObject());
			} catch (EOFException e) {
				return rateList;
			}
		}
	}
}

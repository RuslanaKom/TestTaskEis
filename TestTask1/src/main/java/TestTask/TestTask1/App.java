package TestTask.TestTask1;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.jdom2.JDOMException;
import org.xml.sax.SAXException;

import com.thoughtworks.xstream.mapper.CannotResolveClassException;

import TestTask.TestTask1.Models.Rate;

public class App {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws MalformedURLException, SAXException, IOException,
			ParserConfigurationException, JDOMException, ClassNotFoundException

	{
		while (true) {
			try {
				GetQueryParameters getparams = new GetQueryParameters();
				ReceiveRates receiveRates = new ReceiveRatesImpl2();
				DisplayResults results = new DisplayResults();

				List<Rate> rateList = receiveRates.getRatesFromURL(getparams.getParameters());
				results.showRates(rateList);
			} catch (CannotResolveClassException e) {
				System.out.println("Oops, something wrong with your parameters, check input data");
			}
		}
	}
}

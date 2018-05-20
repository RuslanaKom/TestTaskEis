package TestTask.TestTask1;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.jdom2.JDOMException;

public interface ReceiveRates<E> {
	
	List <E> getRatesFromURL(String address) throws MalformedURLException, JDOMException, IOException, ClassNotFoundException;

}

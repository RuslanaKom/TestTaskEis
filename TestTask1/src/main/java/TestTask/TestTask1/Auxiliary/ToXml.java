package TestTask.TestTask1.Auxiliary;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;

import TestTask.TestTask1.Models.CcyAmt;
import TestTask.TestTask1.Models.Rate;
import TestTask.TestTask1.Models.WholeList;

public class ToXml {
	public void convertToXml() {
	WholeList list=new WholeList();
	CcyAmt ccyAmt1=new CcyAmt();
	CcyAmt ccyAmt2=new CcyAmt();
	CcyAmt ccyAmt3=new CcyAmt();
	CcyAmt ccyAmt4=new CcyAmt();
	Rate rate2=new Rate();
	
	
	ccyAmt1.setAmt("1");
	ccyAmt1.setCcy("EUR");
	ccyAmt2.setAmt("1.25");
	ccyAmt2.setCcy("USD");
	
	ccyAmt3.setAmt("1");
	ccyAmt3.setCcy("EUR");
	ccyAmt4.setAmt("1.35");
	ccyAmt4.setCcy("USD");
	
	rate2.setTp("EU");
	rate2.setDt("2015-01-01");
	
	List <CcyAmt> listccy1=new ArrayList <CcyAmt>();
	listccy1.add(ccyAmt1);
	listccy1.add(ccyAmt2);
	List <CcyAmt> listccy2=new ArrayList <CcyAmt>();
	listccy2.add(ccyAmt3);
	listccy2.add(ccyAmt4);
	
	rate2.setCcyAmts(listccy1);
	
	
	Rate rate3=new Rate();
	
	rate3.setDt("2016-01-02");
	rate3.setTp("KK");
	rate3.setCcyAmts(listccy2);
	
	List <Rate> rateList=new ArrayList();
	rateList.add(rate2);
	rateList.add(rate3);
	
	list.setRateList(rateList);
	list.setXmlns("blablala");
	
	XStream xstream=new XStream();
	xstream.processAnnotations(WholeList.class);     
	xstream.processAnnotations(Rate.class);      
	xstream.processAnnotations(CcyAmt.class); 
	
	String xmlString = xstream.toXML(list);
	System.out.println(xmlString);

	 }
}

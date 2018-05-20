package TestTask.TestTask1.Models;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import lombok.Data;

@Data
@XStreamAlias("CcyAmt")
public class CcyAmt {
	
	@XStreamAlias("Ccy")
	private String Ccy;
	
	@XStreamAlias("Amt")
	private String Amt;

}

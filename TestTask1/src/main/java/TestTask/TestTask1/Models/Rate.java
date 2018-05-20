package TestTask.TestTask1.Models;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import lombok.Data;

@Data
@XStreamAlias("FxRate")
public class Rate {
	
	@XStreamAlias("Tp")
	private String Tp;
	
	@XStreamAlias("Dt")
	private String Dt;
	
	@XStreamImplicit
	private List<CcyAmt> ccyAmts=new ArrayList();


}

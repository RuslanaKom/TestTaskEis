package TestTask.TestTask1.Models;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import lombok.Data;

@XStreamAlias("FxRates")
@Data
public class WholeList {
	
	 @XStreamAsAttribute
	 @XStreamAlias("xmlns")
	 String xmlns;
	
	@XStreamImplicit(itemFieldName = "FxRate")
    private List <Rate> rateList = new ArrayList();
	

}

package TestTask.TestTask1;

import java.util.List;

import TestTask.TestTask1.Models.Rate;

public class DisplayResults<E> {

	List<Rate> rateList;

	public void showRates(List<Rate> rateList) {

		this.rateList = (List<Rate>) rateList;

		for (Rate rate : rateList) {
			System.out.printf("Date: %s\n", rate.getDt());
			System.out.printf("Rate: %s %s = %s %s\n", rate.getCcyAmts().get(0).getAmt(),
					rate.getCcyAmts().get(0).getCcy(), rate.getCcyAmts().get(1).getAmt(),
					rate.getCcyAmts().get(1).getCcy());
		}

		double endRate = Double.parseDouble(rateList.get(0).getCcyAmts().get(1).getAmt());
		double startRate = Double.parseDouble(rateList.get(rateList.size() - 1).getCcyAmts().get(1).getAmt());
		double rateChange = endRate - startRate;
		System.out.println("____________________________________");
		System.out.printf("%s rate change for this period is %f\n", rateList.get(0).getCcyAmts().get(1).getCcy(),
				rateChange);
		System.out.println("____________________________________");
	}
}

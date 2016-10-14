public class Insurance
{
	private int insCode;
	private int duration;
	private int startYear;
	private int startMonth;
	private int startDay;
	private int totalCost;
	private int costPerYear;
	private static int counter=1;
	private int custCode;
	public static Insurance[] ins = new Insurance[21];

	public Insurance(int duration1,int startYear1,int startMonth1,int startDay1,int code1)
	{
		insCode = counter;
		duration = duration1;
		startYear = startYear1;
		startMonth = startMonth1;
		startDay = startDay1;
		custCode = code1;
		costPerYear = 6*(2016-Customer.getCust(custCode).getBYear());
		totalCost = costPerYear + 30;
		ins[counter] = this;
		counter = counter + 1;
		int expMonth;
		int expYear;
		if (startMonth == 12)
		{
			expMonth = 1;
			expYear = startYear + 1;
		}
		else
		{
			expMonth = startMonth + 1;
			expYear = startYear;
		}
		Payment pay = new Payment(totalCost,custCode,insCode,expYear,expMonth,startDay);
	}


	public void setInsCode(int b)
	{
		insCode = b;
	}
	public void setDuration(int b)
	{
		duration = b;
	}
	public void setStartYear(int b)
	{
		startYear = b;
	}
	public void setStartMonth(int b)
	{
		startMonth = b;
	}
	public void setStartDay(int b)
	{
		startDay = b;
	}
	public void setTotalCost(int b)
	{
		totalCost = b;
	}
	public int getInsCode()
	{
		return insCode;
	}
	public int getDuration()
	{
		return duration;
	}
	public int getStartYear()
	{
		return startYear;
	}
	public int getStartMonth()
	{
  		return startMonth;
	}
	public int getStartDay()
	{
  		return startDay;
	}
	public int getCustCode()
	{
		return custCode;
	}

	public static Insurance getIns(int index)
	{
		return ins[index];
	}

	public String getPayStatus()
	{
		int a=0;
		for (int i=1 ; i<counter ; i++)
		{
			if ( insCode == Payment.getPay(i).getPayInsCode() )
				a = i;
		}
		return Payment.getPay(a).getStatus();
	}

	public Payment getPayment()
	{
		int a=0;
		for (int i=1 ; i<counter ; i++)
		{
			if ( insCode == Payment.getPay(i).getPayInsCode() )
				a = i;
		}
		return Payment.getPay(a);
	}


	public String toString()
	{
        return "Insurance Details\n\nInsurance Code:\t\t" + insCode + "\nInsurance duration:\t" + duration + "  (days)\nDate of effect:\t\t" + startDay + "/" + startMonth + "/" + startYear + "\nCustomer's Code:\t" + custCode + "\nTotal Cost:\t\t" + totalCost + " Euros\nPayment Status:\t\t" + getPayStatus() + "\n";
	}

	public static void insDetails(int code2)
	{
		for(int i=1;i<counter;i++)
		{
			if(code2 == ins[i].getCustCode())
			{
				System.out.printf("--------------------------------------------------------------\n%s--------------------------------------------------------------\n",ins[i].toString());
			}
		}
	}

	public static boolean existCust(int code2)
	{
		boolean f=false;
		for(int i=1;i<counter;i++)
		{
			if(code2 == ins[i].getCustCode())
				{
					f = true;
				}
		}
		return f;
	}

	public static void printIns()
	{
		for (int i=1 ; i<counter ; i++)
		{
			System.out.printf("--------------------------------------------------------------\n%s--------------------------------------------------------------\n",ins[i].toString());
		}
	}
}
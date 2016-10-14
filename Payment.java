public class Payment
{
	private int payCode;
	private int ammount;
	private int payCustCode;
	private int payInsCode;
	private String status;
	private int pYear;
	private int pMonth;
	private int pDay;
	private int eYear;
	private int eMonth;
	private int eDay;
	private static int n=1;
	private static Payment[] pay = new Payment[21];

	public Payment(int ammount1,int cust,int ins,int year,int month,int day)
	{
		payCode = n;
		ammount = ammount1;
		payCustCode = cust;
		payInsCode = ins;
		status = "PENDING";
		pYear = year;
		pMonth = month + 1;
		pDay = day;
		eMonth = 0;
		eYear = 0;
		eDay = 0;
		pay[n] = this;
		n = n + 1;
	}

	public void setPayCode(int a)
	{
		payCode = a;
	}

	public void setAmmount(int a)
	{
		ammount = a;
	}

	public void setPayCustCode(int a)
	{
		payCustCode = a;
	}

	public void setPayInsCode(int a)
	{
		payInsCode = a;
	}

	public void setPYear(int a)
	{
		pYear = a;
	}

	public void setPMonth(int a)
	{
		pMonth = a;
	}

	public void setPDay(int a)
	{
		pDay = a;
	}

	public void setEYear(int a)
	{
		eYear = a;
	}

	public void setEMonth(int a)
	{
		eMonth = a;
	}

	public void setEDay(int a)
	{
		eDay = a;
	}

	public void setStatus(String a)
	{
		status = a;
	}

	public int getPayCode()
	{
		return payCode;
	}

	public int getPayCustCode()
	{
		return payCustCode;
	}

	public int getPayInsCode()
	{
		return payInsCode;
	}

	public int getAmmount()
	{
		return ammount;
	}

	public int getPYear()
	{
		return pYear;
	}

	public int getPMonth()
	{
		return pMonth;
	}

	public int getPDay()
	{
		return pDay;
	}

	public int getEYear()
	{
		return eYear;
	}

	public int getEMonth()
	{
		return eMonth;
	}

	public int getEDay()
	{
		return eDay;
	}

	public String getStatus()
	{
		return status;
	}

	public static int getPayCount()
	{
		return n;
	}

	public static Payment getPay(int index)
	{
		return pay[index];
	}

	public void payIns(int day, int month, int year)
	{
		eDay = day;
		eMonth = month;
		eYear = year;
		status = "PAID";
	}

    public String toString()
    {
		return   "Payment Code: " + payCode + "\nAmmount: " + ammount + "\nCustomer's Code: " + payCustCode + "\nInsurance Code: " + payInsCode + "\nPayment Status: " + status + "\nExpirancy Date :" + pDay + "/" + pMonth + "/" + pYear + "\nPaid on: " + eDay + "/" + eMonth + "/" + eYear + "/n";
	}
}












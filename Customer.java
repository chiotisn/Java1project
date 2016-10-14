public class Customer
{
	private int code;
	private String phone;
	private int bYear;
	private int bMonth;
	private int bDay;
	private String name;
	private String solvency="0";
	private String email;
	private static int n=1;
	private static Customer[] cust = new Customer[21];

	public Customer(String name1, String phone1, String email1, int year, int month, int day)
	{
		code = n;
		name = name1;
		phone = phone1;
		email = email1;
		bYear = year;
		bMonth = month;
		bDay = day;
		cust[n] = this;
		n = n + 1;
	}


	public void setCode(int a)
	{
		code = a;
	}
	public void setName(String a)
	{
		name = a;
	}
	public void setPhone(String a)
	{
		phone = a;
	}
	public void setEmail(String a)
	{
		email = a;
	}
	public void setBYear(int a)
	{
		bYear = a;
	}
	public void setBMonth(int a)
	{
		bMonth = a;
	}
	public void setBDay(int a)
	{
		bDay = a;
	}
	public int getCode()
	{
		return code;
	}
	public int getBYear()
	{
		return bYear;
	}
	public int getBMonth()
	{
		return bMonth;
	}
	public int getBDay()
	{
		return bDay;
	}
	public String getPhone()
	{
		return phone;
	}
	public String getEmail()
	{
		return email;
	}
	public int getN()
	{
		return n;
	}


	//????d?? p?? ep?st??fe? ??a a?t??e?µe?? t?? ???s?? p?? e??a? ap????e?µ??? st?? p??a?a cust.
	//(? p??a?a? e??a? ft?a?µ???? ?ts? ?ste ???e a?t??e?µe?? pe??t? e??a? ap????e?µ??? st? st???e?? t?? p??a?a µe de??t? t?? ??d??? t?? pe??t?)
	public static Customer getCust(int index)
	{
		return cust[index];
	}


	//????d?? p?? ep?st??fe? t?? fe?e????t?ta e??? pe??t?(a?t??e?µe?? t?? ??as??).
	public String findSolvency()
	{
		double f1=0;
		double f2=0;
		double f3=0;
		for (int i=1 ; i<Payment.getPayCount() ; i++)
		{
			if ( Payment.getPay(i).getPayCustCode() == code)
			{
				f1 = f1 + 1;

				if ( Payment.getPay(i).getStatus() == "PAID")
				{
					f2 = f2 + 1;
					if ( (Payment.getPay(i).getPYear() >= Payment.getPay(i).getEYear()) && (Payment.getPay(i).getPMonth() >= Payment.getPay(i).getEMonth()) && (Payment.getPay(i).getPDay() >= Payment.getPay(i).getEDay()))
					{
						f3 = f3 + 1;
					}
				}
			}
		}
		if (f1 <= 1)
		{
			solvency = "new customer";
		}
		else if ( f3/f2 >= 0.7)
		{
			solvency = "\"good\" customer";
		}
		else
		{
			solvency = "\"bad\" customer";
		}
		return solvency;
	}

	//????d?? toString p?? t?p??e? µ??f?p???µ??a t?? µetaﬂ??te? st??µ??t?p?? t?? ???s??.
	public String toString()
	{
		return "Customer Details\n\nCustomer's Code:\t" + code + "\nName:\t\t\t" + name + "\nPhone:\t\t\t" + phone + "\nEmail:\t\t\t" + email + "\nDate of Birth:\t\t" + bDay + "/" + bMonth + "/" + bYear + "\nCustomer's Solvency:\t" + findSolvency() + "\n";
	}


	//????d?? p?? d??eta? ??a? ??d??? ?? ???sµa ?a? ﬂ??s?e? a? ?p???e? pe??t?? µe a?t?? t?? ??d???.
	public static boolean existance(int code1)
	{
		boolean f=false;
		for (int i=1 ; i<n ; i++)
		{
			if (code1 == cust[i].getCode())
			{
				f = true;
			}
		}
		return f;
	}


	//????d?? p?? t?p??e? ta st???e?a ???? t?? ?ata????µ???? pe?at?? (a?t??e?µe??? t?? ??as??).
	public static void printCust()
	{
		for (int i=1 ; i<n ; i++)
		{
			System.out.printf("--------------------------------------------------------------\n%s--------------------------------------------------------------\n",cust[i].toString());
		}
	}
}
package Desafios.desafio5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Desafio {

	public static int countDays(String string, String string2) {
		SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
		String inputString1 = string;
		String inputString2 = string2;
		long date = 0;
		int result = 0;

		try {
		    Date date1 = myFormat.parse(inputString1);
		    Date date2 = myFormat.parse(inputString2);
		    long diff = date2.getTime() - date1.getTime();
		    System.out.println ("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
		    date = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		    result = (int)date;
		} catch (ParseException e) {
		    e.printStackTrace();
		}
		
		
	    return result;
		
	}

}

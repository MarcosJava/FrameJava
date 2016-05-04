package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
	private final String formatDefault = "yyyy-MM-dd HH:mm:ss";
	

	/***
	 * Retorna hoje em String no formato desejavel
	 * @return
	 */
	public String today(String format){
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(calendar.getTime());
	}
	
	/***
	 * Retorna hoje em String no formato de banco de dados
	 * @return
	 */
	public String today(){
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(formatDefault);
		return sdf.format(calendar.getTime());
	}
	
	
	
	/***
	 * Converte a String na Data com o formato necessario
	 * @param dateString
	 * @return
	 */
	public Date converteStringInDate(String dateString, String format){
		
		DateFormat formatter = new SimpleDateFormat(format);
		Date date = null;
		try {
			date = (Date)formatter.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return date;
	}
	
	
	
	/***
	 *  Converte a String data em Calendar
	 * @param dateString
	 * @return
	 */
	public Calendar convertStringInCalendar(String dateString, String format){
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(sdf.parse(dateString));
			
			return calendar;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/***
	 * Converte a data em String
	 * @param date
	 * @param format
	 * @return
	 */
	public String convertDateInString(Date date, String format){
		return new SimpleDateFormat(format).format(date);
		
	}
	
	
	/***
	 * Troca o formato da data atual
	 * @param date
	 * @param format
	 * @return
	 */
	public Date changeFormatDate(Date date, String format){
		String dateString = convertDateInString(date, format);
		return converteStringInDate(dateString, format);
	}
	


	
}

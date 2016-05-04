package util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;



public class NumberUtil {

	/***
	 *  Converte a String em BigDecimal
	 * @param stringToBeConverted
	 * @return
	 */
	public BigDecimal stringToBigDecimal(String stringToBeConverted){
		
		DecimalFormatSymbols symbols = new DecimalFormatSymbols();
		symbols.setGroupingSeparator(',');
		symbols.setDecimalSeparator('.');
		String pattern = "#,##0.0#";
		DecimalFormat decimalFormat = new DecimalFormat(pattern, symbols);
		decimalFormat.setParseBigDecimal(true);

		BigDecimal bigDecimal = null;
		try {
			bigDecimal = (BigDecimal) decimalFormat.parse(stringToBeConverted);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return bigDecimal;
		
	}
	
}

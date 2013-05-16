/**
 * 
 */
package com.triton.digital.tech.quest;

import java.math.BigInteger;

import org.apache.log4j.Logger;

import com.ibm.icu.text.RuleBasedNumberFormat;
import com.ibm.icu.util.ULocale;

/**
 * Class used to generate a number in english
 * 
 * @author Ali Jooomun
 * @version 1.0.0
 * 
 */
public class EnglishNumberGenerator {

	private static final Logger LOGGER = Logger
			.getLogger(EnglishNumberGenerator.class);

	/**
	 * Method takes in an integer and then will translate it into it's
	 * corresponding English translation
	 * 
	 * @param standardNumber
	 *            number to be translated
	 * @return English equivalent of the number translated
	 */
	public static String translateNumber(BigInteger standardNumber) {
		RuleBasedNumberFormat ruleBasedNumberFormat = new RuleBasedNumberFormat(
				ULocale.ENGLISH, RuleBasedNumberFormat.SPELLOUT);

		String translatedNumber = "inputed value is null";
		if (standardNumber != null) {
			String ruleBasedTranslatedNumber = ruleBasedNumberFormat
					.format(standardNumber);
			
			if (ruleBasedTranslatedNumber != null) {
				translatedNumber = ruleBasedTranslatedNumber.replace('-', ' ');
				translatedNumber = Character.toString(
						translatedNumber.charAt(0)).toUpperCase()
						+ translatedNumber.substring(1);
			}
		}

		LOGGER.info("Number " + standardNumber + " has been translated to "
				+ translatedNumber);

		return translatedNumber;
	}
}

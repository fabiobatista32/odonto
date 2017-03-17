package br.com.softodonto.util;

import java.util.ResourceBundle;

public class MessageUtil {

	public static ResourceBundle msgs() {
		ResourceBundle msg = ResourceBundle.getBundle("message");
		return msg;
	}
}
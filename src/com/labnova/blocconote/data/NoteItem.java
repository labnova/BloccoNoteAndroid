package com.labnova.blocconote.data;

import java.util.Locale;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class NoteItem {
	
	
	
	private String key;
	private String text;
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

	
	public static NoteItem getNew() {
		
		Locale locale= new Locale("en_US");
		Locale.setDefault(locale);
		
		String pattern= "yyyy-MM-dd HH:mm:ss Z";
		SimpleDateFormat formatter= new SimpleDateFormat(pattern);
		
		String key= formatter.format(new Date(0));
		
		NoteItem note = new NoteItem();
		
		
		note.setKey(key);
		note.setText("");
		
		return note;
		
		
		
	}
	
	public String toString() {
		return this.getText();
		
	}
	
}

package com.tnr.scgc.base;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {
	
	public static  Date date=new Date();
	public synchronized static long getDate(Date date) {
		return date.getTime();
	}
	
	
	public static void main(String[] args) {
		
		Time t = new Time();
		
		System.out.println(t.getDate(date)); 
		
		
	}

}

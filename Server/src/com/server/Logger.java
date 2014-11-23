package com.server;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Logger {

	private FileOutputStream Logstream;
	private DataOutputStream Writestream;
	private Date time;
	SimpleDateFormat sdf;
	
	public Logger(String pfad)
	{
		try {
				time = new java.util.Date();
				sdf = new java.text.SimpleDateFormat("dd.MM.yyyy HH.mm.ss");
				Logstream = new FileOutputStream (pfad+ "\\Logger.txt",true);
				Writestream = new DataOutputStream(Logstream);
				
		} catch (FileNotFoundException e) {
			System.out.println("Konnte Stream nicht initialisieren.Fehler: "+ e.toString());
		}
	}
	public void Error(String Meldung)
	{
		
		try {
			time = new java.util.Date();
			Writestream.writeBytes("[" +  sdf.format(time) + "] "  +  "[ERROR] : " + Meldung  + "\r\n");
		} catch (IOException e) {
		}
	}
	
	public void Info(String Meldung){
		try {
			time = new java.util.Date();
			Writestream.writeBytes("[" + sdf.format(time) + "] "  +  "[INFO] : " + Meldung + "\r\n");
		} catch (IOException e) {
		}
	}
	
	public void Debug(String Meldung){
		try {
			time = new java.util.Date();
			Writestream.writeBytes("[" + sdf.format(time) + "] "  +  "[DEBUG] : " + Meldung + "\r\n");
		} catch (IOException e) {
		}
	}
	
	
}

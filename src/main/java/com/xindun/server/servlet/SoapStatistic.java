package com.xindun.server.servlet;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SoapStatistic extends Thread {
	private static Logger log = LoggerFactory.getLogger(SoapStatistic.class);
	private static long totalmsg = 0;
	private static long totaltime = 0;
	private static long avaragetime = 0;
	private static long maxduration = 0;
	private static long msgcount = 0;
	private static long msgpersec = 0;
	private static String starttime = "";
	private static String endtime = "";
	private static SoapStatistic instance = new SoapStatistic();

    private boolean run = false;

    private SoapStatistic()
	{
		super("SoapStatistic-1");
		run=true;
		
//		log.warn("SoapStatistic started...");
	}
	public static SoapStatistic getInstance() {

//		log.info("new SoapStatistic ");
		return instance;
	}

	public synchronized void addsoapmsg(String methodName, String duration) {
		int durationtime = Integer.parseInt(duration);
		totaltime += durationtime;
		if (durationtime > maxduration) {
			maxduration = durationtime;
		}
		msgcount++;
		totalmsg++;
	};

	public void run() {
		while (run) {
			try {

				totaltime = 0;
				maxduration = 0;
				msgcount = 0;
				avaragetime = 0;
				msgpersec = 0;
				int sleeptime = 10;
				starttime = DateTime.GetCurrentDateTimeString();

				Thread.sleep(sleeptime*1000);

				endtime = DateTime.GetCurrentDateTimeString();
				if (msgcount > 0) {
					avaragetime = totaltime / msgcount;
				} else {
					avaragetime = totaltime;
				}
				msgpersec = msgcount / sleeptime;

//				log.info(starttime + "--" + endtime + ": " + "|-msgcount-"
//						+ msgcount + "|-maxduration-" + maxduration
//						+ "|-avaragetime-" + avaragetime + "|-msgpersec-"
//						+ msgpersec +"|-totalmsg-" + totalmsg);
				Thread.sleep(sleeptime*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		run=false;
//		log.warn("SoapStatistic stop");
	}

	public void init() {
//		totalmsg =0;
//		totaltime = 0;
//		maxduration = 0;
//		msgcount = 0;
//		avaragetime = 0;
//		msgpersec = 0;
//		starttime = "";
//		endtime = "";
//		log.warn("SoapStatistic start");
		this.start();
	}

	public void destroy() {
		this.interrupt();
		run=false;
//		log.warn("SoapStatistic destroyed");
	}

}

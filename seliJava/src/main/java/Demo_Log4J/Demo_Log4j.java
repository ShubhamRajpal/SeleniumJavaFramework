package Demo_Log4J;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Demo_Log4J.Demo_Log4j;

public class Demo_Log4j {

	static Logger log = LogManager.getLogger(Demo_Log4j.class);

	public static void main(String[] args) {

		System.out.println("\nHello World!..\n");
		
		log.trace("This is a trace Msg");
		log.info("This is an Info Msg");
		log.error("This is an Error Msg");
		log.warn("This is an warning Msg");
		log.fatal("This is an Fatal Msg");
		
		System.out.println("Completed");

	}

}

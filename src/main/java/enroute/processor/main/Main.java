package enroute.processor.main;

import java.io.InputStream;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {
	public static void main(String[] args) {
		if (!loadLoggerConfiguration())
			return;

		final Logger logger = Logger.getLogger(Main.class.getName());

		logger.info("Starting EnRoute Inventory Processor...");
	}

	private static boolean loadLoggerConfiguration() {
		final InputStream propStream = Main.class.getClassLoader().getResourceAsStream("logging.properties");

		try {
			LogManager.getLogManager().readConfiguration(propStream);
		} catch (Throwable t) {
			t.printStackTrace();
			return false;
		}

		return true;
	}
}

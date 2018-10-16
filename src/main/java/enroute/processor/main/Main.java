package enroute.processor.main;

import java.io.InputStream;
import java.util.Collection;
import java.util.Properties;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import enroute.processor.inventory.InventoryDAO;
import enroute.processor.inventory.InventoryEntry;

public class Main {
	public static void main(String[] args) {
		if (!loadLoggerConfiguration())
			return;

		final Logger logger = Logger.getLogger(Main.class.getName());
		final Properties config = getConfiguration();

		logger.info("Starting EnRoute Inventory Processor...");

		logger.info("Retrieving open inventory");
		final InventoryDAO inventory = new InventoryDAO(config.getProperty("inventory_db_url"));
		final Collection<InventoryEntry> openEntries = inventory.getOpenEntries();
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

	private static Properties getConfiguration() {
		final Properties config = new Properties();

		try {
			config.load(Main.class.getClassLoader().getResourceAsStream("enroute.config"));
		} catch (Throwable t) {
			throw new RuntimeException(t);
		}

		return config;
	}
}

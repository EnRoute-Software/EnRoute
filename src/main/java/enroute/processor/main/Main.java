package enroute.processor.main;

import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import enroute.processor.inventory.InventoryDAO;
import enroute.processor.inventory.InventoryEntry;

public class Main {
	static {
		loadLoggerConfiguration();
	}

	private static final Logger logger = Logger.getLogger(Main.class.getName());

	public static void main(String[] args) {
		final Properties config = getConfiguration();

		logger.info("Starting EnRoute Inventory Processor...");

		logger.info("Retrieving open inventory");
		final InventoryDAO inventory = new InventoryDAO(config.getProperty("inventory_db_url"));
		final List<InventoryEntry> openEntries = inventory.getOpenEntries();
	}

	private static void loadLoggerConfiguration() {
		final InputStream propStream = Main.class.getClassLoader().getResourceAsStream("logging.properties");

		try {
			LogManager.getLogManager().readConfiguration(propStream);
		} catch (Throwable t) {
			throw new RuntimeException(t);
		}
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

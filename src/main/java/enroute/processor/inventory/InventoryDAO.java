package enroute.processor.inventory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import enroute.processor.transform.ITransformer;

public class InventoryDAO {
	private static final Logger logger = Logger.getLogger(InventoryDAO.class.getName());

	private static final String openInventoryQuery = "SELECT * FROM enroute.inventory WHERE statusCd=0";

	private final Connection connection;
	private final ITransformer<ResultSet, List<InventoryEntry>> deserializer;

	public InventoryDAO(final String connectionURI) {
		try {
			logger.fine(String.format("Attempting connection to Inventory DB with uri: %s", connectionURI));
			connection = DriverManager.getConnection(connectionURI);
			deserializer = new InventoryEntryJDBCDeserializer();
		} catch (final SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<InventoryEntry> getOpenEntries() {
		try {
			return deserializer.transform(connection.prepareStatement(openInventoryQuery).executeQuery());
		} catch (final SQLException e) {
			throw new RuntimeException(e);
		}

	}
}

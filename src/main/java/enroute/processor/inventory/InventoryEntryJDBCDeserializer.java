package enroute.processor.inventory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import enroute.processor.transform.ITransformer;

public class InventoryEntryJDBCDeserializer implements ITransformer<ResultSet, List<InventoryEntry>> {

	private static final String ENTRY_ID_COLUMN = "entryId";
	private static final String CREATE_DATE_COLUMN = "createDate";
	private static final String CUSTOMER_ID_COLUMN = "customerId";
	private static final String DEPARTURE_CODE_COLUMN = "departureCd";
	private static final String DEPARTURE_DATE_COLUMN = "departureDate";
	private static final String DESTINATION_CODE_COLUMN = "destinationCd";
	private static final String ROUND_TRIP_FLAG_COLUMN = "roundTripFlag";
	private static final String ROUND_TRIP_DEPART_DATE_COLUMN = "roundTripDepartDate";
	private static final String TICKET_COUNT_COLUMN = "ticketCount";
	private static final String TICKET_CLASS_COLUMN = "ticketClass";

	@Override
	public List<InventoryEntry> transform(final ResultSet source) {
		try {
			final List<InventoryEntry> entries = new ArrayList<InventoryEntry>();

			while (source.next()) {
				entries.add(new InventoryEntry(
						source.getInt(ENTRY_ID_COLUMN),
						source.getDate(CREATE_DATE_COLUMN),
						source.getInt(CUSTOMER_ID_COLUMN),
						source.getString(DEPARTURE_CODE_COLUMN),
						source.getDate(DEPARTURE_DATE_COLUMN),
						source.getString(DESTINATION_CODE_COLUMN),
						source.getBoolean(ROUND_TRIP_FLAG_COLUMN),
						source.getDate(ROUND_TRIP_DEPART_DATE_COLUMN),
						source.getInt(TICKET_COUNT_COLUMN),
						source.getInt(TICKET_CLASS_COLUMN)));
			}

			return entries;
		} catch (final SQLException e) {
			throw new RuntimeException(e);
		}
	}
}

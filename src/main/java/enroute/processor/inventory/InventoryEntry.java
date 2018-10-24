package enroute.processor.inventory;

import java.util.Date;

public class InventoryEntry {
	private final long id;
	private final Date createDate;
	private final int customerId;
	private final String departureCode;
	private final Date departureDate;
	private final String destinationCode;
	private final boolean isRoundTrip;
	private final Date roundTripDepartureDate;
	private final int ticketCount;
	private final int ticketClassCode;

	public InventoryEntry(long id, Date createDate, int customerId, String departureCode, Date departureDate,
			String destinationCode, boolean isRoundTrip, Date roundTripDepartureDate, int ticketCount,
			int ticketClassCode) {
		this.id = id;
		this.createDate = createDate;
		this.customerId = customerId;
		this.departureCode = departureCode;
		this.departureDate = departureDate;
		this.destinationCode = destinationCode;
		this.isRoundTrip = isRoundTrip;
		this.roundTripDepartureDate = roundTripDepartureDate;
		this.ticketCount = ticketCount;
		this.ticketClassCode = ticketClassCode;
	}

	public long getId() {
		return id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public int getCustomerId() {
		return customerId;
	}

	public String getDepartureCode() {
		return departureCode;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public String getDestinationCode() {
		return destinationCode;
	}

	public boolean isRoundTrip() {
		return isRoundTrip;
	}

	public Date getRoundTripDepartureDate() {
		return roundTripDepartureDate;
	}

	public int getTicketCount() {
		return ticketCount;
	}

	public int getTicketClassCode() {
		return ticketClassCode;
	}
}

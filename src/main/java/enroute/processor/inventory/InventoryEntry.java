package enroute.processor.inventory;

public class InventoryEntry {
	private final long id;
	private final long createDate;
	private final long customerId;
	private final int departureCode;
	private final long departureDate;
	private final int destinationCode;
	private final boolean isRoundTrip;
	private final long roundTripDepartureDate;
	private final short ticketCount;
	private final int ticketClassCode;

	public InventoryEntry(long id, long createDate, long customerId, int departureCode, long departureDate,
			int destinationCode, boolean isRoundTrip, long roundTripDepartureDate, short ticketCount,
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

	public long getCreateDate() {
		return createDate;
	}

	public long getCustomerId() {
		return customerId;
	}

	public int getDepartureCode() {
		return departureCode;
	}

	public long getDepartureDate() {
		return departureDate;
	}

	public int getDestinationCode() {
		return destinationCode;
	}

	public boolean isRoundTrip() {
		return isRoundTrip;
	}

	public long getRoundTripDepartureDate() {
		return roundTripDepartureDate;
	}

	public short getTicketCount() {
		return ticketCount;
	}

	public int getTicketClassCode() {
		return ticketClassCode;
	}
}

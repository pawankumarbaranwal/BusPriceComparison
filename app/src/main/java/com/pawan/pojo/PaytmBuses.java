package com.pawan.pojo;

public class PaytmBuses {

	private String tripId;
	private String departureDate;
	private long providerId;
	private String arrivalTime;
	private String departureTime;
	private String boardingTime;
	private String avalableSeats;
	private boolean isAc;
	private boolean isSleeper;
	private boolean isMobileTicketAllowed;
	private String busType;
	private boolean partialCancellationAllowed;
	private String[] fare;
	private boolean idProofRequired;
	private String travelsName;
	private String computedTravelsName;
	private BoardingLocation boardingLocations[];
	private DroppingLocation droppingLocations[];
	private long ratings;
	private long operator_id;
	private String duration;
	private Info info;
	private boolean isNonAc;
	private boolean isNonSleeper;
	private boolean isLuxury;
	private String reportingTime;
	private long travelDurationDays;
	private String arrivalDate;
	private long providerPriority;
	private String providerName;
	private boolean is_service_charge_extra;
	private String service_tax_message;
	private boolean isBusiness;
	

	public String getTripId() {
		return tripId;
	}

	public void setTripId(String tripId) {
		this.tripId = tripId;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public long getProviderId() {
		return providerId;
	}

	public void setProviderId(long providerId) {
		this.providerId = providerId;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getBoardingTime() {
		return boardingTime;
	}

	public void setBoardingTime(String boardingTime) {
		this.boardingTime = boardingTime;
	}

	public String getAvalableSeats() {
		return avalableSeats;
	}

	public void setAvalableSeats(String avalableSeats) {
		this.avalableSeats = avalableSeats;
	}

	public boolean isAc() {
		return isAc;
	}

	public void setAc(boolean isAc) {
		this.isAc = isAc;
	}

	public boolean isSleeper() {
		return isSleeper;
	}

	public void setSleeper(boolean isSleeper) {
		this.isSleeper = isSleeper;
	}

	public boolean isMobileTicketAllowed() {
		return isMobileTicketAllowed;
	}

	public void setMobileTicketAllowed(boolean isMobileTicketAllowed) {
		this.isMobileTicketAllowed = isMobileTicketAllowed;
	}

	public String getBusType() {
		return busType;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}

	public boolean isPartialCancellationAllowed() {
		return partialCancellationAllowed;
	}

	public void setPartialCancellationAllowed(boolean partialCancellationAllowed) {
		this.partialCancellationAllowed = partialCancellationAllowed;
	}

	public String getFare() {
		return fare[0];
	}

	public void setFare(String[] fare) {
		this.fare = fare;
	}

	public boolean isIdProofRequired() {
		return idProofRequired;
	}

	public void setIdProofRequired(boolean idProofRequired) {
		this.idProofRequired = idProofRequired;
	}

	public String getTravelsName() {
		return travelsName;
	}

	public void setTravelsName(String travelsName) {
		this.travelsName = travelsName;
	}

	public String getComputedTravelsName() {
		return computedTravelsName;
	}

	public void setComputedTravelsName(String computedTravelsName) {
		this.computedTravelsName = computedTravelsName;
	}

	public BoardingLocation[] getBoardingLocations() {
		return boardingLocations;
	}

	public void setBoardingLocations(BoardingLocation[] boardingLocations) {
		this.boardingLocations = boardingLocations;
	}

	public DroppingLocation[] getDroppingLocations() {
		return droppingLocations;
	}

	public void setDroppingLocations(DroppingLocation[] droppingLocations) {
		this.droppingLocations = droppingLocations;
	}

	public long getRatings() {
		return ratings;
	}

	public void setRatings(long ratings) {
		this.ratings = ratings;
	}

	public long getOperator_id() {
		return operator_id;
	}

	public void setOperator_id(long operator_id) {
		this.operator_id = operator_id;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	public boolean isNonAc() {
		return isNonAc;
	}

	public void setNonAc(boolean isNonAc) {
		this.isNonAc = isNonAc;
	}

	public boolean isNonSleeper() {
		return isNonSleeper;
	}

	public void setNonSleeper(boolean isNonSleeper) {
		this.isNonSleeper = isNonSleeper;
	}

	public boolean isLuxury() {
		return isLuxury;
	}

	public void setLuxury(boolean isLuxury) {
		this.isLuxury = isLuxury;
	}

	public String getReportingTime() {
		return reportingTime;
	}

	public void setReportingTime(String reportingTime) {
		this.reportingTime = reportingTime;
	}

	public long getTravelDurationDays() {
		return travelDurationDays;
	}

	public void setTravelDurationDays(long travelDurationDays) {
		this.travelDurationDays = travelDurationDays;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public long getProviderPriority() {
		return providerPriority;
	}

	public void setProviderPriority(long providerPriority) {
		this.providerPriority = providerPriority;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public boolean isIs_service_charge_extra() {
		return is_service_charge_extra;
	}

	public void setIs_service_charge_extra(boolean is_service_charge_extra) {
		this.is_service_charge_extra = is_service_charge_extra;
	}

	public String getService_tax_message() {
		return service_tax_message;
	}

	public void setService_tax_message(String service_tax_message) {
		this.service_tax_message = service_tax_message;
	}

	public boolean isBusiness() {
		return isBusiness;
	}

	public void setBusiness(boolean isBusiness) {
		this.isBusiness = isBusiness;
	}

	class BoardingLocation {
		public String providerLocationId;
		public String locationName;
		public String time;
		public String reportingTime;
		public String boardingDate;

	}

	class DroppingLocation {
		public String providerLocationId;
		public String locationName;
		public String time;


	}

	class Info {
		public CancellationPolicyJSON cancellationPolicyJSON[];
		public long source_id;
		public long destination_id;
		public String travel_date;
		public long count;


		class CancellationPolicyJSON {
			public String departure_heading;
			public String policy_heading;
		}
	}
}
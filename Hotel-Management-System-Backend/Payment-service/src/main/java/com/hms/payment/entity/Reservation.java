package com.hms.payment.entity;

import org.springframework.data.annotation.Id;

public class Reservation {

	@Id
	private String reservationId;
	private int roomNo;
	private String guestId;
	private String checkInDate;
	private String checkOutDate;
	private int totalPrice;

	public Reservation() {
		super();
	}

	public Reservation(String reservationId, int roomNo, String guestId, String checkInDate, String checkOutDate,
			int totalPrice) {
		super();
		this.reservationId = reservationId;
		this.roomNo = roomNo;
		this.guestId = guestId;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.totalPrice = totalPrice;
	}

	public String getReservationId() {
		return reservationId;
	}

	public void setReservationId(String reservationId) {
		this.reservationId = reservationId;
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public String getGuestId() {
		return guestId;
	}

	public void setGuestId(String guestId) {
		this.guestId = guestId;
	}

	public String getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}

	public String getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

}

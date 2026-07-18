package com.hotel.dto;

public class RoomResponse {

    private Long id;
    private String roomNumber;
    private String roomType;
    private Double pricePerNight;
    private Boolean available;
    private Long hotelId;
    private String hotelName;

    public RoomResponse() {
    }

    public RoomResponse(Long id,
                        String roomNumber,
                        String roomType,
                        Double pricePerNight,
                        Boolean available,
                        Long hotelId,
                        String hotelName) {

        this.id = id;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.available = available;
        this.hotelId = hotelId;
        this.hotelName = hotelName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id=id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber=roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType=roomType;
    }

    public Double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(Double pricePerNight) {
        this.pricePerNight=pricePerNight;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available=available;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId=hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName=hotelName;
    }

}
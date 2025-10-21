package com.example.wedding_web.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String eventDate;
    private String decor;
    private String cake;
    private String floral;
    private String flowerset;
    private String sangeet;
    private String bridalshower;
    private String mehandi;
    private String wedding;
    private String reception;
    private String vegItems;
    private String nonVegItems;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user; // link to the user who booked

    public Booking() {
    }

    public Booking(User user) {
        this.user = user;
    }

    // ✅ Getters and setters
    public Long getId() {
        return id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // getters & setters

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getDecor() {
        return decor;
    }

    public void setDecor(String decor) {
        this.decor = decor;
    }

    public String getCake() {
        return cake;
    }

    public void setCake(String cake) {
        this.cake = cake;
    }

    public String getFloral() {
        return floral;
    }

    public void setFloral(String floral) {
        this.floral = floral;
    }

    public String getFlowerset() {
        return flowerset;
    }

    public void setFlowerset(String flowerset) {
        this.flowerset = flowerset;
    }

    public String getSangeet() {
        return sangeet;
    }

    public void setSangeet(String sangeet) {
        this.sangeet = sangeet;
    }

    public String getBridalshower() {
        return bridalshower;
    }

    public void setBridalshower(String bridalshower) {
        this.bridalshower = bridalshower;
    }

    public String getMehandi() {
        return mehandi;
    }

    public void setMehandi(String mehandi) {
        this.mehandi = mehandi;
    }

    public String getWedding() {
        return wedding;
    }

    public void setWedding(String wedding) {
        this.wedding = wedding;
    }

    public String getReception() {
        return reception;
    }

    public void setReception(String reception) {
        this.reception = reception;
    }

    public String getVegItems() {
        return vegItems;
    }

    public void setVegItems(String vegItems) {
        this.vegItems = vegItems;
    }

    public String getNonVegItems() {
        return nonVegItems;
    }

    public void setNonVegItems(String nonVegItems) {
        this.nonVegItems = nonVegItems;
    }

}

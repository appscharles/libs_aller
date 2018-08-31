package com.appscharles.libs.aller.models;

import com.appscharles.libs.aller.models.pointsOfServices.Address;
import com.appscharles.libs.aller.models.pointsOfServices.OpenHour;
import com.appscharles.libs.aller.models.pointsOfServices.Payment;
import com.appscharles.libs.aller.models.pointsOfServices.enums.ConfirmationType;
import com.appscharles.libs.aller.models.pointsOfServices.enums.Status;
import com.appscharles.libs.aller.models.pointsOfServices.enums.Type;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * The type Points of service.
 */
public class PointOfService {

    private String id;

    private String externalId;

    private String name;

    private Seller seller;

    private Type type;

    private Address address;

    private String phoneNumber;

    private String email;

    private List<OpenHour> openHours;

    private String serviceTime;

    private List<Payment> payments;

    private ConfirmationType confirmationType;

    private Status status;

    private Calendar createdAt;

    private Calendar updatedAt;

    /**
     * Instantiates a new Points of service.
     */
    public PointOfService() {
    }

    /**
     * Instantiates a new Points of service.
     *
     * @param name             the name
     * @param seller           the seller
     * @param type             the type
     * @param address          the address
     * @param confirmationType the confirmation type
     * @param status           the status
     */
    public PointOfService(String name, Seller seller, Type type, Address address, ConfirmationType confirmationType, Status status) {
        this.name = name;
        this.seller = seller;
        this.type = type;
        this.address = address;
        this.confirmationType = confirmationType;
        this.status = status;
        this.phoneNumber = "";
        this.email = "";
        this.openHours = new ArrayList<>();
        this.payments = new ArrayList<>();
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets external id.
     *
     * @return the external id
     */
    public String getExternalId() {
        return externalId;
    }

    /**
     * Sets external id.
     *
     * @param externalId the external id
     */
    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets seller.
     *
     * @return the seller
     */
    public Seller getSeller() {
        return seller;
    }

    /**
     * Sets seller.
     *
     * @param seller the seller
     */
    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public Type getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(Type type) {
        this.type = type;
    }

    /**
     * Gets address.
     *
     * @return the address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Sets address.
     *
     * @param address the address
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Gets phone number.
     *
     * @return the phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets phone number.
     *
     * @param phoneNumber the phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets open hours.
     *
     * @return the open hours
     */
    public List<OpenHour> getOpenHours() {
        return openHours;
    }

    /**
     * Sets open hours.
     *
     * @param openHours the open hours
     */
    public void setOpenHours(List<OpenHour> openHours) {
        this.openHours = openHours;
    }

    /**
     * Gets service time.
     *
     * @return the service time
     */
    public String getServiceTime() {
        return serviceTime;
    }

    /**
     * Sets service time.
     *
     * @param serviceTime the service time
     */
    public void setServiceTime(String serviceTime) {
        this.serviceTime = serviceTime;
    }

    /**
     * Gets payments.
     *
     * @return the payments
     */
    public List<Payment> getPayments() {
        return payments;
    }

    /**
     * Sets payments.
     *
     * @param payments the payments
     */
    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    /**
     * Gets confirmation type.
     *
     * @return the confirmation type
     */
    public ConfirmationType getConfirmationType() {
        return confirmationType;
    }

    /**
     * Sets confirmation type.
     *
     * @param confirmationType the confirmation type
     */
    public void setConfirmationType(ConfirmationType confirmationType) {
        this.confirmationType = confirmationType;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * Gets created at.
     *
     * @return the created at
     */
    public Calendar getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets created at.
     *
     * @param createdAt the created at
     */

    public void setCreatedAt(Calendar createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Gets updated at.
     *
     * @return the updated at
     */
    public Calendar getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Sets updated at.
     *
     * @param updatedAt the updated at
     */
    public void setUpdatedAt(Calendar updatedAt) {
        this.updatedAt = updatedAt;
    }
}

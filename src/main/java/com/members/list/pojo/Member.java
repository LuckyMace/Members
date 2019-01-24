package com.members.list.pojo;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "Member")
public class Member {

    @Id
    private String _id;

    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private Integer postalCode;
    private String picture;


    public Member() {
    }

    public Member(String _id, String firstName, String lastName, Date dateOfBirth, Integer postalCode, String picture) {
        this._id = _id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.postalCode = postalCode;
        this.picture = picture;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return String.format(
                "Member[_id=%s, firstName='%s', lastName='%s', dateOfBirth='%s', postalCode='%s', picture='%s']",
                _id, firstName, lastName, dateOfBirth, postalCode, picture);
    }
}

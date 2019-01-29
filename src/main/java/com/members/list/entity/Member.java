package com.members.list.entity;

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
    private String pictureId;


    public Member() {
    }

    public Member(String firstName, String lastName, Date dateOfBirth, Integer postalCode, String pictureId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.postalCode = postalCode;
        this.pictureId = pictureId;
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

    public String getPictureId() {
        return pictureId;
    }
    public void setPictureId(String pictureId) {
        this.pictureId = pictureId;
    }

    @Override
    public String toString() {
        return String.format(
                "Member[_id=%s, firstName='%s', lastName='%s', dateOfBirth='%s', postalCode='%s']",
                _id, firstName, lastName, dateOfBirth, postalCode);
    }
}

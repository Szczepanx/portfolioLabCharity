package pl.coderslab.charity.donation;


import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.charity.category.Category;
import pl.coderslab.charity.institution.Institution;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

@Entity
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantity;
    @ManyToMany
    @CollectionTable
    private String[] categories;
    @ManyToOne
    private Institution institution;

    private String street;

    private String city;

    private String zipCode;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String pickUpDate;

    private String pickUpTime;

    private String pickUpComment;

    public Donation(Long id, Integer quantity, String[] categories, Institution institution, String street, String city, String zipCode, String pickUpDate, String pickUpTime, String pickUpComment) {
        this.id = id;
        this.quantity = quantity;
        this.categories = categories;
        this.institution = institution;
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
        this.pickUpDate = pickUpDate;
        this.pickUpTime = pickUpTime;
        this.pickUpComment = pickUpComment;
    }

    public Donation(Integer quantity, String[] categories, Institution institution, String street, String city, String zipCode, String pickUpDate, String pickUpTime, String pickUpComment) {
        this.quantity = quantity;
        this.categories = categories;
        this.institution = institution;
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
        this.pickUpDate = pickUpDate;
        this.pickUpTime = pickUpTime;
        this.pickUpComment = pickUpComment;
    }

    public Donation() {
    }

    public Long getId() {
        return id;
    }

    public Donation setId(Long id) {
        this.id = id;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Donation setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }



    public String getStreet() {
        return street;
    }

    public Donation setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Donation setCity(String city) {
        this.city = city;
        return this;
    }

    public String getZipCode() {
        return zipCode;
    }

    public Donation setZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public Donation setCategories(List<Category> categories) {
        this.categories = categories;
        return this;
    }

    public Institution getInstitution() {
        return institution;
    }

    public Donation setInstitution(Institution institution) {
        this.institution = institution;
        return this;
    }

    public String getPickUpDate() {
        return pickUpDate;
    }

    public Donation setPickUpDate(String pickUpDate) {
        this.pickUpDate = pickUpDate;
        return this;
    }

    public String getPickUpTime() {
        return pickUpTime;
    }

    public Donation setPickUpTime(String pickUpTime) {
        this.pickUpTime = pickUpTime;
        return this;
    }

    public String getPickUpComment() {
        return pickUpComment;
    }

    public Donation setPickUpComment(String pickUpComment) {
        this.pickUpComment = pickUpComment;
        return this;
    }

    @Override
    public String toString() {
        return "Donation{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", categories=" + categories +
                ", institution=" + institution +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", pickUpDate=" + pickUpDate +
                ", pickUpTime=" + pickUpTime +
                ", pickUpComment='" + pickUpComment + '\'' +
                '}';
    }
}

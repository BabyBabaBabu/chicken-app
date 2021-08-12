package me.kitaa.chickenapp.chickenapp.seller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity(name = "Seller")
@Table(
    name = "seller",
    uniqueConstraints = {
        @UniqueConstraint( name = "unique_sellers_email" , columnNames = "email" )
    }
)
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Name", nullable = false)
    private String Name;

    @Column(name = "Contact", nullable = false)
    private String Contact;

    @Column(name = "Email", nullable = false, unique = true)
    private String Email;

    @Column(name = "Region", nullable = false)
    private String Region;

    @Column(name = "Estate", nullable = false)
    private String Estate;

    @Column(name = "poultryType", nullable = false)
    private String poultryType;

    @Column(name = "Quantity", nullable = false)
    private Integer Quantity;

    @Column(name = "Price", nullable = false)
    private String Price;

 
    public Seller(){

    }

    public Seller(Long id, String Name, String Contact, String Region, String Estate, String poultryType, Integer Quantity, String Price, String Email){
        this.id = id;
        this.Name = Name;
        this.Contact = Contact;
        this.Region = Region;
        this.Estate = Estate;
        this.poultryType = poultryType;
        this.Quantity = Quantity;
        this.Price = Price;
        this.Email = Email;
    }

    public Seller(String Name,String Contact, String Region,String Estate, String poultryType, Integer Quantity, String Price, String Email){
        this.Name = Name;
        this.Contact = Contact;
        this.Region = Region;
        this.Estate = Estate;
        this.poultryType = poultryType;
        this.Quantity = Quantity;
        this.Price = Price;
        this.Email = Email;
    }

    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return String return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return Integer return the Contact
     */
    public String getContact() {
        return Contact;
    }

    /**
     * @param Contact the Contact to set
     */
    public void setContact(String Contact) {
        this.Contact = Contact;
    }

    /**
     * @return String return the Region
     */
    public String getRegion() {
        return Region;
    }

    /**
     * @param Estate the Region to set
     */
    public void setRegion(String Region) {
        this.Region = Region;
    }


    /**
     * @return String return the Estate
     */
    public String getEstate() {
        return Estate;
    }

    /**
     * @param Estate the Estate to set
     */
    public void setEstate(String Estate) {
        this.Estate = Estate;
    }

    /**
     * @return String return the poultryType
     */
    public String getPoultryType() {
        return poultryType;
    }

    /**
     * @param poultryType the poultryType to set
     */
    public void setPoultryType(String poultryType) {
        this.poultryType = poultryType;
    }

    
    /**
     * @return Integer return the Quantity
     */
    public Integer getQuantity() {
        return Quantity;
    }

    /**
     * @param Quantity the Quantity to set
     */
    public void setQuantity(Integer Quantity) {
        this.Quantity = Quantity;
    }

    /**
     * @return String return the Price
     */
    public String getPrice() {
        return Price;
    }

    /**
     * @param Price the Price to set
     */
    public void setPrice(String Price) {
        this.Price = Price;
    }

    /**
     * @return String return the Email
     */
    public String getEmail() {
        return Email;
    }

    /**
     * @param Email the Email to set
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }

}

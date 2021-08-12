package me.kitaa.chickenapp.chickenapp.buyer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity(name = "Buyer")
@Table(
    name = "buyer",
    uniqueConstraints = {
        @UniqueConstraint( name = "unique_buyers_email" , columnNames = "email" )
    }
)
public class Buyer {

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

    
    public Buyer(){

    }

    public Buyer(Long id, String Name, String Contact, String Region, String Estate, String Email){
        this.id = id;
        this.Name = Name;
        this.Contact = Contact;
        this.Region = Region;
        this.Estate = Estate;
        this.Email = Email;
    }

    public Buyer(String Name, String Contact, String Region, String Estate, String Email){
        this.Name = Name;
        this.Contact = Contact;
        this.Region = Region;
        this.Estate = Estate;
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
     * @return String return the Contact
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
     * @param Region the Region to set
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

package pl.opms.be.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ADDRESS_TABLE")
public class AddressEntity {

    @Column(name = "street")
    private String street;

    @Column(name = "postalCode")
    private String postalCode;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    public void setCity(String city) {this.city = city;}
    public String getCity() {return city;}

    public void setCountry(String country) {this.country = country;}
    public String getCountry() {return country;}

    public void setPostalCode(String postalCode) {this.postalCode = postalCode;}
    public String getPostalCode() {return postalCode;}

    public void setStreet(String street) {this.street = street;}
    public String getStreet() {return street;}
}

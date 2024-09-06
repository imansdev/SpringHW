package ir.freeland.collection.model;

public class Address {
    private String city;
    private String country;
    private String street;

    public Address(String city, String country, String street) {
        this.city = city;
        this.country = country;
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getStreet() {
        return street;
    }

    @Override
    public String toString() {
        return "Address{" + "city='" + city + '\'' + ", country='" + country + '\'' + ", street='"
                + street + '\'' + '}';
    }
}

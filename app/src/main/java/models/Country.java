package models;





public class Country {
    private String Country;
    private String CountryCode;
    private int Cases;

    public Country(String name, String code, int casos){
        this.Country=name;
        this.CountryCode = code;
        this.Cases = casos;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }

    public int getCases() {
        return Cases;
    }

    public void setCases(int cases) {
        Cases = cases;
    }
}

package org.loose.fis.sre.model;

import org.dizitart.no2.objects.Id;

import java.util.Objects;

public class Price {
    @Id
    private String nume;
    private Integer price1;
    private Integer price2;

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Integer getPrice1() {
        return price1;
    }

    public void setPrice1(Integer price1) {
        this.price1 = price1;
    }

    public Integer getPrice2() {
        return price2;
    }

    public void setPrice2(Integer price2) {
        this.price2 = price2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return Objects.equals(nume, price.nume) && Objects.equals(price1, price.price1) && Objects.equals(price2, price.price2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nume, price1, price2);
    }

    @Override
    public String toString() {
        return "Price{" +
                "nume='" + nume + '\'' +
                ", price1=" + price1 +
                ", price2=" + price2 +
                '}';
    }
}

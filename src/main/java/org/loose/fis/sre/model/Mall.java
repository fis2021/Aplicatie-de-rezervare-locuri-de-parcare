package org.loose.fis.sre.model;

import org.dizitart.no2.objects.Id;
import java.util.Objects;

public class Mall {
    @Id
    private String name;
    private String adress;
    private String floors;

    public Mall(String name, String adress, String floors){
        this.name = name;
        this.adress = adress;
        this.floors = floors;
    }

    public Mall(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getFloors() {
        return floors;
    }

    public void setFloors(String floors) {
        this.floors = floors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mall mall = (Mall) o;
        return Objects.equals(name, mall.name) && Objects.equals(adress, mall.adress) && Objects.equals(floors, mall.floors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, adress, floors);
    }
}

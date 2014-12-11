package com.epam.entity;

import java.util.List;

/**
 * Created by User on 29.11.14.
 */
public class Gun {
    private long ID;
    private String model,origin;
    private List<Material> materials;
    private List<TTC> ttc;
    private Handy handy;

    public Gun() {
    }

    public Handy getHandy() {
        return handy;
    }

    public void setHandy(Handy handy) {
        this.handy = handy;
    }

    public Gun(long ID) {
        this.ID = ID;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public List<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(List<Material> materials) {
        this.materials = materials;
    }

    public List<TTC> getTtc() {
        return ttc;
    }

    public void setTtc(List<TTC> ttc) {
        this.ttc = ttc;
    }

    @Override
    public String toString() {
        return "Gun{" +
                "ID=" + ID +
                ", model='" + model + '\'' +
                ", origin='" + origin + '\'' +
                '}';
    }
}

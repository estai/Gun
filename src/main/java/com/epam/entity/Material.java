package com.epam.entity;

/**
 * Created by User on 29.11.14.
 */
public class Material {
    private BodyMaterial body;
    private BarrelMaterial barrel;

    public Material() {
    }

    public BodyMaterial getBody() {
        return body;
    }

    public void setBody(BodyMaterial body) {
        this.body = body;
    }

    public BarrelMaterial getBarrel() {
        return barrel;
    }

    public void setBarrel(BarrelMaterial barrel) {
        this.barrel = barrel;
    }
}

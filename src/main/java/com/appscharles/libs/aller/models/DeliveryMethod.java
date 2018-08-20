package com.appscharles.libs.aller.models;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 20.08.2018
 * Time: 15:46
 * Project name: aller
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class DeliveryMethod {

    private String id;

    private String name;

    public DeliveryMethod() {
    }

    public DeliveryMethod(String name) {
        this.name = name;
    }

    /**
     * Getter for property 'id'.
     *
     * @return Value for property 'id'.
     */
    public String getId() {
        return id;
    }

    /**
     * Setter for property 'id'.
     *
     * @param id Value to set for property 'id'.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter for property 'name'.
     *
     * @return Value for property 'name'.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for property 'name'.
     *
     * @param name Value to set for property 'name'.
     */
    public void setName(String name) {
        this.name = name;
    }
}

package com.appscharles.libs.aller.models.offers;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 20.08.2018
 * Time: 13:41
 * Project name: aller
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class Category {

    private String id;

    public Category() {
    }

    public Category(String id) {
        this.id = id;
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
}

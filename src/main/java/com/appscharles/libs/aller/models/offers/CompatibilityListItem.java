package com.appscharles.libs.aller.models.offers;

/**
 * The type Compatibility list item.
 */
public class CompatibilityListItem {

    private String text;

    /**
     * Instantiates a new Compatibility list item.
     */
    public CompatibilityListItem() {
    }

    /**
     * Instantiates a new Compatibility list item.
     *
     * @param text the text
     */
    public CompatibilityListItem(String text) {
        this.text = text;
    }

    /**
     * Gets text.
     *
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * Sets text.
     *
     * @param text the text
     */
    public void setText(String text) {
        this.text = text;
    }
}

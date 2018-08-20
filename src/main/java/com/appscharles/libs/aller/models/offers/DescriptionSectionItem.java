package com.appscharles.libs.aller.models.offers;

import com.appscharles.libs.aller.models.offers.enums.ItemType;

/**
 * The type Description section item.
 */
public class DescriptionSectionItem  {


    private ItemType type;

    private String content;

    /**
     * Instantiates a new Description section item.
     */
    public DescriptionSectionItem() {
    }

    /**
     * Instantiates a new Description section item.
     *
     * @param type    the type
     * @param content the content
     */
    public DescriptionSectionItem(ItemType type, String content) {
        this.type = type;
        this.content = content;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public ItemType getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(ItemType type) {
        this.type = type;
    }

    /**
     * Gets content.
     *
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets content.
     *
     * @param content the content
     */
    public void setContent(String content) {
        this.content = content;
    }
}

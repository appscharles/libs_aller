package com.appscharles.libs.aller.models.offers;

import com.appscharles.libs.aller.models.offers.enums.ItemType;

/**
 * The type Description section item.
 */
public class DescriptionSectionItem  {

    private ItemType type;

    private String content;

    private String url;

    /**
     * Instantiates a new Description section item.
     */
    public DescriptionSectionItem() {
    }

    /**
     * Instantiates a new Description section item.
     *
     * @param type         the type
     * @param contentOrUrl the content or url
     */
    public DescriptionSectionItem(ItemType type, String contentOrUrl) {
        this.type = type;
        if (type.equals(ItemType.TEXT)){
            this.content = contentOrUrl;
        } else if (type.equals(ItemType.IMAGE)){
            this.url = contentOrUrl;
        }

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

    /**
     * Gets url.
     *
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets url.
     *
     * @param url the url
     */
    public void setUrl(String url) {
        this.url = url;
    }
}

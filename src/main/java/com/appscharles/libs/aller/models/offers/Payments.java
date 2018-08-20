package com.appscharles.libs.aller.models.offers;

import com.appscharles.libs.aller.models.offers.enums.InvoiceType;

/**
 * The type Payments.
 */
public class Payments {

    private InvoiceType invoice;

    /**
     * Instantiates a new Payments.
     */
    public Payments() {
    }

    /**
     * Instantiates a new Payments.
     *
     * @param invoice the invoice
     */
    public Payments(InvoiceType invoice) {
        this.invoice = invoice;
    }

    /**
     * Gets invoice.
     *
     * @return the invoice
     */
    public InvoiceType getInvoice() {
        return invoice;
    }

    /**
     * Sets invoice.
     *
     * @param invoice the invoice
     */
    public void setInvoice(InvoiceType invoice) {
        this.invoice = invoice;
    }
}

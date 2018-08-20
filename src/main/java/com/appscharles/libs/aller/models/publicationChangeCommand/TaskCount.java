package com.appscharles.libs.aller.models.publicationChangeCommand;

/**
 * The type Task count.
 */
public class TaskCount {

    private Integer failed;

    private Integer success;

    private Integer total;

    /**
     * Instantiates a new Task count.
     */
    public TaskCount() {
    }

    /**
     * Gets failed.
     *
     * @return the failed
     */
    public Integer getFailed() {
        return failed;
    }

    /**
     * Sets failed.
     *
     * @param failed the failed
     */
    public void setFailed(Integer failed) {
        this.failed = failed;
    }

    /**
     * Gets success.
     *
     * @return the success
     */
    public Integer getSuccess() {
        return success;
    }

    /**
     * Sets success.
     *
     * @param success the success
     */
    public void setSuccess(Integer success) {
        this.success = success;
    }

    /**
     * Gets total.
     *
     * @return the total
     */
    public Integer getTotal() {
        return total;
    }

    /**
     * Sets total.
     *
     * @param total the total
     */
    public void setTotal(Integer total) {
        this.total = total;
    }
}

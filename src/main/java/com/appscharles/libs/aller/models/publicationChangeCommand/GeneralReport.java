package com.appscharles.libs.aller.models.publicationChangeCommand;

/**
 * The type General report.
 */
public class GeneralReport {

    private String id;

    private TaskCount taskCount;

    /**
     * Instantiates a new General report.
     */
    public GeneralReport() {
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets task count.
     *
     * @return the task count
     */
    public TaskCount getTaskCount() {
        return taskCount;
    }

    /**
     * Sets task count.
     *
     * @param taskCount the task count
     */
    public void setTaskCount(TaskCount taskCount) {
        this.taskCount = taskCount;
    }
}

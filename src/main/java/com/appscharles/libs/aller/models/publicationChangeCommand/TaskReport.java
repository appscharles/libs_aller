package com.appscharles.libs.aller.models.publicationChangeCommand;

import java.util.List;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 20.08.2018
 * Time: 17:12
 * Project name: aller
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class TaskReport {

    private List<CommandTask> tasks;

    public TaskReport() {
    }

    /**
     * Getter for property 'tasks'.
     *
     * @return Value for property 'tasks'.
     */
    public List<CommandTask> getTasks() {
        return tasks;
    }

    /**
     * Setter for property 'tasks'.
     *
     * @param tasks Value to set for property 'tasks'.
     */
    public void setTasks(List<CommandTask> tasks) {
        this.tasks = tasks;
    }
}

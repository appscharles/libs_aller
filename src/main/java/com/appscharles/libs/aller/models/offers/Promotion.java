package com.appscharles.libs.aller.models.offers;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 20.08.2018
 * Time: 14:35
 * Project name: aller
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class Promotion {

    private boolean bold;

    private boolean departmentPage;

    private boolean emphasized;

    private boolean emphasizedHighlightBoldPackage;

    private boolean highlight;

    public Promotion() {
    }

    public Promotion(boolean bold, boolean departmentPage, boolean emphasized, boolean emphasizedHighlightBoldPackage, boolean highlight) {
        this.bold = bold;
        this.departmentPage = departmentPage;
        this.emphasized = emphasized;
        this.emphasizedHighlightBoldPackage = emphasizedHighlightBoldPackage;
        this.highlight = highlight;
    }

    public boolean getBold() {
        return bold;
    }

    public void setBold(boolean bold) {
        this.bold = bold;
    }

    public boolean getDepartmentPage() {
        return departmentPage;
    }

    public void setDepartmentPage(boolean departmentPage) {
        this.departmentPage = departmentPage;
    }

    public boolean getEmphasized() {
        return emphasized;
    }

    public void setEmphasized(boolean emphasized) {
        this.emphasized = emphasized;
    }

    public boolean getEmphasizedHighlightBoldPackage() {
        return emphasizedHighlightBoldPackage;
    }

    public void setEmphasizedHighlightBoldPackage(boolean emphasizedHighlightBoldPackage) {
        this.emphasizedHighlightBoldPackage = emphasizedHighlightBoldPackage;
    }

    public boolean getHighlight() {
        return highlight;
    }

    public void setHighlight(boolean highlight) {
        this.highlight = highlight;
    }
}

package com.appareldiving.adidasdatascraping.util;

public class Source {

    private String sourceName;
    private String link;

    public Source() {
    }

    public Source(String sourceName, String link) {
        this.sourceName = sourceName;
        this.link = link;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}

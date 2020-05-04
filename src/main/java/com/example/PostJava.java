package com.example;

import com.faunadb.client.types.FaunaConstructor;
import com.faunadb.client.types.FaunaField;

public class PostJava {

    private String title;
    private String summary;

    public PostJava() {}
    @FaunaConstructor
    public PostJava(
            @FaunaField("title") String title,
            @FaunaField("summary") String summary) {
        this.title = title;
        this.summary = summary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }


}

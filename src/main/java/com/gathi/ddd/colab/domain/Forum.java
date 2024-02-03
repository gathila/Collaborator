package com.gathi.ddd.colab.domain;

import com.gathi.ddd.colab.domain.user.Author;
import lombok.Data;

import java.util.Date;

@Data
public class Forum {

    private String id;

    private final Author author;
    private String topic;
    private String description;
    private final Date createdDateTime;

    private boolean isActive;

    public Forum(Author author, String topic, String description) {
        this.author = author;
        this.topic = topic;
        this.description = description;
        this.createdDateTime = new Date();
        this.isActive = true;
    }

    public Discussion startDiscussion(Author author, String topic) {

        if (!isActive) {
            throw new IllegalStateException("Forum is closed");
        }

        return new Discussion(id, author, topic);
    }
}

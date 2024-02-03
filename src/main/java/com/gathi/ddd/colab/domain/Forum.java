package com.gathi.ddd.colab.domain;

public class Forum {

    private String id;
    private boolean isActive;

    public Discussion startDiscussion(Author author, String topic) {

        if (!isActive) {
            throw new IllegalStateException("Forum is closed");
        }

        return new Discussion(id, author, topic);
    }
}

package com.gathi.ddd.colab.domain;

import com.gathi.ddd.colab.domain.user.Author;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.IdGeneratorType;

import java.util.Date;

@Data
@Entity
public class Forum {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
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

        Discussion discussion = new Discussion(this, author, topic);

//        DomainEventPublisher
//                .instance()
//                .publish(new DiscussionStarted(
//                        discussion.tenant(),
//                        discussion.forumId(),
//                        discussion.discussionId(),
//                        discussion.subject()));

        return discussion;
    }
}

package com.gathi.ddd.colab.domain;

import com.gathi.ddd.colab.domain.user.Author;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "discussion_id")
    private Discussion discussion;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private Author author;

    private String content;

    private Date date;

    public Post(Discussion discussion, Author author, String content) {
        this.discussion = discussion;
        this.author = author;
        this.content = content;
        date = new Date();
    }
}

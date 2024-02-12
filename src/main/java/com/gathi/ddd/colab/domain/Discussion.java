package com.gathi.ddd.colab.domain;


import com.gathi.ddd.colab.domain.user.Author;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Discussion {

    //use custom id generator and generate id before saving to the db
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;    //unique Id, to be generated in persisting changes

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "forum_id")  //forum_id colum is located in discussion table
    private Forum forum;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;

    private String topic;

    @OneToMany(
            mappedBy = "discussion",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private List<Post> posts;

    private boolean isActive;



    public Discussion(Forum forum, Author author, String topic) {
        this.forum = forum;
        this.author = author;
        this.topic = topic;
        this.isActive = true;
    }

    public Post newPost(Author author, String content) {
        Post post = new Post(this, author, content);
        posts.add(post);

        return post;
    }
}

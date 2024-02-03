package com.gathi.ddd.colab.domain;


import com.gathi.ddd.colab.domain.user.Author;
import com.gathi.ddd.colab.domain.user.Member;
import lombok.Data;

import java.util.List;

@Data
public class Discussion {

    private String forumId;
    private String id;    //unique Id, to be generated in persisting changes
    private Author author;
    private String topic;
    private boolean isActive;

    private List<Post> posts;

    public Discussion(String forumId, Author author, String topic) {
        this.forumId = forumId;
        this.author = author;
        this.topic = topic;
        this.isActive = true;
    }

    public Post newPost(String discussionId, Member member, String content) {
        Post post = new Post(discussionId, member, content);
        posts.add(post);

        return post;
    }
}

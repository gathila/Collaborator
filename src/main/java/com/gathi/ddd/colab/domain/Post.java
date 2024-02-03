package com.gathi.ddd.colab.domain;

import com.gathi.ddd.colab.domain.user.Member;
import lombok.Data;

import java.util.Date;

@Data
public class Post {

    private Integer id;
    private String discussionId;

    private Member member;
    private String content;

    private Date date;

    public Post(String discussionId, Member member, String content) {
        this.member = member;
        this.content = content;
        date = new Date();
    }
}

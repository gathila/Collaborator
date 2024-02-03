package com.gathi.ddd.colab.resource;


import com.gathi.ddd.colab.dto.ForumDTO;
import com.gathi.ddd.colab.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/forum")
public class ForumController {

    @Autowired
    private ForumService forumService;

    @PostMapping
    public void createNewForum(@RequestBody ForumDTO forum) {
        forumService.createNewForum(forum.getTopic(), forum.getDescription());
    }
}

package com.gathi.ddd.colab.service;

import com.gathi.ddd.colab.domain.Forum;
import com.gathi.ddd.colab.domain.repository.ForumRepository;
import com.gathi.ddd.colab.domain.user.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ForumServiceImpl implements ForumService {

    @Autowired
    private CollaboratorService collaboratorService;

    @Autowired
    private ForumRepository forumRepository;

    @Override
    public void createNewForum(String topic, String description) {
        Author author = collaboratorService.getCurrentUserAsAuthor();
        Forum forum = new Forum(author, topic, description);

        forumRepository.save(forum);
    }
}

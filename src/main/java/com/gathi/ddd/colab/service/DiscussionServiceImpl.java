package com.gathi.ddd.colab.service;

import com.gathi.ddd.colab.domain.Discussion;
import com.gathi.ddd.colab.domain.Forum;
import com.gathi.ddd.colab.domain.repository.ForumRepository;
import com.gathi.ddd.colab.domain.user.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DiscussionServiceImpl implements DiscussionService {

    @Autowired
    private ForumRepository forumRepository;

    @Autowired
    private CollaboratorService collaboratorService;

    @Override
    public void createDiscussion(Long forumId, String topic) {

        Author author = collaboratorService.getCurrentUserAsAuthor();

        Forum forum = getForumById(forumId);
        Discussion discussion = forum.startDiscussion(author, topic);

    }

    private Forum getForumById(Long forumId) {
        Optional<Forum> optionalForum = forumRepository.findById(forumId);
        return optionalForum.orElseThrow(() -> new IllegalStateException("Forum Id is not found in system"));
    }
}

package com.gathi.ddd.colab.service;

import com.gathi.ddd.colab.domain.user.Author;

public interface ForumService {

    void createNewForum(String topic, String description);
}

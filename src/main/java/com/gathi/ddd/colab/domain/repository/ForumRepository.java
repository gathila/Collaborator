package com.gathi.ddd.colab.domain.repository;

import com.gathi.ddd.colab.domain.Forum;

import java.util.Optional;

public interface ForumRepository {

    Optional<Forum> findById(Long id);

    void save(Forum forum);
}

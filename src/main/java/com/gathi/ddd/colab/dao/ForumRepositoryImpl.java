package com.gathi.ddd.colab.dao;

import com.gathi.ddd.colab.domain.Forum;
import com.gathi.ddd.colab.domain.repository.ForumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public class ForumRepositoryImpl implements ForumRepository {

    private final ForumDao forumDao;

    @Autowired
    public ForumRepositoryImpl(ForumDao forumDao) {
        this.forumDao = forumDao;
    }

    @Override
    public Optional<Forum> findById(Long id) {
        return forumDao.findById(id);
    }

    @Override
    public void save(Forum forum) {
        forumDao.save(forum);
    }
}

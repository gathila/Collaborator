package com.gathi.ddd.colab.dao;

import com.gathi.ddd.colab.domain.Forum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForumDao extends JpaRepository<Forum, Long> {

}

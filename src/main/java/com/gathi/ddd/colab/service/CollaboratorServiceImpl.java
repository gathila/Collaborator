package com.gathi.ddd.colab.service;

import com.gathi.ddd.colab.domain.user.Author;
import org.springframework.stereotype.Service;

@Service
public class CollaboratorServiceImpl implements CollaboratorService {

    @Override
    public Author getCurrentUserAsAuthor() {
        return null;
    }
}

package com.gathi.ddd.colab.service;

import com.gathi.ddd.colab.domain.user.Author;

public interface CollaboratorService {

    Author getCurrentUserAsAuthor();
}

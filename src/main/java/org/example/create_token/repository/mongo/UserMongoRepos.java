package org.example.create_token.repository.mongo;

import org.example.create_token.entity.UserMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository("mongoUserRepo")
public interface UserMongoRepos extends MongoRepository<UserMongo, String> {
    // craete queries
}

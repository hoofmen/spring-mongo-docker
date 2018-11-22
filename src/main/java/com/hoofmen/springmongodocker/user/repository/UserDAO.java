package com.hoofmen.springmongodocker.user.repository;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "users")
public class UserDAO {
    @Id
    private ObjectId id;
    private String name;
    private String email;
}

package org.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arangodb.ArangoDB;
import com.arangodb.ArangoDatabase;
import com.arangodb.entity.BaseDocument;

@RestController
public class HelloController {

    private static final String DB_NAME = "_system";
    private static final String COLLECTION = "users";

    private final ArangoDB arangoDB;

    public HelloController(ArangoDB arangoDB) {
        this.arangoDB = arangoDB;
    }

    @GetMapping("/hello")
    public String hello() {

        ArangoDatabase db = arangoDB.db("_system");

        StringBuilder usersSb = new StringBuilder();

        db.query("FOR u IN users RETURN u", BaseDocument.class)
                .forEachRemaining(doc -> {

                    User user = new User();
                    user.setKey(doc.getKey());
                    user.setName(String.valueOf(doc.getAttribute("name")));
                    Number age = (Number) doc.getAttribute("age");
                    if(age != null) {
                        user.setAge(age.intValue());
                    }

                    usersSb.append(user).append("\n");
                });

        return "Users:\n" + usersSb;
    }
}

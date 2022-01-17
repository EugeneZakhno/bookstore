package ru.intervale.courses.bookstore.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.IntNode;
import ru.intervale.courses.bookstore.entities.Book;

import java.io.IOException;



public class JsonDeserializer  extends StdDeserializer<String> {

    public JsonDeserializer() {
        this(null);
    }

    public JsonDeserializer(Class<?> vc) {
        super(vc);
    }

  //  @Override
  //  public String deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
  //          throws IOException  {
  //      return jsonParser.getText();
  //  }


    //https://www.baeldung.com/jackson-custom-serialization
    @Override
    public String deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);
        int id = (Integer) ((IntNode) node.get("id")).numberValue();
        String itemName = node.get("itemName").asText();
        int userId = (Integer) ((IntNode) node.get("createdBy")).numberValue();
        return new Book(id, itemName, new User(userId, null));
    }
}

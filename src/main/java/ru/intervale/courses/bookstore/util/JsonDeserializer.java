package ru.intervale.courses.bookstore.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import ru.intervale.courses.bookstore.entities.Book;

import java.io.IOException;
import java.math.BigDecimal;

public class JsonDeserializer  extends StdDeserializer<String> {

    public JsonDeserializer() {
        this(null);
    }

    public JsonDeserializer(Class<?> vc) {
        super(vc);
    }

 //   https://www.baeldung.com/jackson-deserialization
    @Override
    public Book deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);
        Long id = node.get("id").asLong();
        String isbn = node.get("isbn").asText();
        String name = node.get("name").asText();
        String author = node.get("author").asText();
        int pageNumber = (Integer) node.get("pageNumber").numberValue();
        double weight = (Double) node.get("weight").numberValue();
        BigDecimal price = node.get("price").decimalValue();
        return new Book(id, isbn, name, author, pageNumber, weight, price);
    }
}

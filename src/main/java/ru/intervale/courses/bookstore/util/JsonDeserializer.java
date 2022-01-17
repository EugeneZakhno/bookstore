package ru.intervale.courses.bookstore.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;



public class JsonDeserializer  extends StdDeserializer<String> {

    public JsonDeserializer() {
        this(null);
    }

    public JsonDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public String deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException  {
        return jsonParser.getText();
    }
}

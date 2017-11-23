package com.example;

import com.example.resource.greeting.GreetingRepresentation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class GreetingRepresentationTest {

    @Test
    public void testCreateRepresentation() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        GreetingRepresentation greeting = new GreetingRepresentation("Hello", "English", "England");
        assertEquals(greeting.toHAL().trim(), mapper.writeValueAsString(greeting).trim());
    }

    @Test
    public void testCreateJSONRepresentation() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        GreetingRepresentation greetingObj = new GreetingRepresentation("Hello", "English", "England");
        String json = greetingObj.toHAL();
        GreetingRepresentation greeting = mapper.readValue(json, GreetingRepresentation.class);
        assertEquals(json.trim(), greeting.toHAL().trim());
    }
}
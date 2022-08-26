package my.json;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

/**
 * @author liu peng bo
 * @date 2022-8-4 15:06
 */
public class Object2StrDeserialize extends JsonDeserializer<String> {
    @Override
    public String deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
       if(jsonParser!=null&&deserializationContext!=null&&jsonParser.getCurrentValue()!=null){
           return String.valueOf(jsonParser.getCurrentValue());
       }
       return null;
    }
}

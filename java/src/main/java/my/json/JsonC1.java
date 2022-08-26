package my.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import org.springframework.boot.jackson.JsonObjectDeserializer;

/**
 * @author liu peng bo
 * @date 2022-8-4 15:22
 */
@Data
public class JsonC1 {
    public String a;

    @JsonDeserialize(using = Object2StrDeserialize.class)
    public String b;

    public static void main(String[] args) throws JsonProcessingException {
        String a = "{\"a\":\"123\",\"b\":{\\\"a1\\\":\\\"a1\\\",\\\"a2\\\":\\\"a2\\\"}}";
        ObjectMapper objectMapper = new ObjectMapper();
        JsonC1 jsonC1 = objectMapper.readValue(a, JsonC1.class);
        System.out.println(1);
    }

    public static void m1() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        JsonC2 jsonC2 = new JsonC2();
        jsonC2.setA1("a1");
        jsonC2.setA2("a2");
        String c2 = objectMapper.writeValueAsString(jsonC2);

        JsonC1 jsonC1 = new JsonC1();
        jsonC1.setA("123");
        jsonC1.setB(c2);
        System.out.println(objectMapper.writeValueAsString(jsonC1));
    }
}

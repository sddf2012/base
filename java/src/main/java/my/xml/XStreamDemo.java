package my.xml;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liu peng bo
 * @date 2022-9-16 15:00
 */
@Data
@XStreamAlias("school")
class School {
    private String name;

    private String type;

    @XStreamAlias("teachers")
    private List<Teacher> teachers;
}

@Data
@XStreamAlias("teacher")
class Teacher {
    private String name;

    private Integer age;

    public Teacher(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}

public class XStreamDemo {
    public static void main(String[] args) {
        m1();
    }

    public static void m1() {
        Teacher teacher = new Teacher("t1", 30);
        Teacher teacher2 = new Teacher("t2", 31);
        List<Teacher> list = new ArrayList<>();
        list.add(teacher2);
        list.add(teacher);
        School school = new School();
        school.setName("学校");
        school.setType("1");
        school.setTeachers(list);
        XStream xStream = new XStream(new StaxDriver());
        xStream.autodetectAnnotations(true);
        //xStream.alias("school", School.class);
        String xml = xStream.toXML(school);
        System.out.println(xml);
    }

    public static void m2() {
        String xml = "<school>\n" +
                "  <name>学校</name>\n" +
                "  <type>1</type>\n" +
                "  <teachers>\n" +
                "    <teacher>\n" +
                "      <name>t2</name>\n" +
                "      <age>31</age>\n" +
                "    </teacher>\n" +
                "    <teacher>\n" +
                "      <name>t1</name>\n" +
                "      <age>30</age>\n" +
                "    </teacher>\n" +
                "  </teachers>\n" +
                "</school>";
        XStream xStream = new XStream();
        xStream.allowTypes(new Class[]{School.class, Teacher.class});
        xStream.autodetectAnnotations(true);
        xStream.alias("school", School.class);
        School school = (School) xStream.fromXML(xml);
        System.out.println(1);
    }
}

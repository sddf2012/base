package my.domain;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author liu peng bo
 * @date 2022/1/3 上午10:55
 */
public class Cat {
    public String name;

    public String sex;

    public int age;

    @XmlTransient
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @XmlTransient
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Cat() {
    }

    public Cat(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }
}

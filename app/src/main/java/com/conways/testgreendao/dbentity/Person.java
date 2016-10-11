package com.conways.testgreendao.dbentity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by John on 2016/10/11.
 */
@Entity
public class Person {

    @Id
    private Long id;

    private String name;

    private int age;

    private int sex;

    public int getSex() {
        return this.sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Generated(hash = 1134365971)
    public Person(Long id, String name, int age, int sex) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Generated(hash = 1024547259)
    public Person() {
    }
}

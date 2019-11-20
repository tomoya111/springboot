package com.how2java.springboot.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "category_")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private String name;
    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString(){
        return "Category [id=" + this.id + ", name=" + this.name + "]";
    }
}

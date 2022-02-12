package com.hashedin.hu22.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DemoEntity {
    @Id
    private long id;
    private String name;

    public DemoEntity() {
    }

    public DemoEntity(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

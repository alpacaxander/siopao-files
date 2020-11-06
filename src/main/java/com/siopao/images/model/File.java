package com.siopao.images.model;

import com.yahoo.elide.annotation.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Include(type = "file", rootLevel = true)
@Table(name = "file")
public class File {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "file_id")
    private UUID id;

    @NotNull
    private String name;

    @Lob
    @Column(length=100000)
    private String data;
}

package com.siopao.files.model;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.UUID;

@Data
@Accessors(fluent = true)
@Entity
public class File {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "file_id")
    private UUID id;

    @Lob
    @Column(length=100000)
    private String data;
}

package dev.ashish.EcomProductService.entity;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.UUID;

@MappedSuperclass
@Getter
public class BaseModel {
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private UUID id;

    @Column(name = "CREATED_AT")
    @CreationTimestamp
    private Instant createdAt;

    @Column(name = "UPDATED_AT")
    @UpdateTimestamp
    private Instant updatedAt;
}

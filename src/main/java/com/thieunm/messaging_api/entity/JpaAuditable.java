package com.thieunm.messaging_api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public abstract class JpaAuditable<U> {

    @CreatedDate
    @Column(name = "created_date", updatable = false)
    private Timestamp createdDate;

    @LastModifiedDate
    @Column(name = "last_modified_date", insertable = false)
    private Timestamp lastModifiedDate;

    @CreatedBy
    @Column(name = "created_by", updatable = false)
    private U createdBy;

    @LastModifiedBy
    @Column(name = "last_modified_by")
    private U lastModifiedBy;
}

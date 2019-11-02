package com.erdemakkuzu.issuemanagement.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

/**
 * Created by temelt on 3.02.2019.
 */
@Data
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "created_at")
  private Date createdAt;

  @Column(name = "created_by", length = 50)
  private String createdBy;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "updated_at")
  private Date updatedAt;

  @Column(name = "updated_by", length = 50)
  private String updatedBy;

  @Column(name = "status")
  private Boolean status;
}

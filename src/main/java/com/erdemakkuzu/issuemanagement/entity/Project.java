package com.erdemakkuzu.issuemanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.*;

/**
 * Created by temelt on 3.02.2019.
 */
@Entity
@Table(name = "project")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Project extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "project_name", length = 300)
  private String projectName;

  @Column(name = "project_code", length = 30)
  private String projectCode;

  @JoinColumn(name = "manager_user_id")
  @ManyToOne(optional = true, fetch = FetchType.LAZY)
  private User manager;
}

package com.erdemakkuzu.issuemanagement.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.*;

/**
 * Created by temelt on 3.02.2019.
 */
@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class User extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "uname", length = 100, unique = true)
  private String username;

  @Column(name = "pwd", length = 200)
  private String password;

  @Column(name = "name_surname", length = 200)
  private String nameSurname;

  @Column(name = "email", length = 100)
  private String email;

  @JoinColumn(name = "assignee_user_id")
  @OneToMany(fetch = FetchType.LAZY)
  private List<Issue> issues;
}

package com.erdemakkuzu.issuemanagement.dto;

import com.erdemakkuzu.issuemanagement.entity.IssueStatus;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by temelt on 4.02.2019.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IssueDto {

  @ApiModelProperty(value = "Issue ID")
  private Long id;
  @ApiModelProperty(required = true, value = "Issue Desctiption")
  private String description;
  private String details;
  @ApiModelProperty(required = true, value = "Issue Date")
  private Date date;
  private IssueStatus issueStatus;
  private UserDto assignee;
  private ProjectDto project;
}

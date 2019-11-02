package com.erdemakkuzu.issuemanagement.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by temelt on 4.02.2019.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Project data transfer object")
public class ProjectDto {

  @ApiModelProperty(value = "Project ID")
  private Long id;
  @NotNull
  @ApiModelProperty(required = true, value = "Name of project")
  private String projectName;
  @NotNull
  @ApiModelProperty(required = true, value = "Code of project")
  private String projectCode;
}

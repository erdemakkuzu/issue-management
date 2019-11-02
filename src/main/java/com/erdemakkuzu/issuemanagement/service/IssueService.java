package com.erdemakkuzu.issuemanagement.service;

import com.erdemakkuzu.issuemanagement.dto.IssueDto;
import com.erdemakkuzu.issuemanagement.util.TPage;
import org.springframework.data.domain.Pageable;

/**
 * Created by temelt on 4.02.2019.
 */
public interface IssueService {

  IssueDto save(IssueDto issue);

  IssueDto getById(Long id);

  TPage<IssueDto> getAllPageable(Pageable pageable);

  Boolean delete(Long issue);

  IssueDto update(Long id, IssueDto issue);
}

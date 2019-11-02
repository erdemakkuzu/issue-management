package com.erdemakkuzu.issuemanagement.service.impl;

import com.erdemakkuzu.issuemanagement.dto.IssueDto;
import com.erdemakkuzu.issuemanagement.entity.Issue;
import com.erdemakkuzu.issuemanagement.repository.IssueRepository;
import com.erdemakkuzu.issuemanagement.service.IssueService;
import com.erdemakkuzu.issuemanagement.util.TPage;
import java.util.Arrays;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by temelt on 4.02.2019.
 */
@Service
public class IssueServiceImpl implements IssueService {

  private final IssueRepository issueRepository;
  private final ModelMapper modelMapper;

  public IssueServiceImpl(IssueRepository issueRepository, ModelMapper modelMapper) {
    this.issueRepository = issueRepository;
    this.modelMapper = modelMapper;
  }

  @Override
  public IssueDto save(IssueDto issue) {
    // Bussiness Logic

    if (issue.getDate() == null) {
      throw new IllegalArgumentException("Issue Date cannot be null");
    }

    Issue issueEntity = modelMapper.map(issue, Issue.class);

    issueEntity = issueRepository.save(issueEntity);

    issue.setId(issueEntity.getId());
    return issue;
  }

  @Override
  public IssueDto getById(Long id) {
    Issue issue = issueRepository.getOne(id);
    return modelMapper.map(issue, IssueDto.class);
  }

  @Override
  public TPage<IssueDto> getAllPageable(Pageable pageable) {
    Page<Issue> data = issueRepository.findAll(pageable);
    TPage<IssueDto> respnose = new TPage<IssueDto>();
    respnose.setStat(data, Arrays.asList(modelMapper.map(data.getContent(), IssueDto[].class)));
    return respnose;
  }

  @Override
  public Boolean delete(Long issueId) {
    issueRepository.deleteById(issueId);
    return true;
  }


  @Override
  public IssueDto update(Long id, IssueDto issue) {
    return null;
  }

}

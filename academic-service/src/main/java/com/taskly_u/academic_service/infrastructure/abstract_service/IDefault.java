package com.taskly_u.academic_service.infrastructure.abstract_service;

import org.springframework.data.domain.Page;

import com.taskly_u.academic_service.utils.SortType;

public interface IDefault <RQ, RS, ID> {
    public RS create(RQ request);
    public RS getById(ID id);
    public RS update(RQ request, ID id);
    public void delete(ID id);
    public Page<RS> getAll(int page, int size, SortType sort);
}

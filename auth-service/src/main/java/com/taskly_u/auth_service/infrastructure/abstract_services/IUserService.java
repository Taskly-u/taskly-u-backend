package com.taskly_u.auth_service.infrastructure.abstract_services;


import org.springframework.data.domain.Page;

import com.taskly_u.auth_service.utils.SortType;

public interface IUserService <RQ, RS, ID>{
    public RS create(RQ request);
    public RS getById(ID id);
    public RS update(RQ request, ID id);
    public void delete(ID id);
    public Page<RS> getAll(int page, int size, SortType sort);

    public final String FIELD_BY_SORT = "fullName";
}

package com.taskly_u.auth_service.infrastructure.service;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.taskly_u.auth_service.api.dto.request.CreateUserRequest;
import com.taskly_u.auth_service.api.dto.response.UserResponse;
import com.taskly_u.auth_service.domain.entities.User;
import com.taskly_u.auth_service.domain.repositories.UserRepository;
import com.taskly_u.auth_service.infrastructure.abstract_services.IUserService;
import com.taskly_u.auth_service.utils.SortType;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService implements IUserService<CreateUserRequest, UserResponse, UUID>{

    private final UserRepository userRepository;

    @Override
    public UserResponse create(CreateUserRequest request) {
        User user = requestToEntity(request);
        return this.entityToResponse(this.userRepository.save(user));
    }

    @Override
    public UserResponse getById(UUID id) {
        User user = this.findById(id);
        return this.entityToResponse(user);
    }

    @Override
    public UserResponse update(CreateUserRequest request, UUID id) {
        User user = this.findById(id);
        User userUpdate = new User();
        if(user!=null){
            userUpdate = requestToEntity(request);
            userUpdate.setId(id);
            userUpdate.setCreatedAt(user.getCreatedAt());
        }
        return this.entityToResponse(this.userRepository.save(userUpdate));

    }

    @Override
    public void delete(UUID id) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Page<UserResponse> getAll(int page, int size, SortType sort) {
        if(page < 0) page = 0;
        PageRequest pagination = null;
        switch(sort){
            case NONE -> pagination = PageRequest.of(page, size);
            case ASC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).ascending());
            case DESC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).descending());
        }

        return this.userRepository.findAll(pagination).map(this::entityToResponse);
    }

    private User requestToEntity(CreateUserRequest request){
        return User.builder().
                fullName(request.getFullName())
                .email(request.getEmail())
                .password(request.getPassword())
                .semester(request.getSemester()).build();
    }

    private UserResponse entityToResponse(User entity){
        return UserResponse.builder().
                fullName(entity.getFullName())
                .email(entity.getEmail())
                .semester(entity.getSemester())
                .createdAt(entity.getCreatedAt()).build();
    }

    private User findById(UUID id){
        return this.userRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado" + id) );
    }

}

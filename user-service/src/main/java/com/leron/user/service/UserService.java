package com.leron.user.service;

import com.leron.user.dto.Department;
import com.leron.user.dto.ResponseTemplateDto;
import com.leron.user.model.User;
import com.leron.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restemplate;

    public User save(User user) {
        return  userRepository.save(user);
    }

    public User findUserById(Long userId) {
        return userRepository.findUserById(userId);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public ResponseTemplateDto getUserWithDepartment(Long id) {
        ResponseTemplateDto dto = new ResponseTemplateDto();
        User user = userRepository.findUserById(id);

        Department department = restemplate.getForObject("http://localhost:9000/departments/" + user.getDepartmentId(), Department.class);
        dto.setUser(user);
        dto.setDepartment(department);
        return dto;
    }
}

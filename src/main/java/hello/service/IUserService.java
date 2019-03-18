package hello.service;

import hello.model.User;

public interface IUserService {
    User findOne(Long id);
}

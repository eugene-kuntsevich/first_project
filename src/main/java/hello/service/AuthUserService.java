package hello.service;

import hello.data.UserRepository;
import hello.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthUserService implements IAuthUserService {

    private UserRepository userRepository;

    @Autowired
    public AuthUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean login(String name, String password) {
        User user = userRepository.findByName(name);

        return user.getName().equals(name) && user.getPassword().equals(password);
    }
}

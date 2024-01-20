package gdsc.community.service;

import gdsc.community.domain.User;
import gdsc.community.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserService {
    private UserRepository userRepository;

    void join(User user) {
        userRepository.save(user);
    }

    public List<User> findMembers() {
        return userRepository.findAll();
    }

}

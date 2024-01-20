package gdsc.community.repository;


import gdsc.community.domain.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentMap;

public interface UserRepository {
    User save(User user);
    List<User> findAll();
}

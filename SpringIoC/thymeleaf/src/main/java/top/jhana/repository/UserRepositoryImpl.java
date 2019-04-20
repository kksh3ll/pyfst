package top.jhana.repository;

import org.springframework.stereotype.Repository;
import top.jhana.domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private AtomicLong counter = new AtomicLong();
    private ConcurrentMap<Long, User> userMap = new ConcurrentHashMap<Long, User>();

    public User saveOrUpdateUser(User user) {
        Long id = user.getId();
        if (id == null) {
            id = counter.incrementAndGet();
            user.setId(id);
        }
        this.userMap.put(id, user);
        return user;
    }

    public void deleteUser(Long id) {
        userMap.remove(id);
    }

    public User getUserById(Long id) {
        User user = userMap.get(id);
        return user;
    }

    public List<User> userList() {
        return new ArrayList<User>(userMap.values());
    }
}

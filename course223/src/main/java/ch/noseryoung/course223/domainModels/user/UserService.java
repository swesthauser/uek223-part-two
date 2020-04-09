package ch.noseryoung.course223.domainModels.user;

import java.util.List;

public interface UserService {

    public List<User> getAllUsers();
    public User getUserById(String id);
    public User createNewUser (User user);
    public User updateUser (User user, String id);
    public User deleteUser(String id);

    public User getBestEarningUser();
    public User getWorstEarningUser();
    public List<User> allUsersWithEvenEarnings();
    public List<User> allUsersWithOddEarnings();
    public List<User> allUsersEarningMoreThan(int x);
    public List<User> allUsersEarningLessThan(int x);
    public List<User> allUsersEarningBetween(int x, int y);
}

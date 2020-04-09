package ch.noseryoung.course223.domainModels.salaryOperations;

import ch.noseryoung.course223.domainModels.user.User;

import java.util.List;

public interface SalaryOperationService {

    public User getBestEarningUser(List<User> usersList);
    public User getWorstEarningUser(List<User> usersList);
    public List<User> allUsersWithEvenEarnings(List<User> usersList);
    public List<User> allUsersWithOddEarnings(List<User> usersList);
    public List<User> allUsersEarningMoreThan(int x, List<User> userList);
    public List<User> allUsersEarningLessThan(int x, List<User> userList);
    public List<User> allUsersEarningBetween(int x, int y, List<User> userList);
}

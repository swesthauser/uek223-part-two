package ch.noseryoung.course223.domainModels.user;

import ch.noseryoung.course223.domainModels.salaryOperations.SalaryOperationService;
import ch.noseryoung.course223.domainModels.salaryOperations.SalaryOperationsSingleResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private SalaryOperationService salaryOperationService;


    @Autowired
    public UserServiceImpl(UserRepository userRepository, SalaryOperationService salaryOperationService) {
        this.userRepository = userRepository;
        this.salaryOperationService = salaryOperationService;
    }

    // Methoden für CRUD Logik
    @Override
    public List<User> getAllUsers() {
        List<User> usersList = userRepository.findAll();
        return usersList;
    }

    @Override
    public User getUserById(String id) {
        return findAllThrow(userRepository.findById(id));
    }

    @Override
    public User createNewUser(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public User updateUser(User user, String id) {
        findAllThrow(userRepository.findById(id));
        user.setUserId(id);
        userRepository.save(user);
        return user;
    }

    @Override
    public User deleteUser(String id) {
        userRepository.deleteById(id);
        return null;
    }

    // Lambda Aufgaben
    @Override
    public User getBestEarningUser() {
        //SalaryOperationsSingleResult bestEarningUser = (List<User> salaries) -> salaries.stream().sorted(Comparator.comparing(User::getSalary).reversed()).findFirst();
       //return findAllThrow(bestEarningUser.assessSalaries(userRepository.findAll()));
        List<User> usersList = userRepository.findAll();
        return salaryOperationService.getBestEarningUser(usersList);
    }

    @Override
    public User getWorstEarningUser() {
        //return findAllThrow(userRepository.findAll().stream().sorted(Comparator.comparing(User::getSalary)).findFirst());
        List<User> usersList = userRepository.findAll();
        return salaryOperationService.getWorstEarningUser(usersList);
    }

    @Override
    public List<User> allUsersWithEvenEarnings() {
        //return userRepository.findAll().stream().filter(user -> user.getSalary() % 2 == 0).collect(Collectors.toList());
        List<User> usersList = userRepository.findAll();
        return salaryOperationService.allUsersWithEvenEarnings(usersList);
    }

    @Override
    public List<User> allUsersWithOddEarnings() {
        List<User> usersList = userRepository.findAll();
        return salaryOperationService.allUsersWithOddEarnings(usersList); // To be implemented
    }

    @Override
    public List<User> allUsersEarningMoreThan(int x) {
        List<User> usersList = userRepository.findAll();
        return salaryOperationService.allUsersEarningMoreThan(x, usersList); // To be implemented
    }

    @Override
    public List<User> allUsersEarningLessThan(int x) {
        List<User> usersList = userRepository.findAll();
        return salaryOperationService.allUsersEarningLessThan(x, usersList); // To be implemented
    }

    @Override
    public List<User> allUsersEarningBetween(int x, int y) {
        List<User> usersList = userRepository.findAll();
        return salaryOperationService.allUsersEarningBetween(x, y, usersList); // To be implemented
    }

    // Methode if no value is present
    private User findAllThrow (Optional<User> optional) throws NoSuchElementException {
        if(optional.isPresent()){
            return optional.get();
        } else throw new NoSuchElementException("No value present");
    }


    // Question to be solved: What is a more ideal way of retrieving above values? Native Query
}


package ch.noseryoung.course223.domainModels.salaryOperations;

import ch.noseryoung.course223.domainModels.user.User;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;



@Service
public class SalaryOperationsHandler implements SalaryOperationService{


    // anstatt Integer --> user List
    //SalaryOperationsSingleResult sortedSalaries = (List<Integer> salaries) -> salaries.stream().sorted().collect(Collectors.toList());
    //SalaryOperationsSingleResult highestSalary = (List<Integer> salaries) -> salaries.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    // SalaryOperationsSingleResult allUsersEarningAverage  = (List<user> salaries) -> salaries.stream().collect(Collectors.averagingDouble(user -> Double.parseDouble(user)));
    //SalaryOperationsMultipleResults allUsersEarningAboveAverage = (List<user> salaries) -> salaries.stream().collect(Collectors.averagingDouble(user -> ));


    // Korrekte methoden:
    // SalaryOperationsSingleResult bestEarningUser = (List<User> salaries) -> salaries.stream().sorted(Comparator.comparing(User::getSalary).reversed()).findFirst();
    // SalaryOperationsSingleResult worstEarningUser = (List<User> salaries) -> salaries.stream().sorted(Comparator.comparing(User::getSalary)).findFirst();
    //SalaryOperationsMultipleResults allUsersWithEvenEarnings = (List<User> users) -> users.stream().filter(user -> user.getSalary() % 2 == 0).collect(Collectors.toList());
    //SalaryOperationsMultipleResults allUsersWithOddEarnings = (List<User> users) -> users.stream().filter(user -> user.getSalary() % 2 != 0).collect(Collectors.toList());
    //SalaryOperationsMultipleResults allUsersEarningMoreThan2000 = (List<User> salaries) -> salaries.stream().filter(user -> user.getSalary() > 2000).collect(Collectors.toList());
   // SalaryOperationsMultipleResults allUsersEarningLessThan2000 = (List<User> salaries) -> salaries.stream().filter(user -> user.getSalary() < 2000).collect(Collectors.toList());
    //SalaryOperationsMultipleResults allUsersEarningBetween2000And3000 = (List<User> salaries) -> salaries.stream().filter(user -> user.getSalary() > 2000 && user.getSalary() < 3000).collect(Collectors.toList());



    // sorted list asc and desc
    public Optional<User> assessSalaries(List<User> salaries, SalaryOperationsSingleResult salaryOperationsSingleResult){
        return salaryOperationsSingleResult.assessSalaries(salaries);
    }

    @Override
    public User getBestEarningUser(List<User> userList) {
        SalaryOperationsSingleResult bestEarningUser = (List<User> salaries) -> salaries.stream().sorted(Comparator.comparing(User::getSalary).reversed()).findFirst();
        return findAllThrow(bestEarningUser.assessSalaries(userList));
    }


    @Override
    public User getWorstEarningUser(List<User> userList) {
        SalaryOperationsSingleResult worstEarningUser = (List<User> salaries) -> salaries.stream().sorted(Comparator.comparing(User::getSalary)).findFirst();
        return findAllThrow(worstEarningUser.assessSalaries(userList));
    }

    @Override
    public List<User> allUsersWithEvenEarnings(List<User> userList) {
        SalaryOperationsMultipleResults allUsersWithEvenEarnings = (List<User> users) -> users.stream().filter(user -> user.getSalary() % 2 == 0).collect(Collectors.toList());
        return allUsersWithEvenEarnings.assessSalaries(userList);
    }

    @Override
    public List<User> allUsersWithOddEarnings(List<User> userList) {
        SalaryOperationsMultipleResults allUsersWithOddEarnings = (List<User> users) -> users.stream().filter(user -> user.getSalary() % 2 != 0).collect(Collectors.toList());
        return allUsersWithOddEarnings.assessSalaries(userList);
    }

    @Override
    public List<User> allUsersEarningMoreThan(int x,List<User> userList) {
        SalaryOperationsMultipleResults allUsersEarningMoreThanX = (List<User> salaries) -> salaries.stream().filter(user -> user.getSalary() > x).collect(Collectors.toList());
        return allUsersEarningMoreThanX.assessSalaries(userList);
    }

    @Override
    public List<User> allUsersEarningLessThan(int x, List<User> userList) {
        SalaryOperationsMultipleResults allUsersEarningLessThanX = (List<User> salaries) -> salaries.stream().filter(user -> user.getSalary() < x).collect(Collectors.toList());
        return allUsersEarningLessThanX.assessSalaries(userList);
    }

    @Override
    public List<User> allUsersEarningBetween(int x, int y, List<User> userList) {
        SalaryOperationsMultipleResults allUsersEarningBetweenXAndY = (List<User> salaries) -> salaries.stream().filter(user -> user.getSalary() > x && user.getSalary() < y).collect(Collectors.toList());
        return allUsersEarningBetweenXAndY.assessSalaries(userList);
    }

    // Methode if no value is present
    private User findAllThrow (Optional<User> optional) throws NoSuchElementException {
        if(optional.isPresent()){
            return optional.get();
        } else throw new NoSuchElementException("No value present");
    }
}

package ch.noseryoung.course223.domainModels.salaryOperations;

import ch.noseryoung.course223.domainModels.user.User;

import java.util.List;

@FunctionalInterface
public interface SalaryOperationsMultipleResults {
    List<User> assessSalaries(List<User> userList);
}

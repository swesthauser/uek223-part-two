package ch.noseryoung.course223.domainModels.salaryOperations;

import ch.noseryoung.course223.domainModels.user.User;

import java.util.List;
import java.util.Optional;

@FunctionalInterface
public interface SalaryOperationsSingleResult {
    Optional<User> assessSalaries(List<User> userList);
}

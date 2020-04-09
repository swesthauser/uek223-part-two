package ch.noseryoung.course223.domainModels.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //GET
    @GetMapping("")
    public @ResponseBody
    ResponseEntity<List<User>> getAll(){
        return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK);
    }

    //GET by id
    @GetMapping("/{id}")
    public @ResponseBody
    ResponseEntity<User> getById(@PathVariable String id){
        return new ResponseEntity<User>(userService.getUserById(id), HttpStatus.OK);
    }

    //POST
    @PostMapping("")
    public @ResponseBody
    ResponseEntity<User> create(@RequestBody User user) {
        return new ResponseEntity<User>(userService.createNewUser(user), HttpStatus.CREATED);
    }

    //PUT
    @PutMapping("/{id}")
    public @ResponseBody
    ResponseEntity<User> update(@RequestBody User user, @PathVariable String id){
        return new ResponseEntity<User>(userService.updateUser(user, id), HttpStatus.OK);
    }

    //DELETE
    @DeleteMapping("/{id}")
    public @ResponseBody
    ResponseEntity<User> delete(@PathVariable String id){
        return new ResponseEntity<User>(userService.deleteUser(id), HttpStatus.NO_CONTENT);
    }


    @GetMapping("/bestEarningUser")
    public @ResponseBody
    ResponseEntity<User> getBestEarningUser(){
        return new ResponseEntity<User>(userService.getBestEarningUser(), HttpStatus.OK);
    }


    @GetMapping("/getWorstEarningUser")
    public @ResponseBody
    ResponseEntity<User> getWorstEarningUser(){
        return new ResponseEntity<User>(userService.getWorstEarningUser(), HttpStatus.OK);
    }

    @GetMapping("/allUsersWithEvenEarnings")
    public @ResponseBody
    ResponseEntity<List<User>> allUsersWithEvenEarnings(){
        return new ResponseEntity<List<User>>(userService.allUsersWithEvenEarnings(), HttpStatus.OK);
    }

    @GetMapping("/allUsersWithOddEarnings")
    public @ResponseBody
    ResponseEntity<List<User>> allUsersWithOddEarnings(){
        return new ResponseEntity<List<User>>(userService.allUsersWithOddEarnings(), HttpStatus.OK);
    }

    @GetMapping("/allUsersEarningMoreThan/{x}")
    public @ResponseBody
    ResponseEntity<List<User>> allUsersEarningMoreThan(@PathVariable int x){
        return new ResponseEntity<List<User>>(userService.allUsersEarningMoreThan(x), HttpStatus.OK);
    }

    @GetMapping("/allUsersEarningLessThan/{x}")
    public @ResponseBody
    ResponseEntity<List<User>> allUsersEarningLessThan(@PathVariable int x){
        return new ResponseEntity<List<User>>(userService.allUsersEarningLessThan(x), HttpStatus.OK);
    }

    @GetMapping("/allUsersEarningBetween/{x}/{y}")
    public @ResponseBody
    ResponseEntity<List<User>> allUsersEarningBetween(@PathVariable int x, @PathVariable int y){
        return new ResponseEntity<List<User>>(userService.allUsersEarningBetween(x,y), HttpStatus.OK);
    }

}

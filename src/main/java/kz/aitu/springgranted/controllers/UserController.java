package kz.aitu.springgranted.controllers;

import kz.aitu.springgranted.models.SubjectScore;
import kz.aitu.springgranted.models.User;
import kz.aitu.springgranted.services.interfaces.ISubjectScoreService;
import kz.aitu.springgranted.services.interfaces.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    private final IUserService userService;
    private final ISubjectScoreService subjectScoreService;

    public UserController(IUserService userService, ISubjectScoreService subjectScoreService) {
        this.userService = userService;
        this.subjectScoreService = subjectScoreService;
    }

    @GetMapping("/")
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{user_id}")
    public ResponseEntity<User> getById(@PathVariable("user_id") int id) {
        User user = userService.getById(id);

        if (user == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("{user_id}/scores")
    public ResponseEntity<List<SubjectScore>> getSubjectScoresOfUser(@PathVariable("user_id") int id) {
        User user = userService.getById(id);

        if (user == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        List<Integer> subjectScoreIds = user.getSubjectScoreIds();
        List<SubjectScore> subjectScores = subjectScoreService.getByIds(subjectScoreIds);

        return new ResponseEntity<>(subjectScores, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<User> create(@RequestBody User user) {
        User createdUser = userService.create(user);

        if (createdUser == null)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
}

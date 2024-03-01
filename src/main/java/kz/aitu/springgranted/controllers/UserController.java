package kz.aitu.springgranted.controllers;

import kz.aitu.springgranted.models.Program;
import kz.aitu.springgranted.models.SubjectScore;
import kz.aitu.springgranted.models.User;
import kz.aitu.springgranted.services.interfaces.IProgramService;
import kz.aitu.springgranted.services.interfaces.ISubjectScoreService;
import kz.aitu.springgranted.services.interfaces.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("users")
public class UserController {
    private final IUserService userService;
    private final ISubjectScoreService subjectScoreService;
    private final IProgramService programService;

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

    @GetMapping("{user_id}/subjectscores")
    public ResponseEntity<List<SubjectScore>> getSubjectScoresOfUser(@PathVariable("user_id") int id) {
        User user = userService.getById(id);

        if (user == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        List<Integer> subjectScoreIds = user.getSubjectScoreIds();
        // Get all subject scores that belong to user
        List<SubjectScore> subjectScores = subjectScoreService.getByIds(subjectScoreIds);

        return new ResponseEntity<>(subjectScores, HttpStatus.OK);
    }

    @GetMapping("{user_id}/totalscore")
    public ResponseEntity<Integer> getTotalScoreOfUser(@PathVariable("user_id") int id) {
        User user = userService.getById(id);

        if (user == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        // Get all subject scores that belong to user
        List<SubjectScore> subjectScores = subjectScoreService.getByIds(user.getSubjectScoreIds());
        int totalScore = subjectScoreService.getTotalScore(subjectScores);

        return new ResponseEntity<>(totalScore, HttpStatus.OK);
    }

    @GetMapping("{user_id}/availableprograms")
    public ResponseEntity<List<Program>> getProgramsForUser(@PathVariable("user_id") int id) {
        User user = userService.getById(id);

        if (user == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        // Check if number of subject scores is valid
        if (user.getSubjectScoreIds().size() != 5)
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);

        // Get all subject scores that belong to user
        List<SubjectScore> subjectScores = subjectScoreService.getByIds(user.getSubjectScoreIds());

        // String array for elective subject names
        String[] userElectiveNames = new String[]{
                subjectScores.get(3).getSubject(),
                subjectScores.get(4).getSubject()
        };
        // To have the same array regardless of how user orders strings
        Arrays.sort(userElectiveNames);

        int totalScore = subjectScoreService.getTotalScore(subjectScores);

        return new ResponseEntity<>(
                programService.getProgramsForUser(userElectiveNames, totalScore),
                HttpStatus.OK
        );
    }

    @PostMapping("/")
    public ResponseEntity<User> create(@RequestBody User user) {
        User createdUser = userService.create(user);

        if (createdUser == null)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PutMapping("{user_id}/add/subjectscore")
    public ResponseEntity<User> addSubjectScoreToUser(
            @RequestBody SubjectScore subjectScore,
            @PathVariable("user_id") int id
    ) {
        User user = userService.getById(id);

        if (user == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        // Check if possible to add subject score
        if (user.getSubjectScoreIds().size() + 1 > 5)
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);

        SubjectScore createdSubjectScore = subjectScoreService.create(subjectScore);

        if (createdSubjectScore == null)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        userService.addSubjectScoreToUser(createdSubjectScore, user);

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PutMapping("{user_id}/add/subjectscores")
    public ResponseEntity<User> addSubjectScoresToUser(
            @RequestBody List<SubjectScore> subjectScores,
            @PathVariable("user_id") int id
    ) {
        User user = userService.getById(id);

        if (user == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        // Check if possible to add subject scores
        if (user.getSubjectScoreIds().size() + subjectScores.size() > 5)
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);

        List<SubjectScore> createdSubjectScores = subjectScoreService.createAll(subjectScores);

        userService.addSubjectScoresToUser(createdSubjectScores, user);

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}

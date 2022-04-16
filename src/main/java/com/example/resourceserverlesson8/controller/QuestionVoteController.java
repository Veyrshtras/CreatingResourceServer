package com.example.resourceserverlesson8.controller;

import com.example.resourceserverlesson8.service.QuestionVoteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("api/s2/question-vote")
public class QuestionVoteController {

    private final QuestionVoteService questionVoteService;

    public QuestionVoteController(QuestionVoteService questionVoteService) {
        this.questionVoteService = questionVoteService;
    }


    @PutMapping("{id}/up")
    public ResponseEntity upVote(@PathVariable Long id, Principal username){

        return ResponseEntity.ok(questionVoteService.upVote(id, username.getName() ));
    }

    @PutMapping("{id}/down")
    public ResponseEntity downVote(@PathVariable Long id, Principal username){

        return ResponseEntity.ok(questionVoteService.downVote(id, username.getName() ));
    }

    @PutMapping("{id}/revert")
    public ResponseEntity revertVote(@PathVariable Long id, Principal username){

        return ResponseEntity.ok(questionVoteService.revertVote(id, username.getName() ));
    }
}

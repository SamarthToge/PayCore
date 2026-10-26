package com.SamarthToge.PayCore.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/goals")
public class GoalsController {

    @PostMapping
    public ResponseEntity<Goals> createGoal(){
        return ;
    }
}

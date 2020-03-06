package com.spring5.practice.controllers;

import com.spring5.practice.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MemberRestController{

    private final MemberService memberService;

    public MemberRestController(MemberService memberService) {
        this.memberService = memberService;
    }


    @GetMapping(value = "/member/search")
    public ResponseEntity<?> searchMemberByName(@RequestParam(name = "query") String query) {
        var data = memberService.findByName(query);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
package com.members.list.controller;

import com.members.list.dto.MemberDTO;
import com.members.list.pojo.Member;
import com.members.list.service.MemberService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Component
@ConfigurationProperties
@RestController
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberService memberService;


    @RequestMapping(value = "/", method = RequestMethod.GET,produces={"application/json","application/xml"},
            consumes={"application/json","application/xml"})
    public ResponseEntity getAllMembers() {
        return new ResponseEntity(memberService.getAllMembers(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET,produces={"application/json","application/xml"},
            consumes={"application/json","application/xml"})
    public ResponseEntity getMemberById(@PathVariable("id") String id) {
        return new ResponseEntity(memberService.getMemberById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST,produces={"application/json","application/xml"},
            consumes={"application/json","application/xml"})
    public ResponseEntity createMember(@RequestBody @Valid MemberDTO memberDTO) {
        return new ResponseEntity(memberService.createMember(memberDTO), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT,produces={"application/json","application/xml"},
            consumes={"application/json","application/xml"})
    public ResponseEntity modifyMemberById(@PathVariable("id") String id, @Valid
    @RequestBody MemberDTO memberDTO) {
        return new ResponseEntity(memberService.modifyMemberById(id, memberDTO), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE,produces={"application/json","application/xml"},
            consumes={"application/json","application/xml"})
    public void deleteMemberById(@PathVariable String id) {
        memberService.deleteMemberById(id);
    }




}
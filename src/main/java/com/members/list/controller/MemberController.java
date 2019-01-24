package com.members.list.controller;

import com.members.list.pojo.Member;
import com.members.list.repository.MemberRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Component
@ConfigurationProperties
@RestController
//@RequestMapping("/")
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    @RequestMapping("/")
    public String index() {
        return "Index test";
    }

    @RequestMapping(value = "/members/", method = RequestMethod.GET)
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @RequestMapping(value = "/members/{id}", method = RequestMethod.GET)
    public Optional<Member> getMemberById(@PathVariable("id") ObjectId id) {
        return memberRepository.findById(id.toString());
//        return memberRepository.findBy_id(id);
    }

    @RequestMapping(value = "/members/", method = RequestMethod.POST)
    public Member createMember(@Valid @RequestBody Member member) {
        member.set_id(ObjectId.get().toString());
        memberRepository.save(member);
        return member;
    }

    @RequestMapping(value = "/members/{id}", method = RequestMethod.PUT)
    public void modifyMemberById(@PathVariable("id") String id, @Valid
    @RequestBody Member member) {
        member.set_id(id);
        memberRepository.save(member);
    }

    @RequestMapping(value = "/members/{id}", method = RequestMethod.DELETE)
    public void deleteMemberById(@PathVariable ObjectId id) {
        memberRepository.deleteById(id.toString());
    }



}
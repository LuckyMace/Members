package com.members.list.repository;

import java.util.List;

import com.members.list.pojo.Member;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface MemberRepository extends MongoRepository<Member, String> {

//    public Member findBy_id(ObjectId _id);
//
//    public Member findByFirstName(String firstName);
//    public List<Member> findByLastName(String lastName);


}

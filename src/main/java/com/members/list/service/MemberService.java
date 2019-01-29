package com.members.list.service;

import com.members.list.dto.MemberDTO;
import com.members.list.pojo.Member;
import com.members.list.repository.MemberRepository;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.model.GridFSFile;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private GridFsTemplate gridFsTemplate;

    public List<MemberDTO> getAllMembers() {
        List<Member> members = memberRepository.findAll();
        List<MemberDTO> memberDTOs = new ArrayList<>();
        for (Member member: members) {
            memberDTOs.add(convertMemberToMemberDTO(member));
        }

        return memberDTOs;
    }

    public MemberDTO getMemberById(String id){
        Optional<Member> member = memberRepository.findById(id);
        MemberDTO memberDTO = convertMemberToMemberDTO(member.get());

        return memberDTO;
    }

    public MemberDTO createMember(MemberDTO memberDTO) {
        Member member = convertMemberDTOToMember(memberDTO);
        member.set_id(ObjectId.get().toString());

        memberRepository.save(member);

        return convertMemberToMemberDTO(member);
    }

    public MemberDTO modifyMemberById(String id, MemberDTO memberDTO) {
        Member member = convertMemberDTOToMember(memberDTO);
        member.set_id(id);

        memberRepository.save(member);

        return convertMemberToMemberDTO(member);
    }

    public void deleteMemberById(String id) {
        memberRepository.deleteById(id);
    }





    private Member convertMemberDTOToMember(MemberDTO memberDTO) {
        Member member = new Member();

        member.set_id(memberDTO.get_id());
        member.setFirstName(memberDTO.getFirstName());
        member.setLastName(memberDTO.getLastName());
        member.setDateOfBirth(memberDTO.getDateOfBirth());
        member.setPostalCode(memberDTO.getPostalCode());

        String pictureLink = memberDTO.getPictureLink();
        if (pictureLink != null && !pictureLink.isEmpty()) {
            String pictureName = pictureLink.lastIndexOf("/") != -1 ? pictureLink.substring(pictureLink.lastIndexOf("/") + 1) : pictureLink;
            String pictureExtension = pictureName.lastIndexOf(".") != -1 ? pictureName.substring(pictureName.lastIndexOf(".") + 1) : "png";
            try {
                DBObject metaData = new BasicDBObject();
                metaData.put("link", pictureLink);
                InputStream inputStream = new FileInputStream(pictureLink);
                String pictureId = gridFsTemplate.store(inputStream, pictureName, "image/" + pictureExtension, metaData).toString();
                member.setPictureId(pictureId);
            } catch (FileNotFoundException e) {
                System.out.println("File not found by link: " + pictureLink);
            }
        }

        return member;
    }

    private MemberDTO convertMemberToMemberDTO(Member member) {
        MemberDTO memberDTO = new MemberDTO();

        memberDTO.set_id(member.get_id());
        memberDTO.setFirstName(member.getFirstName());
        memberDTO.setLastName(member.getLastName());
        memberDTO.setDateOfBirth(member.getDateOfBirth());
        memberDTO.setPostalCode(member.getPostalCode());

        String pictureId = member.getPictureId();
        if (pictureId != null && !pictureId.isEmpty()) {
            try {
                GridFSFile imageFile = gridFsTemplate.findOne(new Query(Criteria.where("_id").is(pictureId)));

                String pictureLink = imageFile.getMetadata().get("link").toString();
                memberDTO.setPictureLink(pictureLink);
            } catch (Exception e) {
                System.out.println("No link value in metadata for pictureId = " + pictureId);
            }
        }

        return memberDTO;
    }

}

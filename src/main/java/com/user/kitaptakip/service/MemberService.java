package com.user.kitaptakip.service;

import com.user.kitaptakip.entity.Member;
import com.user.kitaptakip.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;


    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }


    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }


    public Member getMemberById(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Üye bulunamadı. ID: " + id));
    }

    public Member updateMember(Long id, Member updatedMember) {
        Member existingMember = memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Üye bulunamadı!"));

        existingMember.setFirstName(updatedMember.getFirstName());
        existingMember.setLastName(updatedMember.getLastName());
        existingMember.setEmail(updatedMember.getEmail());
        existingMember.setPhone(updatedMember.getPhone());

        return memberRepository.save(existingMember);
    }

    public void deleteMember(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Üye bulunamadı!"));

        memberRepository.delete(member);
    }
}
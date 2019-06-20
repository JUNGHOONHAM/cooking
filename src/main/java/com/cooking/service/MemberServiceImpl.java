package com.cooking.service;

import com.cooking.model.dao.MemberDAO;
import com.cooking.model.dto.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    MemberDAO memberDao;

    @Override
    public List<MemberDTO> memberList() {
        return memberDao.memberList();
    }

    @Override
    public void insertMember(MemberDTO dto) {
        memberDao.insertMember(dto);
    }

    @Override
    public MemberDTO viewMember(String idx) {
        return memberDao.viewMember(idx);
    }

    @Override
    public void updateMember(MemberDTO dto) {

    }

    @Override
    public MemberDTO loginCheck(MemberDTO dto, HttpSession session) {
        MemberDTO member = memberDao.loginCheck(dto);

        if(member != null) {
            session.setAttribute("member", member);
        }

        return member;
    }

    @Override
    public void logout(HttpSession session) {
        session.invalidate();
    }
}

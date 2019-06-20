package com.cooking.service;

import com.cooking.model.dto.MemberDTO;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface MemberService {
    public List<MemberDTO> memberList();
    public void insertMember(MemberDTO dto);
    public MemberDTO viewMember(String idx);
    public void updateMember(MemberDTO dto);
    public MemberDTO loginCheck(MemberDTO dto, HttpSession session);
    public void logout(HttpSession session);
}

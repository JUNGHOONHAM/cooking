package com.cooking.model.dao;

import com.cooking.model.dto.MemberDTO;

import java.util.List;

public interface MemberDAO {
    public List<MemberDTO> memberList();
    public void insertMember(MemberDTO vo);
    public MemberDTO viewMember(String idx);
    public void updateMember(MemberDTO vo);
    public MemberDTO loginCheck(MemberDTO dto);
}

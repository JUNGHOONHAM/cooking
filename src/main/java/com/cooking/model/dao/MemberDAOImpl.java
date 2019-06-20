package com.cooking.model.dao;

import com.cooking.model.dto.MemberDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemberDAOImpl implements MemberDAO {
    @Autowired
    SqlSession sqlSession;

    @Override
    public List<MemberDTO> memberList() {
        return sqlSession.selectList("member.memberList");
    }

    @Override
    public void insertMember(MemberDTO vo) {
        sqlSession.insert("member.insertMember", vo);
    }

    @Override
    public MemberDTO viewMember(String idx) {
        return sqlSession.selectOne("member.viewMember", idx);
    }

    @Override
    public void updateMember(MemberDTO vo) {

    }

    @Override
    public MemberDTO loginCheck(MemberDTO dto) {
        return sqlSession.selectOne("member.loginCheck", dto);
    }
}

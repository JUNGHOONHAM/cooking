package com.cooking.controller;

import com.cooking.model.dto.MemberDTO;
import com.cooking.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MemberController {
    @Autowired
    MemberService memberService;

    @RequestMapping("member/list")
    public ModelAndView memberList() {
        ModelAndView mv = new ModelAndView();
        List<MemberDTO> list = memberService.memberList();

        mv.addObject("list", list);
        mv.setViewName("member/member_list");

        return mv;
    }

    @RequestMapping("member/join")
    public String join() {
        return "member/join";
    }

    @RequestMapping("member/login")
    public String login() {
        return "member/login";
    }

    @RequestMapping("member/insert")
    public String insert(MemberDTO dto) {
        memberService.insertMember(dto);
        return "redirect:list";
    }

    @RequestMapping("member/view")
    public ModelAndView view(@RequestParam String idx, Model model) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("dto", memberService.viewMember(idx));
        mv.setViewName("member/member_info");
        return mv;
    }

    @RequestMapping("member/loginCheck")
    public ModelAndView loginCheck(@ModelAttribute MemberDTO dto, HttpSession session) {
        MemberDTO member = memberService.loginCheck(dto, session);
        ModelAndView mv = new ModelAndView();

        if(member != null) {
            mv.setViewName("redirect:/");
        } else {
            mv.setViewName("member/login");
            mv.addObject("error", "error");
        }

        return mv;
    }

    @RequestMapping("member/logout")
    public ModelAndView logout(HttpSession session, ModelAndView mv) {
        memberService.logout(session);
        mv.setViewName("redirect:/");

        return mv;
    }
}

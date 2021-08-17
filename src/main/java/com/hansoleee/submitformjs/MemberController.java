package com.hansoleee.submitformjs;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;

    @GetMapping()
    public String list(HttpServletRequest request,
                       Model model) {
        log.info(request.getRequestURL().toString() + " " + request.getMethod());

        List<Member> members = memberRepository.findAll();
        model.addAttribute("members", members);

        return "member/members";
    }

    @GetMapping("/{id}")
    public String one(@PathVariable(value = "id") Long id,
                      HttpServletRequest request,
                      Model model) {
        log.info(request.getRequestURL().toString() + " " + request.getMethod() + " id: {}", id);

        Member member = memberRepository.findById(id).orElseThrow(() -> new MemberNotFound("Member[" + id + "]를 찾을 수 없습니다."));
        model.addAttribute("member", member);

        return "member/one";
    }

    @GetMapping("/new")
    public String create(HttpServletRequest request) {
        log.info(request.getRequestURL().toString() + " " + request.getMethod());
        return "member/new";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute MemberSaveDto memberSaveDto,
                         HttpServletRequest request,
                         RedirectAttributes redirectAttributes) {
        log.info(request.getRequestURL().toString() + " " + request.getMethod() + " memberSaveDto: {}", memberSaveDto);

        Member member = memberRepository.save(memberSaveDto.toEntity());

        redirectAttributes.addAttribute("id", member.getId());
        return "redirect:/members/{id}";
    }

    @GetMapping("/{id}/edit")
    public String edit(HttpServletRequest request) {
        log.info(request.getRequestURL().toString() + " " + request.getMethod());
        return "member/new";
    }

    @PostMapping("/{id}/edit")
    public String edit(@ModelAttribute MemberEditDto memberEditDto,
                       HttpServletRequest request) {
        log.info(request.getRequestURL().toString() + " " + request.getMethod() + " memberEditDto: {}", memberEditDto);

        return "redirect:/members/{id}";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id,
                         HttpServletRequest request) {
        log.info(request.getRequestURL().toString() + " " + request.getMethod() + " id: {}", id);

        memberRepository.deleteById(id);

        return "redirect:/members";
    }

    @Data
    static class MemberEditDto {

        private long id;
        @NotBlank
        private String name;
        private int age;
    }
}

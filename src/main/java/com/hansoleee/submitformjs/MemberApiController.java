package com.hansoleee.submitformjs;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberRepository memberRepository;

    @PostMapping("/new")
    public RestResponse create(@Valid @RequestBody MemberSaveDto memberSaveDto,
                                       HttpServletRequest request) {
        log.info(request.getRequestURL().toString() + " " + request.getMethod() + " memberSaveDto: {}", memberSaveDto);

        Member member = memberRepository.save(memberSaveDto.toEntity());

        return new RestResponse(true, "등록했습니다.", member.getId());
    }
}

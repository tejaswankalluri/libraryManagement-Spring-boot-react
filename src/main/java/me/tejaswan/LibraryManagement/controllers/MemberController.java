package me.tejaswan.LibraryManagement.controllers;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import me.tejaswan.LibraryManagement.entities.Member;
import me.tejaswan.LibraryManagement.exceptions.common.NotFoundException;
import me.tejaswan.LibraryManagement.services.MemberService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Api(tags = "Member")
@RestController
@RequestMapping("/api/v1/member")
@AllArgsConstructor
public class MemberController {
    private MemberService service;

    @GetMapping
    public List<Member> getMembers(@RequestParam(required = false) UUID id) throws NotFoundException {
        if (id != null) {
            return Collections.singletonList(service.MemberById(id));
        }
        return service.allMembers();
    }

    @GetMapping("/count")
    public ResponseEntity<Map<String, Long>> countMembers() {
        Map<String, Long> Res = new HashMap<>();
        Long count = service.countMember();
        Res.put("count", count);
        return ResponseEntity.ok(Res);
    }

    @PostMapping
    public Member postMember(@RequestBody Member member) {
        return service.createMember(member);
    }
}

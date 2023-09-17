package me.tejaswan.LibraryManagement.services;

import me.tejaswan.LibraryManagement.entities.Member;
import me.tejaswan.LibraryManagement.exceptions.common.NotFoundException;

import java.util.List;
import java.util.UUID;

public interface MemberService {
    List<Member> allMembers();

    public Member MemberById(UUID id) throws NotFoundException;

    Member createMember(Member member);

    public long countMember();
}

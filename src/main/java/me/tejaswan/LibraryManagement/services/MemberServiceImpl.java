package me.tejaswan.LibraryManagement.services;

import lombok.AllArgsConstructor;
import me.tejaswan.LibraryManagement.entities.Member;
import me.tejaswan.LibraryManagement.exceptions.common.NotFoundException;
import me.tejaswan.LibraryManagement.repositories.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository repository;

    @Override
    public List<Member> allMembers() {
        return repository.findAll();
    }

    @Override
    public Member MemberById(UUID id) throws NotFoundException {
        Optional<Member> res = repository.findById(id);
        if (res.isEmpty()) {
            throw new NotFoundException("Member Not Found");
        }
        return res.get();
    }

    @Override
    public Member createMember(Member member) {
        return repository.save(member);
    }

    @Override
    public long countMember() {
        return repository.count();
    }
}

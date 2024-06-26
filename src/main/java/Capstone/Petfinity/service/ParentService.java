package Capstone.Petfinity.service;

import Capstone.Petfinity.domain.Parent;
import Capstone.Petfinity.repository.ParentRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ParentService {

    private final ParentRepository parentRepository;

    // 회원 가입
    @Transactional
    public UUID register(Parent parent) {
        validateDuplicateParent(parent); // 아이디 중복 확인
        validateParent(parent); // 아이디 형식 확인
        parentRepository.save(parent);
        return parent.getUuid();
    }

    private void validateParent(Parent parent) {
        if (parent.getId().length() < 8 || !parent.getId().matches("^[a-zA-Z0-9]+$"))
            throw new IllegalStateException("아이디의 형식이 올바르지 않습니다.");
    }

    private void validateDuplicateParent(Parent parent) {
        List<Parent> findParents = parentRepository.findById(parent.getId());
        if (!findParents.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

//    @Transactional
//    public UUID login(Parent parent) {
//
//    }

}

package com.cypay.common.repository.impl;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.cypay.common.entity.Token;
import com.cypay.common.repository.BaseRepository;

@Repository
public interface TokenRepository extends BaseRepository<Token, Long> {

	Optional<Token> findByMark(String mark);
}

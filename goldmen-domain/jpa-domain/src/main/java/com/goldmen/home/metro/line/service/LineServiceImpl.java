package com.goldmen.home.metro.line.service;

import com.goldmen.home.metro.line.domain.Line;
import com.goldmen.home.metro.line.domain.LineRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LineServiceImpl implements LineModifyService {
    private final LineRepository lineRepository;

    @Override
    @Transactional
    public Line save(Line line) {
        return lineRepository.save(line);
    }
}

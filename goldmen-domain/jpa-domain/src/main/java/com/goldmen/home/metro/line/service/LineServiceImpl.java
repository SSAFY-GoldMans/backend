package com.goldmen.home.metro.line.service;

import com.goldmen.home.metro.line.domain.Line;
import com.goldmen.home.metro.line.domain.LineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class LineServiceImpl implements LineModifyService, LineLoadService {
    private final LineRepository lineRepository;

    @Override
    @Transactional
    public Line save(Line line) {
        return lineRepository.findByName(line.getName())
                .orElseGet(() -> lineRepository.save(line));
    }

    @Override
    public Line findByName(Line line) {
        return lineRepository.findByName(line.getName())
                .orElseThrow(NoSuchElementException::new);
    }
}

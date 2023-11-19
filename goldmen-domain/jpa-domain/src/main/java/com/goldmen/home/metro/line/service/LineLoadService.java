package com.goldmen.home.metro.line.service;

import com.goldmen.home.metro.line.domain.Line;

public interface LineLoadService {
    Line findByName(Line line);
}

package com.goldmen.jpadomain.metro.line.service;

import com.goldmen.jpadomain.metro.line.domain.Line;

public interface LineLoadService {
    Line findByName(Line line);
}

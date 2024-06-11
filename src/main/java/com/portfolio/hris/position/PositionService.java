package com.portfolio.hris.position;

import java.util.List;

public interface PositionService {
    List<PositionDTO> getList();

    void createPosition(PositionDTO positionDTO);

    PositionDTO readPosition(String positionCode);

    void updatePositionInformation(PositionDTO positionDTO);
}

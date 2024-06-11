package com.portfolio.hris.position;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PositionServiceImpl implements PositionService {
    private final PositionMapper positionMapper;

    @Override
    @Transactional(readOnly = true)
    public List<PositionDTO> getList() {
        List<PositionDAO> resource = positionMapper.getList();
        List<PositionDTO> result = new ArrayList<>();

        resource.forEach(position -> result.add(position.getPositionDTO()));

        return result;
    }

    @Override
    @Transactional
    public void createPosition(PositionDTO positionDTO) {
        PositionDAO positionDAO = PositionDAO.applyPositionDTO(positionDTO);

        positionMapper.createPosition(positionDAO);
    }

    @Override
    @Transactional(readOnly = true)
    public PositionDTO readPosition(String positionCode) {
        PositionDAO positionDAO = positionMapper.getPositionByPositionCode(positionCode);

        return positionDAO.getPositionDTO();
    }

    @Override
    @Transactional
    public void updatePositionInformation(PositionDTO positionDTO) {
        PositionDAO positionDAO = PositionDAO.applyPositionDTO(positionDTO);

        positionMapper.updatePositionInformation(positionDAO);
    }
}
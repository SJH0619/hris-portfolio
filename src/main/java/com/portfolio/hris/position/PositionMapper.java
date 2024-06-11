package com.portfolio.hris.position;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PositionMapper {
    List<PositionDAO> getList();

    void createPosition(PositionDAO positionDAO);

    PositionDAO getPositionByPositionCode(String positionCode);

    void updatePositionInformation(PositionDAO positionDAO);
}

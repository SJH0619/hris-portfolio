package com.portfolio.hris.position;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PositionDAO {
    private String positionCode;
    private String positionName;
    private String insertAt;
    private String insertBy;
    private String updateAt;
    private String updateBy;

    public static PositionDAO applyPositionDTO(PositionDTO positionDTO) {
        return PositionDAO.builder()
                .positionCode(positionDTO.getPositionCode())
                .positionName(positionDTO.getPositionName())
                .insertAt(positionDTO.getInsertAt())
                .insertBy(positionDTO.getInsertBy())
                .updateAt(positionDTO.getUpdateAt())
                .updateBy(positionDTO.getUpdateBy())
                .build();
    }

    public PositionDTO getPositionDTO() {
        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setPositionCode(positionCode);
        positionDTO.setPositionName(positionName);
        positionDTO.setInsertAt(insertAt);
        positionDTO.setInsertBy(insertBy);
        positionDTO.setUpdateAt(updateAt);
        positionDTO.setUpdateBy(updateBy);

        return positionDTO;
    }
}

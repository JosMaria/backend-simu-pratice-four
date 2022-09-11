package org.genesiscode.practicefour.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.genesiscode.practicefour.dto.MultiplicativeResponseDTO;
import org.genesiscode.practicefour.dto.ResponseDTO;
import org.genesiscode.practicefour.service.MainService;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MainServiceImpl implements MainService {

    @Override
    public ResponseDTO<MultiplicativeResponseDTO> multiplicative(Integer seed, Integer multiplicativeConstant, Integer module) {
        log.info("multiplicative returns with successfully");
        return new ResponseDTO<>();
    }
}

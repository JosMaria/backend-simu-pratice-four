package org.genesiscode.practicefour.service;

import org.genesiscode.practicefour.dto.MixedResponseDTO;
import org.genesiscode.practicefour.dto.MultiplicativeBinaryResponseDTO;
import org.genesiscode.practicefour.dto.MultiplicativeResponseDTO;
import org.genesiscode.practicefour.dto.ResponseDTO;

public interface MainService {

    ResponseDTO<MixedResponseDTO> mixed(Integer seed, Integer multiplicativeConstant, Integer additiveConstant, Integer module);

    ResponseDTO<MultiplicativeResponseDTO> multiplicative(Integer seed, Integer multiplicativeConstant, Integer module);

    ResponseDTO<MultiplicativeBinaryResponseDTO> multiplicativeBinary(Integer seed, Integer multiplicativeConstant, Integer module);
}

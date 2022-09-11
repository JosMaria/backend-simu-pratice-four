package org.genesiscode.practicefour.service;

import org.genesiscode.practicefour.dto.MultiplicativeResponseDTO;
import org.genesiscode.practicefour.dto.ResponseDTO;

public interface MainService {

    ResponseDTO<MultiplicativeResponseDTO> multiplicative();
}

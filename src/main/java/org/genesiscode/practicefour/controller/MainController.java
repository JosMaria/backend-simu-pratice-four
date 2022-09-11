package org.genesiscode.practicefour.controller;

import lombok.RequiredArgsConstructor;
import org.genesiscode.practicefour.dto.MultiplicativeResponseDTO;
import org.genesiscode.practicefour.dto.ResponseDTO;
import org.genesiscode.practicefour.service.MainService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class MainController {

    private final MainService mainService;

    @GetMapping("/multiplicative")
    public ResponseEntity<ResponseDTO<MultiplicativeResponseDTO>> multiplicative() {
        return ResponseEntity.ok(mainService.multiplicative());
    }
}

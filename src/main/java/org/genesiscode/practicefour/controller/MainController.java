package org.genesiscode.practicefour.controller;

import lombok.RequiredArgsConstructor;
import org.genesiscode.practicefour.dto.MultiplicativeBinaryResponseDTO;
import org.genesiscode.practicefour.dto.MultiplicativeResponseDTO;
import org.genesiscode.practicefour.dto.ResponseDTO;
import org.genesiscode.practicefour.service.MainService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class MainController {

    private final MainService mainService;

    @GetMapping("/multiplicative")
    public ResponseEntity<ResponseDTO<MultiplicativeResponseDTO>> multiplicative(
            @RequestParam Integer seed,
            @RequestParam("multiplicative") Integer multiplicativeConstant,
            @RequestParam Integer module) {
        return ResponseEntity.ok(mainService.multiplicative(seed, multiplicativeConstant, module));
    }

    @GetMapping("/multiplicative/binary")
    public ResponseEntity<ResponseDTO<MultiplicativeBinaryResponseDTO>> multiplicativeBinary(
            @RequestParam Integer seed,
            @RequestParam("multiplicative") Integer multiplicativeConstant,
            @RequestParam Integer module) {
        return ResponseEntity.ok(mainService.multiplicativeBinary(seed, multiplicativeConstant, module));
    }
}

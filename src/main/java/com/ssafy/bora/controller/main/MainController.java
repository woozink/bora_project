package com.ssafy.bora.controller.main;

import com.ssafy.bora.service.broadcast.IBroadcastService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/main")
public class MainController {

    private IBroadcastService broadcastService;

    //팔로워 수 탑텐
    @GetMapping("/top-ten")
    public ResponseEntity<?> findTopTen() {
        return new ResponseEntity<>(broadcastService.findTopTenBroadcast(), HttpStatus.OK);
    }
    //내가 팔로워한거
    @GetMapping("/follow-broad/{id}")
    public ResponseEntity<?> findFollowBroadcast(@PathVariable String id){
        return new ResponseEntity<>(broadcastService.findFollowBroadcast(id),HttpStatus.OK);
    }

    @GetMapping("/live-board/{category}")
    public ResponseEntity<?> findLiveBroadcast(@PathVariable(required = false) String category,
                                               @RequestParam(value="mood",required = false) String[] mood,
                                               @RequestParam(value="sortBy",required = false) String sortBy) {
        return new ResponseEntity<>(broadcastService.findAllLiveBroadcast(category,mood,sortBy), HttpStatus.OK);
    }
}
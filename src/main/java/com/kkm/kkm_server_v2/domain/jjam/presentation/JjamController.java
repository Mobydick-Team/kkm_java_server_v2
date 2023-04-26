package com.kkm.kkm_server_v2.domain.jjam.presentation;

import com.kkm.kkm_server_v2.domain.jjam.presentation.dto.request.CreateJjamRequest;
import com.kkm.kkm_server_v2.domain.jjam.presentation.dto.response.CountJjamsResponse;
import com.kkm.kkm_server_v2.domain.jjam.presentation.dto.response.LoadUserJjamsListResponse;
import com.kkm.kkm_server_v2.domain.jjam.service.CountJjamsService;
import com.kkm.kkm_server_v2.domain.jjam.service.CreateJjamService;
import com.kkm.kkm_server_v2.domain.jjam.service.DeleteJjamService;
import com.kkm.kkm_server_v2.domain.jjam.service.LoadUserJjamsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jjam")
@RequiredArgsConstructor
@Tag(name = "쨈 서버")
public class JjamController {
    private final CreateJjamService createJjamService;
    private final DeleteJjamService deleteJjamService;
    private final CountJjamsService countJjamsService;
    private final LoadUserJjamsService loadUserJjamsService;

    @Operation(summary = "쨈 생성")
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createJjam(@RequestBody CreateJjamRequest request) {
        createJjamService.execute(request);
    }

    @Operation(summary = "쨈 삭제")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteJjam(@PathVariable("id") Long id) {
        deleteJjamService.execute(id);
    }

    @Operation(summary = "쨈 개수")
    @GetMapping("/{id}")
    public CountJjamsResponse countJjams(@PathVariable("id") Long id) {
        return countJjamsService.execute(id);
    }

    @Operation(summary = "내 쨈 개수")
    @GetMapping("/my")
    public LoadUserJjamsListResponse loadUserJJams() {
        return loadUserJjamsService.execute();
    }
}

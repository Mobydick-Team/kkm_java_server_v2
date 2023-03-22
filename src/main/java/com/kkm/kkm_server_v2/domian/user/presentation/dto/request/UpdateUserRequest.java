package com.kkm.kkm_server_v2.domian.user.presentation.dto.request;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
@Getter
@AllArgsConstructor
public class UpdateUserRequest {
    @NotBlank
    private String name;

    @NotBlank
    private long id;


}

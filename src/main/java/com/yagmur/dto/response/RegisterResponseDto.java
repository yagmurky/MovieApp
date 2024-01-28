package com.yagmur.dto.response;

import com.yagmur.utility.EStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterResponseDto {

    private String name;
    private String surname;
    private String email;
    private EStatus status;
}

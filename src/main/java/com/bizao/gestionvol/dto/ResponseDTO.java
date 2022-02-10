package com.bizao.gestionvol.dto;

import com.bizao.gestionvol.exceptions.ErrorCodes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseDTO
{
    private String message;

    private Boolean success;

    private ErrorCodes errorCodes;

    private List<String> errors;
}

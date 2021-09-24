package org.itstep.producer.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ErrorBody {

    private Integer code;

    private  String message;
}

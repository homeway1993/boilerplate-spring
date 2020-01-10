package boilerplate.spring.web.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
public class ErrorResponse {

    private List<ErrorMsg> errors;

    @Data
    public static class ErrorMsg {
        private String message;
    }

    @Data
    @EqualsAndHashCode(callSuper = true)
    public static class ErrorCodeMsg extends ErrorMsg {
        private String errorCode;
    }

    @Data
    @EqualsAndHashCode(callSuper = true)
    public static class ErrorFieldMsg extends ErrorCodeMsg {
        private String entity;
        private String property;
        private Object invalidValue;
    }
}

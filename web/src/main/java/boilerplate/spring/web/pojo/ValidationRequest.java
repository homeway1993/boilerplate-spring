package boilerplate.spring.web.pojo;

import boilerplate.spring.web.constant.Status;
import boilerplate.spring.web.constraint.DateTimeFormat;
import boilerplate.spring.web.constraint.MatchEnum;
import lombok.Data;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.util.List;

@Data
public class ValidationRequest {

    @NotBlank(message = "E00001")
    private String notBlank;

    @DecimalMax(message = "E00002", value = "1")
    @DecimalMin(message = "E00002", value = "0", inclusive = false)
    private BigDecimal discountRate;

    private List<@Pattern(message = "E00003", regexp = "^.{2}$") String> productTypes;

    @DateTimeFormat(message = "E00004")
    private String effectiveDate;

    @MatchEnum(message = "E00005", enums = Status.class)
    private String status;
}

package boilerplate.spring.jpa.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "PS_EXCH_RTE")
public class ExchangeRate {

    @Id // 目前用不到 Id 先隨便給的
    @Column(name = "CCY_CDE")
    private String currencyCode;

    @Column(name = "BUY_RTE")
    private Double buyRate;

    @Column(name = "PYMT_MTHD_TYPE")
    private String paymentMethodType;
}

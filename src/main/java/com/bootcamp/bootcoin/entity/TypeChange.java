package com.bootcamp.bootcoin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
@ToString
public class TypeChange implements Serializable{

    private static final long serialVersionUID = -326626026693000507L;


    @Id
    private String id;
    private String currencyOrigin;
    private String currencyDestiny;
    private BigDecimal typeSell;
    private BigDecimal typeBuy;
    private short registrationStatus;
    private Date insertionDate;
    private String fk_insertionUser;
    private String insertionTerminal;

}

package com.feil.tymek.xcodejava.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class NBPResponse {

    List<Rate> rates;
    String table;
    String no;
    String effectiveDate;



}

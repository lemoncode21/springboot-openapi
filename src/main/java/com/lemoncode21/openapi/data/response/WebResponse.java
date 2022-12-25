package com.lemoncode21.openapi.data.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"code","status","message"})
public class WebResponse {

    @JsonProperty("code")
    private Integer code;
    @JsonProperty("status")
    private String status;
    @JsonProperty("message")
    private String message;
}

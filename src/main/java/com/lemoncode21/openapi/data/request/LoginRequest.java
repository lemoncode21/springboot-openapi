package com.lemoncode21.openapi.data.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"username","password"})
public class LoginRequest {

    @JsonProperty("username")
    private String username;
    @JsonProperty("password")
    private String password;
}

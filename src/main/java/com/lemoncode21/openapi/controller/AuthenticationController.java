package com.lemoncode21.openapi.controller;

import com.lemoncode21.openapi.data.request.LoginRequest;
import com.lemoncode21.openapi.data.response.WebResponse;
import com.lemoncode21.openapi.util.ReadJsonFileToJsonObject;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@Tag(name = "Authentication")
public class AuthenticationController {

    public ReadJsonFileToJsonObject readJsonFileToJsonObject;

    @PostMapping("/signIn")
    @Operation(
            description = "Sign In Service",
            responses = {
                    @ApiResponse(responseCode = "400",ref = "badRequestAPI"),
                    @ApiResponse(responseCode = "500",ref = "internalServerErrorAPI"),
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully Signed In!",
                            content = @Content(
                                    mediaType ="application/json",
                                    examples = {
                                            @ExampleObject(
                                                    value = "{\"code\" : 200, \"Status\" : \"Ok!\", \"Message\" :\"Successfully signed In!\"}"
                                            ),
                                    }
                            )
                    )
            }
    )
    public ResponseEntity<?> signIn(@io.swagger.v3.oas.annotations.parameters.RequestBody(
            content = @Content(
                    mediaType = "application/json",
                    examples = {
                            @ExampleObject(
                                    value = "{\"username\" : \"admin test\", \"password\" : \"admin test\"}"
                            ),
                    }
            )) @RequestBody LoginRequest request) {
        return new ResponseEntity<>(new WebResponse(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), "Successfully signed in!"), HttpStatus.OK);
    }
}

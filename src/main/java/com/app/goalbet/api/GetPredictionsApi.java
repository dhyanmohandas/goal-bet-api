/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.18).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.app.goalbet.api;

import com.app.goalbet.models.MatchPredictions;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.CookieValue;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-06-13T23:25:56.326263500+05:30[Asia/Calcutta]")
@Api(value = "getPredictions", description = "the getPredictions API")
public interface GetPredictionsApi {

    @ApiOperation(value = "Returns a list of predictions.", nickname = "getPredictions", notes = "", response = MatchPredictions.class, responseContainer = "List", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "get Predictions", response = MatchPredictions.class, responseContainer = "List") })
    @RequestMapping(value = "/getPredictions",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<MatchPredictions>> getPredictions();

}

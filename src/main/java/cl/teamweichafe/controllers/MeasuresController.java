package cl.teamweichafe.controllers;

import cl.teamweichafe.domain.Measure;
import cl.teamweichafe.services.MeasureService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/measures")
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Request Succeeded",
                content = { @Content(mediaType = "application/json",
                        schema = @Schema(implementation = Measure.class)) }),
        @ApiResponse(responseCode = "201", description = "Resource Created",
                content = { @Content(mediaType = "application/json",
                        schema = @Schema(implementation = Measure.class)) }),
        @ApiResponse(responseCode = "400", description = "Bad Request",
                content = @Content),
        @ApiResponse(responseCode = "404", description = "Not Found",
                content = @Content) ,
        @ApiResponse(responseCode = "500", description = "Internal Server Error",
                content = @Content)})
public class MeasuresController {
    private final MeasureService measureService;

    public MeasuresController(MeasureService measureService) {
        this.measureService = measureService;
    }

    @Operation(summary = "Endpoint to retrieve all Measures")
    @GetMapping
    public ResponseEntity<List<Measure>> getAll() {

        return ResponseEntity.ok(this.measureService.getAll());
    }

    @Operation(summary = "Endpoint to retrieve a Measure by Id")
    @GetMapping("/{id}")
    public ResponseEntity<Measure> getById(@PathVariable String id ) {

        return ResponseEntity.ok(this.measureService.get(id));
    }

    @Operation(summary = "Endpoint to add a new measure")
    @PostMapping
    public ResponseEntity<Measure> create(@RequestBody Measure measure) {
        return ResponseEntity.ok(measureService.save(measure));
    }

    @Operation(summary = "Endpoint to update a measure")
    @PutMapping("/{id}")
    public ResponseEntity<Measure> update(@PathVariable String id, @RequestBody Measure measure) {
        return ResponseEntity.ok(measureService.get(id));
    }

    @Operation(summary = "Endpoint to delete a measure")
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        measureService.delete(id);
        return ResponseEntity.ok().build();
    }
}

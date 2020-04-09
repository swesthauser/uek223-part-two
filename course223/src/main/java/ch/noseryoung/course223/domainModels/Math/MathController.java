package ch.noseryoung.course223.domainModels.Math;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/maths")
public class MathController {

    private MathService mathService;

    @Autowired
    public MathController(MathService mathService) {
        this.mathService = mathService;
    }

    @GetMapping("multiplication/{a}/{b}")
    public @ResponseBody
    ResponseEntity<Double> multiply(@PathVariable double a, @PathVariable double b){
        return new ResponseEntity<>(mathService.multiplicate(a, b), HttpStatus.OK);
    }

    @GetMapping("addition/{a}/{b}")
    public @ResponseBody
    ResponseEntity<Double> sum(@PathVariable double a, @PathVariable double b){
        return new ResponseEntity<>(mathService.sum(a, b), HttpStatus.OK);
    }

    @GetMapping("subtract/{a}/{b}")
    public @ResponseBody
    ResponseEntity<Double> subtract(@PathVariable double a, @PathVariable double b){
        return new ResponseEntity<>(mathService.subtract(a, b), HttpStatus.OK);
    }
}

package ch.noseryoung.course223.domainModels.Math;

import ch.noseryoung.course223.domainModels.Function;
import org.springframework.stereotype.Service;

@Service
public class MathServiceImpl implements MathService{


    @Override
    public double multiplicate(double x, double z) {
        Function f = (a,b)->a*b;
        return f.calculate(x, z);
    }

    @Override
    public double sum(double x, double z) {
        Function f = (a,b)->a+b;
        return f.calculate(x, z);
    }

    @Override
    public double subtract(double x, double z) {
        Function f = (a,b)->a-b;
        return f.calculate(x, z);
    }

}

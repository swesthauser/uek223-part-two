package ch.noseryoung.course223.domainModels.Math;

import ch.noseryoung.course223.domainModels.Function;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MathServiceImpl implements MathService{


    @Override
    public int multiplicate(int x, int z) {
        Function f = (a,b)->a*b;
        return f.calculate(x, z);
    }

}

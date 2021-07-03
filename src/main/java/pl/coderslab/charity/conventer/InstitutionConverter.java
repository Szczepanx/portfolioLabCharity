package pl.coderslab.charity.conventer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.coderslab.charity.institution.Institution;
import pl.coderslab.charity.institution.InstitutionRepo;
@Component
public class InstitutionConverter implements Converter<String, Institution> {

    @Autowired
    InstitutionRepo institutionRepo;


    @Override
    public Institution convert(String s) {
        return institutionRepo.getOne(Long.parseLong(s));
    }
}

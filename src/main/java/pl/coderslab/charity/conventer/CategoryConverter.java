package pl.coderslab.charity.conventer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.coderslab.charity.category.Category;
import pl.coderslab.charity.category.CategoryRepo;

import java.util.List;
@Component
public class CategoryConverter implements Converter<String, Category> {

    @Autowired
    CategoryRepo categoryRepo;



    @Override
    public Category convert(String s) {
        return categoryRepo.getOne(Long.parseLong(s));
    }
}

package com.helloworld.quickstart.controller.validator;

import com.helloworld.quickstart.controller.DifferentIdAndName;
import com.helloworld.quickstart.dto.ItemDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DifferentIdAndNameValidator implements ConstraintValidator<DifferentIdAndName, ItemDto> {

    @Override
    public boolean isValid(ItemDto itemDto, ConstraintValidatorContext context) {
        if (itemDto == null) {
            return true;
        }
        return !itemDto.getId().equals(itemDto.getName());
    }
}

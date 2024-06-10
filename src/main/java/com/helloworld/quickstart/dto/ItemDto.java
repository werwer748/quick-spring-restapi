package com.helloworld.quickstart.dto;

import com.helloworld.quickstart.controller.DifferentIdAndName;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@DifferentIdAndName
public class ItemDto {
    @NotNull
    private String id;

    private String name;
}

package com.mimisalon.casestudy.form;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

public class CreateCustomerServiceFormBean {
    private Integer id;
    private String name;
    private String description;
    private double price;

}
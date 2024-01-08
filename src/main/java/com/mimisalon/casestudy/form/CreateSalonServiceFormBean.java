package com.mimisalon.casestudy.form;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CreateSalonServiceFormBean {
    private Integer id;
    private String name;
    private String image_url;
    private Double price;

}
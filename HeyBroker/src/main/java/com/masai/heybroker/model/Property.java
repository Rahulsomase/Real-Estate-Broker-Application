package com.masai.heybroker.model;



import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer propId;
    @Embedded
    private PropertyCriteria propertyCriteria;
    @NotBlank(message = "Property offercost can not be null or blank")
    private double offerCost;
    @NotBlank(message = "Property area of sqft can not be null or blank")
    private double areaSqft;
    @NotBlank(message = "Property address can not be null or blank")
    private String address;
    @NotBlank(message = "Property street can not be null or blank")
    private String street;
    @NotBlank(message = "Property status can not be null or blank")
    private boolean status;


    @Enumerated(EnumType.STRING)
    private OfferType offerType;

    @Enumerated(EnumType.STRING)
    private PropertyType propertyType;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "brokerId")
    private Broker broker;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

}

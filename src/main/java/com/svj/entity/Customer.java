package com.svj.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.javafx.geom.transform.Identity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CUSTOMERS")
public class Customer {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
    private String phone;
    @JsonFormat(pattern = "dd-MM-yyyy") // MM/dd/yyyy is the required output format
    private Date dob;
}

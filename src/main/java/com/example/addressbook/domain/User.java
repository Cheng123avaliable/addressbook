package com.example.addressbook.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
@Data
@Table(name = "users")
public class User implements Serializable {

	private static final long serialVersionUID =  4954720330949630085L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String name;

	@Column(name = "mobilephone")
	private String mobilePhone;

	private String email;

	private String telephone;

	private String remarks;

}

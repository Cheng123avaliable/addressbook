package com.example.addressbook.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data

@Table(name = "note")
public class Note implements Serializable {

	private static final long serialVersionUID =  5286901699210826176L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	/**
	 * 主键id
	 */
	private Integer id;

	/**
	 * 电话簿名称
	 */
	private String name;



}

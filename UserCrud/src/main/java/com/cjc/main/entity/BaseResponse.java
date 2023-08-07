package com.cjc.main.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse<T> {
	private int ResponceStatus;
	private String resposeMsg;
	private Date responseData;
	private T responceData; 

}

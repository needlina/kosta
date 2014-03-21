package com.namoosori.shop.web.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ChangeCurrency extends SimpleTagSupport {
	
	private Integer value;
	
	public void setValue(Integer value) {
		this.value = value;
	}

	@Override
	public void doTag() throws JspException, IOException {
		//
		JspWriter out = getJspContext().getOut();
		out.print(String.format("%,d", value));
		
	}
	
	

}

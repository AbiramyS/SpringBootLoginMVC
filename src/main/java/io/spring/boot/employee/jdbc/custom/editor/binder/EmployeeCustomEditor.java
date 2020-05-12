package io.spring.boot.employee.jdbc.custom.editor.binder;

import java.beans.PropertyEditorSupport;

public class EmployeeCustomEditor extends PropertyEditorSupport{

	@Override
	public void setAsText(String fname) throws IllegalArgumentException {
		if(fname != null && !fname.isEmpty()) {
			setValue(fname.toUpperCase());
		}
	}
}

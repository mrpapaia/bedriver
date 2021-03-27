package br.com.bedriver.web;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;

import org.springframework.core.io.ClassPathResource;

@ManagedBean(name = "utilBean")
@ViewScoped
public class UtilBean implements Serializable {

	private static final long serialVersionUID = 1825214734508489734L;
	
	boolean errorLogin = false;
	boolean checked = false;
	boolean opControl = false;

	public boolean isOpControl() {
		System.out.println("is: " +opControl);
		return opControl;
	}

	public void setOpControl(boolean opControl) {
		System.out.println("set: " +opControl);

		this.opControl = opControl;
	}

	public boolean isErrorLogin() {
		return errorLogin;
	}

	public void setErrorLogin(boolean errorLogin) {
		this.errorLogin = errorLogin;
		this.setOpControl(this.getChecked() || this.errorLogin);
	}

	public boolean isChecked() {
		return checked;
	}

	public boolean getChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
		this.setOpControl(this.getChecked() || this.errorLogin);
	}

	public void change() {
		this.setChecked(!this.getChecked());
		this.setOpControl(this.getChecked() || this.errorLogin);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (checked ? 1231 : 1237);
		result = prime * result + (errorLogin ? 1231 : 1237);
		result = prime * result + (opControl ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UtilBean other = (UtilBean) obj;
		if (checked != other.checked)
			return false;
		if (errorLogin != other.errorLogin)
			return false;
		if (opControl != other.opControl)
			return false;
		return true;
	}
	
}

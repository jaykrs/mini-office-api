package com.teqto.certifyme.utils;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

import org.apache.logging.log4j.util.Strings;

import com.teqto.certifyme.constant.ServiceConstants;
import com.teqto.certifyme.entity.Article;
import com.teqto.certifyme.entity.Assignment;
import com.teqto.certifyme.entity.Customer;
import com.teqto.certifyme.entity.Customerpayment;
import com.teqto.certifyme.entity.Employee;
import com.teqto.certifyme.entity.Payroll;
import com.teqto.certifyme.entity.Salarytransection;
import com.teqto.certifyme.entity.Sprint;
import com.teqto.certifyme.entity.Task;

public class ObjectUtility {

	public static Object setDateUpdate(Object object) {
		String objectType = object.getClass().getName().replace(ServiceConstants.PACKAGE_NAME + ServiceConstants.DOT,
				Strings.EMPTY);
		switch (objectType) {
		// Case statements
		case "Employee": {
			Employee o = (Employee) object;
			if (Objects.isNull(o.getCreatedAt()))
				o.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
			if (Objects.isNull(o.getUpdatedAt()))
				o.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
			if (Objects.isNull(o.getCreatedBy()))
				o.setCreatedBy(0);
			if (Objects.isNull(o.getUpdatedBy()))
				o.setUpdatedBy(0);
			return o;
		}
		case "Customer": {
			Customer o = (Customer) object;
			if (Objects.isNull(o.getCreatedAt()))
				o.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
			if (Objects.isNull(o.getUpdatedAt()))
				o.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
			if (Objects.isNull(o.getCreatedBy()))
				o.setCreatedBy(0);
			if (Objects.isNull(o.getUpdatedBy()))
				o.setUpdatedBy(0);
			return o;
		}
		case "Article": {
			Article o = (Article) object;
			if (Objects.isNull(o.getCreatedAt()))
				o.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
			if (Objects.isNull(o.getUpdatedAt()))
				o.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
			if (Objects.isNull(o.getCreatedBy()))
				o.setCreatedBy(0);
			if (Objects.isNull(o.getUpdatedBy()))
				o.setUpdatedBy(0);
			return o;
		}
		case "Assignment": {
			Assignment o = (Assignment) object;
			if (Objects.isNull(o.getCreatedAt()))
				o.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
			if (Objects.isNull(o.getUpdatedAt()))
				o.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
			if (Objects.isNull(o.getCreatedBy()))
				o.setCreatedBy(0);
			if (Objects.isNull(o.getUpdatedBy()))
				o.setUpdatedBy(0);
			return o;
		}
		case "Customerpayment": {
			Customerpayment o = (Customerpayment) object;
			if (Objects.isNull(o.getCreatedAt()))
				o.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
			if (Objects.isNull(o.getUpdatedAt()))
				o.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
			if (Objects.isNull(o.getCreatedBy()))
				o.setCreatedBy(0);
			if (Objects.isNull(o.getUpdatedBy()))
				o.setUpdatedBy(0);
			return o;
		}
		case "Payroll": {
			Payroll o = (Payroll) object;
			if (Objects.isNull(o.getCreatedAt()))
				o.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
			if (Objects.isNull(o.getUpdatedAt()))
				o.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
			if (Objects.isNull(o.getCreatedBy()))
				o.setCreatedBy(0);
			if (Objects.isNull(o.getUpdatedBy()))
				o.setUpdatedBy(0);
			return o;
		}
		case "Salarytransection": {
			Salarytransection o = (Salarytransection) object;
			if (Objects.isNull(o.getCreatedAt()))
				o.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
			if (Objects.isNull(o.getUpdatedAt()))
				o.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
			if (Objects.isNull(o.getCreatedBy()))
				o.setCreatedBy(0);
			if (Objects.isNull(o.getUpdatedBy()))
				o.setUpdatedBy(0);
			return o;
		}
		case "Sprint": {
			Sprint o = (Sprint) object;
			if (Objects.isNull(o.getCreatedAt()))
				o.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
			if (Objects.isNull(o.getUpdatedAt()))
				o.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
			if (Objects.isNull(o.getCreatedBy()))
				o.setCreatedBy(0);
			if (Objects.isNull(o.getUpdatedBy()))
				o.setUpdatedBy(0);
			return o;
		}
		case "Task": {
			Task o = (Task) object;
			if (Objects.isNull(o.getCreatedAt()))
				o.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
			if (Objects.isNull(o.getUpdatedAt()))
				o.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
			if (Objects.isNull(o.getCreatedBy()))
				o.setCreatedBy(0);
			if (Objects.isNull(o.getUpdatedBy()))
				o.setUpdatedBy(0);
			return o;
		}
		default:
			return new Object();
		}

	}
	
}

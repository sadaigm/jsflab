package com.sa.tcm.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-05-31T00:50:12.609+0530")
@StaticMetamodel(Testrun.class)
public class Testrun_ {
	public static volatile SingularAttribute<Testrun, Integer> testrunID;
	public static volatile SingularAttribute<Testrun, String> buildNo;
	public static volatile SingularAttribute<Testrun, Date> createdDt;
	public static volatile SingularAttribute<Testrun, String> moduleName;
	public static volatile SingularAttribute<Testrun, String> name;
	public static volatile SingularAttribute<Testrun, String> projectName;
}

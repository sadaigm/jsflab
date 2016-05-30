package com.sa.tcm.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-05-31T00:50:12.591+0530")
@StaticMetamodel(Runner.class)
public class Runner_ {
	public static volatile SingularAttribute<Runner, Integer> runnerId;
	public static volatile SingularAttribute<Runner, String> testCaseId;
	public static volatile SingularAttribute<Runner, String> status;
	public static volatile SingularAttribute<Runner, String> buildno;
	public static volatile SingularAttribute<Runner, String> defectid;
	public static volatile SingularAttribute<Runner, String> runname;
	public static volatile SingularAttribute<Runner, String> tester;
	public static volatile SingularAttribute<Runner, Date> executeddate;
	public static volatile SingularAttribute<Runner, Date> lastupdatedate;
	public static volatile SingularAttribute<Runner, String> comments;
}

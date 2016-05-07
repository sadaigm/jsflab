package com.sa.tcm.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-05-07T02:39:10.192+0530")
@StaticMetamodel(Defect.class)
public class Defect_ {
	public static volatile SingularAttribute<Defect, Integer> id;
	public static volatile SingularAttribute<Defect, String> assigned_To;
	public static volatile SingularAttribute<Defect, Date> closed_date;
	public static volatile SingularAttribute<Defect, Date> created_Date;
	public static volatile SingularAttribute<Defect, String> dev_Comments;
	public static volatile SingularAttribute<Defect, String> fixed_Build_No;
	public static volatile SingularAttribute<Defect, Date> fixed_Date;
	public static volatile SingularAttribute<Defect, Integer> priority;
	public static volatile SingularAttribute<Defect, String> QA_Comments;
	public static volatile SingularAttribute<Defect, String> raised_Build_No;
	public static volatile SingularAttribute<Defect, Date> reopen_date;
	public static volatile SingularAttribute<Defect, String> severity;
	public static volatile SingularAttribute<Defect, String> state;
	public static volatile SingularAttribute<Defect, String> steps_to_Reproduce;
	public static volatile SingularAttribute<Defect, String> test_case_Ref;
	public static volatile SingularAttribute<Defect, String> title;
	public static volatile SingularAttribute<Defect, String> work_Item_Type;
}

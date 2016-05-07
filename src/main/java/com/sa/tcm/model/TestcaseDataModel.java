package com.sa.tcm.model;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import com.sa.tcm.entity.Testcase;

public class TestcaseDataModel extends ListDataModel<Testcase>  implements SelectableDataModel<Testcase> {

	
	public TestcaseDataModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TestcaseDataModel(List<Testcase> list) {
		super(list);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Testcase getRowData(String  rowKey) {
		List<Testcase> testcases = (List<Testcase>) getWrappedData();

        for(Testcase testcase : testcases) {
            if(testcase.getTestcaseIdpk().equals(rowKey))
                return testcase;
        }

        return null;
		
	}

	@Override
	public Object getRowKey(Testcase testcase) {
		return testcase.getTestcaseIdpk();
	}

}

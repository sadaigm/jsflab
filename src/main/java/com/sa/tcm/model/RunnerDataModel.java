package com.sa.tcm.model;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import com.sa.tcm.entity.Runner;

public class RunnerDataModel extends ListDataModel<Runner>  implements SelectableDataModel<Runner> {

	
	public RunnerDataModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RunnerDataModel(List<Runner> list) {
		super(list);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Runner getRowData(String  rowKey) {
		List<Runner> runners = (List<Runner>) getWrappedData();

        for(Runner runner : runners) {
            if(runner.getRunnerId().equals(rowKey))
                return runner;
        }

        return null;
		
	}

	@Override
	public Object getRowKey(Runner runner) {
		return runner.getRunnerId();
	}

}

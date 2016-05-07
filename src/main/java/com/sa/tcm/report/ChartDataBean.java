package com.sa.tcm.report;

import java.util.Random;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import org.chartistjsf.model.chart.AspectRatio;
import org.chartistjsf.model.chart.Axis;
import org.chartistjsf.model.chart.AxisType;
import org.chartistjsf.model.chart.ChartSeries;
import org.chartistjsf.model.chart.LineChartModel;
import org.chartistjsf.model.chart.LineChartSeries;
import org.primefaces.event.ItemSelectEvent;

import com.sa.tcm.dao.TestcaseDAOImpl;

@ManagedBean
public class ChartDataBean {

	private LineChartModel lineModel;
	@ManagedProperty("#{TestcaseDAOImpl}")
	 TestcaseDAOImpl caseimpl ;
	
	public TestcaseDAOImpl getCaseimpl() {
		return caseimpl;
	}

	public void setCaseimpl(TestcaseDAOImpl caseimpl) {
		this.caseimpl = caseimpl;
	}

	public ChartDataBean() {
		createLineModel();
	}

	public void createLineModel() {
		Random random = new Random();
		lineModel = new LineChartModel();
		lineModel.setAspectRatio(AspectRatio.GOLDEN_SECTION);

		lineModel.addLabel("1");
		lineModel.addLabel("2");
		lineModel.addLabel("3");
		lineModel.addLabel("4");
		lineModel.addLabel("5");
		lineModel.addLabel("6");
		lineModel.addLabel("7");
		lineModel.addLabel("8");

		LineChartSeries series1 = new LineChartSeries();
		series1.setName("Series 1");

		series1.set(random.nextInt(10));
		series1.set(random.nextInt(10));
		series1.set(random.nextInt(10));
		series1.set(random.nextInt(10));
		series1.set(random.nextInt(10));
		series1.set(random.nextInt(10));
		series1.set(random.nextInt(10));
		series1.set(random.nextInt(10));

		LineChartSeries series2 = new LineChartSeries();
		series2.setName("Series 2");

		series2.set(random.nextInt(1));
		series2.set(random.nextInt(2));
		series2.set(random.nextInt(3));
		series2.set(random.nextInt(4));
		series2.set(random.nextInt(5));
		series2.set(random.nextInt(6));
		series2.set(random.nextInt(7));
		series2.set(random.nextInt(8));

		LineChartSeries series3 = new LineChartSeries();
		series3.setName("Series 3");

		series3.set(random.nextInt(10));
		series3.set(random.nextInt(10));
		series3.set(random.nextInt(10));
		series3.set(random.nextInt(10));
		series3.set(random.nextInt(10));
		series3.set(random.nextInt(10));
		series3.set(random.nextInt(10));
		series3.set(random.nextInt(10));

		Axis xAxis = lineModel.getAxis(AxisType.X);
		lineModel.addSeries(series1);
		lineModel.addSeries(series2);
		lineModel.addSeries(series3);
		lineModel.setWidth("500");
		lineModel.setAnimateAdvanced(true);
		lineModel.setShowTooltip(true);
	}

	public void itemSelect(ItemSelectEvent event) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected", "Item Value: "
				+ ((ChartSeries) lineModel.getSeries().get(event.getSeriesIndex())).getData().get(event.getItemIndex())
				+ ", Series name:" + ((ChartSeries) lineModel.getSeries().get(event.getSeriesIndex())).getName());

		FacesContext.getCurrentInstance().addMessage(event.getComponent().getClientId(), msg);
	}
	
		/**
	 * @return the lineModel
	 */
	public LineChartModel getLineModel() {
		return lineModel;
	}

	/**
	 * @param lineModel
	 *            the lineModel to set
	 */
	public void setLineModel(LineChartModel lineModel) {
		this.lineModel = lineModel;
	}

}
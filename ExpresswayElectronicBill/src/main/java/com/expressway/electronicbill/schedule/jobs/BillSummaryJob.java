package com.expressway.electronicbill.schedule.jobs;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import com.expressway.electronicbill.api.helper.IConfigPropertiesHelper;

@DisallowConcurrentExecution
public class BillSummaryJob implements Job {
	private @Autowired IConfigPropertiesHelper configPropertiesHelper;

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("BillSummaryJob");
		
//		try {
//			BillSummary summary = new BillSummary();
//			BillSummaryHeader header = new BillSummaryHeader();
//			header.setDatefrom("234");
//			header.setDateto("23424");
//			header.setDeptcode("234234");
//			header.setRgncode("34534");
//			header.setTotamt("5675");
//			header.setCount("13");
//
//			summary.setHead(header);
//
//			List<BillSummaryBody> list = new ArrayList<BillSummaryBody>();
//
//			for (int i = 1; i < 3; i++) {
//				BillSummaryBody body = new BillSummaryBody();
//				body.setAmt("123");
//				body.setBgnno("234234");
//				body.setBillreg("234234");
//				body.setBilltype("345");
//				body.setBlnkcnt("345");
//				body.setBlnknospan("234");
//				body.setCopynum("");
//				body.setEndno("");
//				body.setInvldnospan("");
//
//				list.add(body);
//			}
//			summary.setBody(list);
//
//			File dir = new File(configPropertiesHelper.getProperty("ftp.localDir"));
//
//			if (!dir.exists()) {
//				dir.mkdirs();
//			}
//			File file = new File(configPropertiesHelper.getProperty("ftp.localDir") + File.separator + System.currentTimeMillis() + "_summary.xml");
//			JAXBContext jaxbContext = JAXBContext.newInstance(BillSummary.class);
//			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
//
//			// output pretty printed
//			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//
//			jaxbMarshaller.marshal(summary, file);
//			jaxbMarshaller.marshal(summary, System.out);
//
//		} catch (JAXBException e) {
//			e.printStackTrace();
//		}
	}
}

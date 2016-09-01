package com.expressway.electronicbill.task;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.expressway.electronicbill.summary.BillSummary;
import com.expressway.electronicbill.summary.BillSummaryBody;
import com.expressway.electronicbill.summary.BillSummaryHeader;

@Component("BillSummaryTask")
public class BillSummaryTask {
	private @Value("${bill.upload.local_dir}") String LOCAL_DIR;

	public void genBillSummary() {
		try {
			BillSummary summary = new BillSummary();
			BillSummaryHeader header = new BillSummaryHeader();
			header.setDatefrom("234");
			header.setDateto("23424");
			header.setDeptcode("234234");
			header.setRgncode("34534");
			header.setTotamt("5675");
			header.setCount("13");

			summary.setHead(header);

			List<BillSummaryBody> list = new ArrayList<BillSummaryBody>();

			for (int i = 1; i < 3; i++) {
				BillSummaryBody body = new BillSummaryBody();
				body.setAmt("123");
				body.setBgnno("234234");
				body.setBillreg("234234");
				body.setBilltype("345");
				body.setBlnkcnt("345");
				body.setBlnknospan("234");
				body.setCopynum("");
				body.setEndno("");
				body.setInvldnospan("");

				list.add(body);
			}
			summary.setBody(list);

			File dir = new File(LOCAL_DIR);

			if (!dir.exists()) {
				dir.mkdirs();
			}
			File file = new File(LOCAL_DIR + File.separator + System.currentTimeMillis() + "_summary.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(BillSummary.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(summary, file);
			jaxbMarshaller.marshal(summary, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}

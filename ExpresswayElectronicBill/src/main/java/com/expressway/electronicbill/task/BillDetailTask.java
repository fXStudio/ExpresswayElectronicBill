package com.expressway.electronicbill.task;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.expressway.electronicbill.detail.BillBody;
import com.expressway.electronicbill.detail.BillChargeItem;
import com.expressway.electronicbill.detail.BillDetail;
import com.expressway.electronicbill.detail.BillDetailBody;
import com.expressway.electronicbill.detail.BillDetailHeader;
import com.expressway.electronicbill.detail.BillHeader;

@Component("BillDetailTask")
public class BillDetailTask {
	private @Value("${bill.upload.local_dir}") String LOCAL_DIR;

	public void genBillDetailFile() {
		try {
			// 票据明细
			BillDetail detail = new BillDetail();
			// 整个的明细头信息
			BillDetailHeader header = new BillDetailHeader();
			header.setDeptcode("001");
			header.setRgncode("001");
			header.setDate("2016-07-20");
			header.setCount("2");

			detail.setHead(header);

			// 明细的内容(按票据分组)
			List<BillDetailBody> list = new ArrayList<BillDetailBody>();

			// 每一组票据的明细
			for (int i = 1; i < 3; i++) {
				BillDetailBody body = new BillDetailBody();

				BillHeader bh = new BillHeader();
				bh.setBillno("0002");
				bh.setBillreg("0001");
				bh.setBilltype("01");
				bh.setCnclauthor("test");
				bh.setCncldate("2016-01-01");
				bh.setDate("2016-01-01");
				bh.setIndustry("002");
				bh.setIndustrytype("02");
				bh.setIvcnodecode("0101");
				bh.setUser("test");

				body.setHead(bh);

				BillBody bb = new BillBody();
				bb.setPayername("收费票据");

				List<BillChargeItem> items = new ArrayList<BillChargeItem>();

				for (int n = 0; n < 3; n++) {
					BillChargeItem item = new BillChargeItem();
					item.setAmt("12");
					item.setChargecode("05698");
					item.setCnt("16");
					item.setStandard("789");

					items.add(item);
				}
				bb.setBody(items);

				body.setBody(bb);

				list.add(body);
			}
			detail.setBill(list);
			
			File dir = new File(LOCAL_DIR);

			if (!dir.exists()) {
				dir.mkdirs();
			}
			File file = new File(LOCAL_DIR + File.separator + System.currentTimeMillis() + "_detail.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(BillDetail.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(detail, file);
			jaxbMarshaller.marshal(detail, System.out);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}

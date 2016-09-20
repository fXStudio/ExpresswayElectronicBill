package com.expressway.electronicbill.schedule;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.log4j.Logger;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import com.expressway.electronicbill.api.helper.IConfigPropertiesHelper;

@DisallowConcurrentExecution
public class BillUploadJob implements Job {
	private @Autowired IConfigPropertiesHelper configPropertiesHelper;
	private Logger logger = Logger.getLogger("com.expressway.electronicbill.schedule");

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println(768678);

		// try {
		// // 读取目录
		// File directory = new File(configPropertiesHelper.getProperty(""));
		//
		// if (directory.exists()) {
		// // 遍历目录下的所有文件
		// for (File file : directory.listFiles()) {
		// FileInputStream in = new FileInputStream(file);
		// boolean flag = uploadFile(configPropertiesHelper.getProperty(""), 0,
		// configPropertiesHelper.getProperty(""),
		// configPropertiesHelper.getProperty(""),
		// configPropertiesHelper.getProperty(""), file.getName(), in);
		// logger.debug(flag);
		//
		// if (flag == true) {
		// File dir = new File(configPropertiesHelper.getProperty(""));
		//
		// if (!dir.exists()) {
		// logger.debug("创建Backup文件夹");
		// dir.mkdirs();
		// }
		// logger.debug("已上传文件归档");
		// file.renameTo(new File(dir + File.separator + file.getName()));
		// }
		// }
		// }
		// } catch (FileNotFoundException e) {
		// e.printStackTrace();
		// }
	}

	/**
	 * Description: 向FTP服务器上传文件 @Version1.0
	 * 
	 * @param url
	 *            FTP服务器hostname
	 * @param port
	 *            FTP服务器端口
	 * @param username
	 *            FTP登录账号
	 * @param password
	 *            FTP登录密码
	 * @param path
	 *            FTP服务器保存目录
	 * @param filename
	 *            上传到FTP服务器上的文件名
	 * @param input
	 *            输入流
	 * @return 成功返回true，否则返回false
	 */
	private boolean uploadFile(String url, // FTP服务器hostname
			int port, // FTP服务器端口
			String username, // FTP登录账号
			String password, // FTP登录密码
			String path, // FTP服务器保存目录
			String filename, // 上传到FTP服务器上的文件名
			InputStream input // 输入流
	) {
		boolean success = false;
		FTPClient ftp = new FTPClient();
		try {
			int reply;
			ftp.connect(url, port);// 连接FTP服务器
			// 如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器
			ftp.login(username, password);// 登录
			reply = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				return success;
			}
			ftp.changeWorkingDirectory(path);
			if (!ftp.changeToParentDirectory()) {
				ftp.makeDirectory(path);
			}
			ftp.storeFile(path + File.separator + filename, input);

			input.close();
			ftp.logout();
			success = true;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (IOException ioe) {
				}
			}
		}
		return success;
	}
}

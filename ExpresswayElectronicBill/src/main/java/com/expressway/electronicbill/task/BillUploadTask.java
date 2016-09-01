package com.expressway.electronicbill.task;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("BillUploadTask")
public class BillUploadTask {
	private @Value("${bill.upload.local_dir}") String LOCAL_DIR;
	private @Value("${bill.upload.local_back}") String LOCAL_BACKUP;
	private @Value("${bill.upload.ftp.remote_dir}") String REMOTE_DIR;
	private @Value("${bill.upload.ftp.server}") String FTP_SERVER;
	private @Value("${bill.upload.ftp.port}") int FTP_PORT;
	private @Value("${bill.upload.ftp.username}") String USERNAME;
	private @Value("${bill.upload.ftp.password}") String PASSWORD;

	private Logger logger = Logger.getLogger("com.expressway.bill.upload.task");

	public void uploadBill() {
		try {
			// 读取目录
			File directory = new File(LOCAL_DIR);

			if (directory.exists()) {
				// 遍历目录下的所有文件
				for (File file : directory.listFiles()) {
					FileInputStream in = new FileInputStream(file);
					boolean flag = uploadFile(FTP_SERVER, FTP_PORT, USERNAME, PASSWORD, REMOTE_DIR, file.getName(), in);
					logger.debug(flag);

					if (flag == true) {
						File dir = new File(LOCAL_BACKUP);

						if (!dir.exists()) {
							logger.debug("创建Backup文件夹");
							dir.mkdirs();
						}
						logger.debug("已上传文件归档");
						file.renameTo(new File(dir + File.separator + file.getName()));
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
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

package com.web;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.List;

public class FileServlet extends HttpServlet {
    //上传
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("ok");
//        ServletInputStream inputStream = req.getInputStream();
//        byte[] bytes = new byte[102400000];
//        int read = inputStream.read(bytes);
//        System.out.println(new String(bytes,0,  read));

        if (ServletFileUpload.isMultipartContent(req)) {
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
            try {
                List<FileItem> list = servletFileUpload.parseRequest(req);
                for (FileItem fileItem : list) {
                    if (fileItem.isFormField()) {
                        System.out.println("name:" + fileItem.getFieldName() + "\nvalue:" + fileItem.getString());
                    } else {
                        System.out.println("name:" + fileItem.getFieldName() + "\nfilename:" + fileItem.getName());
                        fileItem.write(new File("E:\\" + fileItem.getName()));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //下载
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取文件名
        String filename = "a.txt";
        //用servletcontext读取文件数据
        ServletContext servletContext = getServletContext();
        //设置响应头，文件的类型
        String mimeType = servletContext.getMimeType("/file/" + filename);
        resp.setContentType(mimeType);
        //设置响应头，文件使用方式（附件）和文件名（文件名可与原文件名不同）
        resp.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode("哈哈哈.txt", "UTF-8"));
        //创建输入流和输出流，把输入流读取的数据复制到输出流，再用工具类输出到客户端
        //创建输入流和输出流，把输入流读取的数据复制到输出流，再用工具类输出到客户端
        //创建输入流和输出流，把输入流读取的数据复制到输出流，再用工具类输出到客户端
        InputStream resourceAsStream = servletContext.getResourceAsStream("/file/" + filename);
        ServletOutputStream outputStream = resp.getOutputStream();
        IOUtils.copy(resourceAsStream, outputStream);
    }
}

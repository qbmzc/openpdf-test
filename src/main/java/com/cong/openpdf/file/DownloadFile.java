// package com.cong.openpdf.test.file;

// import java.io.BufferedInputStream;
// import java.io.InputStream;
// import java.io.OutputStream;
// import java.nio.file.Files;
// import java.nio.file.Paths;
// import feign.Response;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;

// import lombok.extern.slf4j.Slf4j;

// @Slf4j
// public class DownloadFile {

//     public void download(Response feignResponse, HttpServletResponse response) throws Exception {

//         try (InputStream inputStream = feignResponse.body().asInputStream();
//                 BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
//                 OutputStream outputStream = response.getOutputStream();) {
//             // 设置ContentType，响应内容为二进制数据流，编码为utf-8，此处设定的编码是文件内容的编码
//             response.setContentType("application/octet-stream;charset=utf-8");
//             // 这一段代码是为了保持服务提供者一致的文件下载输出，其中就包括文件名！
//             response.setHeader("Content-Disposition",
//             feignResponse.headers().get("Content-Disposition").toString().replace("[","").replace("]",""));

//             // 使用64KB的缓冲区
//             byte[] buffer = new byte[1024 * 64];
//             int len;
//             while ((len = bufferedInputStream.read(buffer)) != -1) {
//                 outputStream.write(buffer, 0, len);
//             }
//         } catch (Exception e) {
//             log.error("下载文件异常：{}", e);
//         }
//     }
// }

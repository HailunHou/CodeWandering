/**
 * @author BOOM
 * @create 2023-07-25 20:23
 */
package com.hhl.test;

/**
 @author boom
 @create 2023-07-25 20:23
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AsynchronousRequestExample {
    public static void main(String[] args) {
        try {
            // 创建URL对象
            URL url = new URL("https://jsonplaceholder.typicode.com/posts/1");

            // 创建异步任务线程
            Thread asyncThread = new Thread(() -> {
                try {
                    // 打开连接
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                    // 设置请求方法为GET
                    connection.setRequestMethod("GET");

                    // 发送请求并等待服务器响应
                    int responseCode = connection.getResponseCode();

                    // 读取服务器响应数据
                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String inputLine;
                    StringBuilder response = new StringBuilder();
                    while ((inputLine = reader.readLine()) != null) {
                        response.append(inputLine);
                    }
                    reader.close();

                    // 输出响应结果
                    System.out.println("Response Code: " + responseCode);
                    System.out.println("Response Data: " + response.toString());

                    // 关闭连接
                    connection.disconnect();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            // 启动异步任务线程
            asyncThread.start();

            // 主线程继续执行其他任务
            System.out.println("Main thread continues to do other work...");

            // 等待异步任务线程完成
            asyncThread.join();

            System.out.println("Main thread finished.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

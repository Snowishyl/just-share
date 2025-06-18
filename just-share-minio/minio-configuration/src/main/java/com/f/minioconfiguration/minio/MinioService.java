package com.f.minioconfiguration.minio;

import com.f.justsharecommon.util.SnowflakeIdWorker;
import io.minio.*;
import jakarta.annotation.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class MinioService {

    private final MinioClient minioClient;
    private final String bucketName;
    private final String endpoint;

    @Resource(name = "snowflakeIdWorkerMinio")
    private SnowflakeIdWorker snowflakeIdWorker;

    public MinioService(MinioClient minioClient, MinioProperties props) {
        this.minioClient = minioClient;
        this.bucketName = props.getBucket();
        this.endpoint = props.getEndpoint();
    }

    public void upload(String objectName, InputStream stream, String contentType) throws Exception {
        minioClient.putObject(
                PutObjectArgs.builder()
                        .bucket(bucketName)
                        .object(objectName)
                        .stream(stream, -1, 10485760)
                        .contentType(contentType)
                        .build()
        );
    }

    public InputStream download(String objectName) throws Exception {
        return minioClient.getObject(GetObjectArgs.builder().bucket(bucketName).object(objectName).build());
    }

    public List<String> uploadFiles(List<MultipartFile> files) {
        List<String> urls = new ArrayList<>();
        for (MultipartFile file : files) {
            try {
                String originalFilename = file.getOriginalFilename();
                String objectName = snowflakeIdWorker.nextId() + "-" + originalFilename;

                // 确保桶存在
                boolean found = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
                if (!found) {
                    minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
                }

                // 上传文件
                minioClient.putObject(
                        PutObjectArgs.builder()
                                .bucket(bucketName)
                                .object(objectName)
                                .stream(file.getInputStream(), file.getSize(), -1)
                                .contentType(file.getContentType())
                                .build()
                );

                // 拼接访问 URL（MinIO 需配置静态访问或网关代理）
                String fileUrl = String.format("%s/%s/%s", endpoint, bucketName, objectName);
                urls.add(fileUrl);

            } catch (Exception e) {
                throw new RuntimeException("上传失败: " + file.getOriginalFilename(), e);
            }
        }
        return urls;
    }
}

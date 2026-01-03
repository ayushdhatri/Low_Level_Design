package Low_Level_Design.SOLID.LiskovSubstitutionPrinciple;

import java.util.*;

abstract class FileStorage {
    abstract void uploadFile(String path, byte[] content);
    abstract byte[] downloadFile(String path);
    abstract void deleteFile(String path);
    abstract long getFileSize(String path);
}

class S3Storage extends FileStorage {
    @Override
    void uploadFile(String path, byte[] content) {
        s3Client.putObject(bucket, path, content);
    }
    
    @Override
    byte[] downloadFile(String path) {
        return s3Client.getObject(bucket, path);
    }
    
    @Override
    void deleteFile(String path) {
        s3Client.deleteObject(bucket, path);
    }
    
    @Override
    long getFileSize(String path) {
        return s3Client.getObjectMetadata(bucket, path).getContentLength();
    }
}

class RedisCache extends FileStorage {
    @Override
    void uploadFile(String path, byte[] content) {
        // ❌ PROBLEM: Redis has size limits (512MB)
        if (content.length > 512 * 1024 * 1024) {
            throw new IllegalArgumentException("File too large for Redis cache");
        }
        redis.set(path, content);
    }
    
    @Override
    byte[] downloadFile(String path) {
        return redis.get(path);
    }
    
    @Override
    void deleteFile(String path) {
        redis.del(path);
    }
    
    @Override
    long getFileSize(String path) {
        // ❌ PROBLEM: Redis doesn't efficiently support this
        // Have to fetch entire file just to get size!
        byte[] content = redis.get(path);
        return content != null ? content.length : 0;
    }
}

// Client code
class DocumentService {
    private FileStorage storage;
    
    void storeDocument(String path, byte[] content) {
        // ❌ This works for S3 but fails for RedisCache with large files
        storage.uploadFile(path, content);
    }
    
    void getDocumentInfo(String path) {
        // ❌ This is efficient for S3 but inefficient for RedisCache
        long size = storage.getFileSize(path);
        System.out.println("Document size: " + size);
    }
}

public class BadExample {
    
}
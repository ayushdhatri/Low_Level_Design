
package Low_Level_Design.SOLID.LiskovSubstitutionPrinciple;

import java.util.*;

// Define contracts based on actual guarantees
interface FileStorage {
    StorageResult store(String path, InputStream content, long maxSize);
    Optional<InputStream> retrieve(String path);
    boolean delete(String path);
}

interface FileMetadataSupport {
    FileMetadata getMetadata(String path);
}

class S3Storage implements FileStorage, FileMetadataSupport {
    private static final long MAX_SIZE = 5L * 1024 * 1024 * 1024; // 5GB
    
    @Override
    public StorageResult store(String path, InputStream content, long maxSize) {
        if (maxSize > MAX_SIZE) {
            return StorageResult.failure("File exceeds S3 limits");
        }
        s3Client.putObject(bucket, path, content);
        return StorageResult.success();
    }
    
    @Override
    public Optional<InputStream> retrieve(String path) {
        return Optional.of(s3Client.getObject(bucket, path).getObjectContent());
    }
    
    @Override
    public boolean delete(String path) {
        s3Client.deleteObject(bucket, path);
        return true;
    }
    
    @Override
    public FileMetadata getMetadata(String path) {
        ObjectMetadata meta = s3Client.getObjectMetadata(bucket, path);
        return new FileMetadata(meta.getContentLength(), meta.getLastModified());
    }
}

class RedisCache implements FileStorage {
    private static final long MAX_SIZE = 512 * 1024 * 1024; // 512MB
    
    @Override
    public StorageResult store(String path, InputStream content, long maxSize) {
        if (maxSize > MAX_SIZE) {
            return StorageResult.failure("File exceeds Redis cache limits");
        }
        byte[] data = content.readAllBytes();
        redis.set(path, data);
        return StorageResult.success();
    }
    
    @Override
    public Optional<InputStream> retrieve(String path) {
        byte[] data = redis.get(path);
        return data != null ? Optional.of(new ByteArrayInputStream(data)) : Optional.empty();
    }
    
    @Override
    public boolean delete(String path) {
        return redis.del(path) > 0;
    }
    
    // RedisCache doesn't implement FileMetadataSupport
    // because it can't efficiently provide metadata
}

// Client code properly handles capabilities
class DocumentService {
    private FileStorage primaryStorage;
    private FileStorage cacheStorage;
    
    void storeDocument(String path, byte[] content) {
        long size = content.length;
        
        // Both storage types handle size constraints consistently
        StorageResult result = primaryStorage.store(path, 
            new ByteArrayInputStream(content), size);
        
        if (result.isSuccess()) {
            // Try cache, but handle failure gracefully
            cacheStorage.store(path, new ByteArrayInputStream(content), size);
        }
    }
    
    DocumentInfo getDocumentInfo(String path) {
        // Only request metadata from storages that support it
        if (primaryStorage instanceof FileMetadataSupport) {
            FileMetadataSupport metaStorage = (FileMetadataSupport) primaryStorage;
            FileMetadata meta = metaStorage.getMetadata(path);
            return new DocumentInfo(path, meta.getSize(), meta.getLastModified());
        }
        
        // Fallback: retrieve to get info (acceptable for cache scenarios)
        Optional<InputStream> content = primaryStorage.retrieve(path);
        return content.map(this::buildInfoFromContent)
                     .orElse(DocumentInfo.notFound(path));
    }
}
public class GoodExample {
    
}

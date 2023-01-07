package com.mongodemov3.config;

import ch.qos.logback.core.UnsynchronizedAppenderBase;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.MongoCollection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.Document;
import org.springframework.stereotype.Component;


/**
 * MongoDBAppender适配类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class MongoDBAppenderBase<E> extends UnsynchronizedAppenderBase<E> {

    protected String source;
    private MongoClient mongo;
    private MongoCollection<Document> eventsCollection;
    private String host = "127.0.0.1"; // 地址
    private int port = 27017;           // 端口号
    private String dbName = "springboot";       // 库名
    private String collectionName;      // 集合名
    private int connectionsPerHost = 10000; // 空闲线程池中最大链接数
    private int threadsAllowedToBlockForConnectionMultiplier = 5000; //一个线程等待链接可用的最大等待毫秒数
    private int maxWaitTime = 1000 * 60 * 2;  // 最长等待时间
    private int connectTimeout;
    private int socketTimeout;
    private int wtimeout;

    MongoDBAppenderBase(String collectionName) {
        this.collectionName = collectionName;
    }

    @Override
    public void start() {
        super.start();
    }


    private MongoClientOptions buildOptions() {
        final MongoClientOptions.Builder options = new MongoClientOptions.Builder();
        options.connectionsPerHost(connectionsPerHost);
        options.threadsAllowedToBlockForConnectionMultiplier(threadsAllowedToBlockForConnectionMultiplier);
        options.maxWaitTime(maxWaitTime);
        options.connectTimeout(connectTimeout);
        options.socketTimeout(socketTimeout);
        options.maxWaitTime(wtimeout);
        return options.build();
    }

    protected abstract Document toMongoDocument(E event);


    @Override
    protected void append(E eventObject) {
        eventsCollection.insertOne(toMongoDocument(eventObject));
    }

    @Override
    public void stop() {
        if (mongo != null)
            mongo.close();
        super.stop();
    }

}
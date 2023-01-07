package com.mongodemov3.config;


import ch.qos.logback.classic.spi.ILoggingEvent;
import org.bson.Document;

import java.util.Date;

/**
 * MongoDB适配文档输出内容定义
 */
public class MongoDBAppender extends MongoDBAppenderBase<ILoggingEvent> {

    public MongoDBAppender() {
        super("logdbs");
    }

    @Override
    protected Document toMongoDocument(ILoggingEvent eventObject) {

        final Document doc = new Document();
        //doc.append("date", new JDateTime(eventObject.getTimeStamp()).toString("YYYY-MM-DD hh:mm:ss"));
        doc.append("date", new Date());
        doc.append("source", source);
        doc.append("level", eventObject.getLevel().toString());
        doc.append("logger", eventObject.getLoggerName());
        doc.append("thread", eventObject.getThreadName());
        doc.append("message", eventObject.getFormattedMessage());
        if (eventObject.getMDCPropertyMap() != null && !eventObject.getMDCPropertyMap().isEmpty())
            doc.append("mdc", eventObject.getMDCPropertyMap());
        return doc;
    }
}



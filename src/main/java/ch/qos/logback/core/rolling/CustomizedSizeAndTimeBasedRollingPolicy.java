package ch.qos.logback.core.rolling;

import ch.qos.logback.core.util.FileSize;

/**
 * @Project: spring-boot-demo
 * @Author : haihuab
 * @Date : 2022/12/15 10:35
 * @Description:
 */


public class CustomizedSizeAndTimeBasedRollingPolicy<E> extends TimeBasedRollingPolicy<E> {
    FileSize maxFileSize;

    @Override
    public void start() {
        if (this.maxFileSize == null) {
            this.addError("maxFileSize property is mandatory.");
        } else {
            this.addInfo("Archive files will be limited to [" + this.maxFileSize + "] each.");
            ((SizeAndTimeBasedFNATP)this.timeBasedFileNamingAndTriggeringPolicy).setMaxFileSize(this.maxFileSize);
            if (!this.isUnboundedTotalSizeCap() && this.totalSizeCap.getSize() < this.maxFileSize.getSize()) {
                this.addError("totalSizeCap of [" + this.totalSizeCap + "] is smaller than maxFileSize [" + this.maxFileSize + "] which is non-sensical");
            } else {
                super.start();
            }
        }
    }

    public void setMaxFileSize(FileSize aMaxFileSize) {
        this.maxFileSize = aMaxFileSize;
    }

}

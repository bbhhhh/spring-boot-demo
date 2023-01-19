package ch.qos.logback.core.rolling;

import java.util.Calendar;
import java.util.Date;

import ch.qos.logback.core.joran.spi.NoAutoStart;

/**
 * @Project: spring-boot-demo
 * @Author : haihuab
 * @Date : 2022/12/14 17:05
 * @Description:
 */

@NoAutoStart
public class CustomizedTimePeriodTriggeringPolicy<E> extends SizeAndTimeBasedFNATP<E> {
    private int intervals = 1;


    @Override
    public void start() {
        if (intervals < 1){
            intervals = 1 ;
        }
        super.start();
    }

    private Date getAlignTime(long timeStamp){
        Calendar calendar = Calendar.getInstance() ;
        calendar.setTimeInMillis(timeStamp) ;
        if (intervals == 1 ){
            return calendar.getTime() ;
        }

        switch(rc.getPeriodicityType()){
            case TOP_OF_MINUTE:
                calendar.set(Calendar.MINUTE,calendar.get(Calendar.MINUTE)/intervals * intervals);
                break;
            default:
                break;
        }

        return calendar.getTime();
    }

    @Override
    protected void setDateInCurrentPeriod(long now) {
        this.dateInCurrentPeriod = getAlignTime(now);
    }

    @Override
    public void setDateInCurrentPeriod(Date _dateInCurrentPeriod) {
        setDateInCurrentPeriod(_dateInCurrentPeriod.getTime());
    }

    @Override
    protected void computeNextCheck() {
        nextCheck = rc.getEndOfNextNthPeriod(dateInCurrentPeriod, intervals).getTime() ;
    }

    public void setIntervals(int intervals) {
        this.intervals = intervals;
    }

    @Override
    public String toString() {
        return this.getClass().getName();
    }
}

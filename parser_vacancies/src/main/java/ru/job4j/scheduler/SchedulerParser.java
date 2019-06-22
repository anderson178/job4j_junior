package ru.job4j.scheduler;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.Config;

import static org.quartz.TriggerBuilder.newTrigger;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 02.07.2019
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SchedulerParser {
    static final Logger LOG = LoggerFactory.getLogger(SchedulerParser.class.getName());

    public void start(String properties) {
        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();
            JobDetail jobDetail = JobBuilder.newJob(JobParser.class).build();
            JobDataMap jobDataMap = jobDetail.getJobDataMap();
            jobDataMap.put("nameProperties", properties);
            Trigger trigger = newTrigger().withIdentity("trigger")
                    .startNow()
                    .withSchedule(CronScheduleBuilder.cronSchedule(Config.gerCronTime(properties)))
                    .startNow()
                    .build();
            scheduler.scheduleJob(jobDetail, trigger);

        } catch (SchedulerException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    public static void main(String[] args)  {
       new SchedulerParser().start(args[0]);
    }
}

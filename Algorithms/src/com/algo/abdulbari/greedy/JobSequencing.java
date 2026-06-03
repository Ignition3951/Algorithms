package com.algo.abdulbari.greedy;

import com.algo.abdulbari.greedy.model.Job;
import com.algo.abdulbari.greedy.util.JobComparator;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JobSequencing {

    private static final Logger LOGGER = Logger.getLogger(JobSequencing.class.getName());

    public static void main(String[] args) {
        LOGGER.log(Level.INFO,"JOB SEQUENCING PROBLEM");

        Job job1 = new Job("Job1", 20, 2);
        Job job2 = new Job("Job2", 15, 2);
        Job job3 = new Job("Job3", 10, 1);
        Job job4 = new Job("Job4", 5, 3);
        Job job5 = new Job("Job5", 1, 3);

        Job[] jobs = {job1, job2, job3, job4, job5};
        Arrays.sort(jobs,new JobComparator());
        Job[] scheduledJobs = new Job[jobs.length];
        Arrays.fill(scheduledJobs, null);
        LOGGER.log(Level.INFO,"Jobs sorted by profit in descending order: {0}",Arrays.toString(jobs));
        for(Job job : jobs) {
            LOGGER.log(Level.INFO,"Job: {0}, Profit: {1}, Deadline: {2}", new Object[]{job.getName(), job.getProfit(), job.getDeadline()});
            for(int i=job.getDeadline();i>0;i--){
                if(scheduledJobs[i]==null){
                    scheduledJobs[i]=job;
                    break;
                }
            }
        }
        LOGGER.log(Level.INFO,"Scheduled Jobs: {0}",Arrays.toString(scheduledJobs));
    }
}
